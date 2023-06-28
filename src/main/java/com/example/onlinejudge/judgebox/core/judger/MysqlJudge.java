package com.example.onlinejudge.judgebox.core.judger;

import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.common.jdbcTemplateBean;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.entity.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Mysql判题机
 */
@Component
public class MysqlJudge implements Judge {
    private enum Type {
        DQL,
        DML,
        DDL,
        NULL
    }

    @Autowired
    private com.example.onlinejudge.common.jdbcTemplateBean jdbcTemplateBean;

    /**
     * 外观判断方法，只允许外部类调用此方法
     */
    @Override
    public Submission judge(Submission submission, List<TestCase> testCases) {
        String code = submission.getCode();
        if (code.split(";").length > 1) {
            return setSubmissionErrorType(submission, "在SQL题中你只能提交一句输入");
        }

        Type type = getCodeType(code);
        if (type != Type.DQL && type != Type.DML) {
            return setSubmissionErrorType(submission, "只允许提交DQL与DML语句");
        }

        int passNum = 0;    // 通过测试用例个数
        int preOrPostHandleNum = 0;  // 前置或后置处理用例个数
        for (TestCase testCase: testCases) {
            // 根据不同的回答类型 做不同判断处理
            try {
                executeTestCaseInputCode(testCase); // 先执行测试用例的输入 (只允许 空/DDL/DML)
                if (testCase.getIsPrehandle() || testCase.getIsPosthandle()) {
                    preOrPostHandleNum++;  // 前后置处理语句
                    continue;
                }
                boolean testResult = (type == Type.DQL) ? executeDqlTestCaseOutputCode(code, testCase) : executeDmlTestCaseOutputCode(code, testCase);
                passNum += testResult ? 1 : 0;  // 测试用例通过则增加通过数
            } catch (BadSqlGrammarException ex) {   // 抛掷的异常 都在这转给submission
                String exMessage = ex.getMessage();
                if (!StringUtils.isBlank(exMessage) && exMessage.startsWith("PreparedStatementCallback; bad SQL grammar")) {
                    return setSubmissionErrorType(submission,exMessage.split(";")[1]);
                }
                return setSubmissionErrorType(submission,exMessage);
            } catch (ServiceException ex) {
                return setSubmissionErrorType(submission, ex.getMessage());
            }
        }
        submission.setPassTestCaseNum(passNum); // 设置结果
        if (passNum == testCases.size() - preOrPostHandleNum) {
            return submission.setIsSuccess(true);
        }
        else {
            return setSubmissionErrorType(submission, "Wrong Answer");
        }
    }

    /**
     * 测试问题 输入
     */
    private void executeTestCaseInputCode(TestCase testCase) {
        // 先执行测试用例的输入 (只允许 空/DDL/DML)
        String inputSentences = testCase.getInput();
        for (String input : inputSentences.split(";")) {
            if (!StringUtils.isBlank(input)) {
                switch (getCodeType(input)) {
                    case DDL -> jdbcTemplateBean.execute(input);
                    case DML -> jdbcTemplateBean.update(input);
                    default -> ServiceException.throwException("[测试用例异常] 该INPUT语句应为 空/DDL/DML");
                }
            }
        }
    }

    /**
     * 测试类型为DQL的问题 输出
     * @param code DQL
     * @param testCase input: DML(多句), output: DQL(单句) (若为pre/posthandle 则input: DDL(多句) output: null)
     */
    private boolean executeDqlTestCaseOutputCode(String code, TestCase testCase) {
        // 执行用户代码 和 output中的select语句
        String output = testCase.getOutput();
        if (getCodeType(output) != Type.DQL)
            ServiceException.throwException("[测试用例异常] 该OUTPUT语句应为DQL");
        // 判断结果是否正确
        List<List<Object>> submissionAnswer = jdbcTemplateBean.query(code);
        List<List<Object>> trueAnswer = jdbcTemplateBean.query(output);
        return submissionAnswer.equals(trueAnswer);
    }

    /**
     * 测试类型为DML的问题 输出
     * @param code DML
     * @param testCase input: null, output: int(表示修改行行数) (若为pre/posthandle 则input: DDL(多句) output: null)
     */
    private boolean executeDmlTestCaseOutputCode(String code, TestCase testCase) {
        // 执行用户代码 和 output中的select语句
        int output = Integer.parseInt(testCase.getOutput());
        // 判断结果是否正确
        int submissionAnswer = jdbcTemplateBean.update(code);
        return submissionAnswer == output;
    }

    /**
     * 根据句首判断是DQL DML DDL·
     */
    private Type getCodeType(String code) {
        if (StringUtils.isBlank(code))
            return Type.NULL;
        code = code.trim().toLowerCase();
        if (code.startsWith("select"))
            return Type.DQL;
        else if (code.startsWith("update") || code.startsWith("insert") || code.startsWith("delete"))
            return Type.DML;
        else if (code.startsWith("create table") || code.startsWith("drop table")) {
            return Type.DDL;
        }
        else
            return Type.NULL;
    }

    /**
     * 设置submission错误原因
     */
    private Submission setSubmissionErrorType(Submission submission, String errorType) {
        submission.setIsSuccess(false);
        submission.setErrorType(errorType);
        return submission;
    }
}
