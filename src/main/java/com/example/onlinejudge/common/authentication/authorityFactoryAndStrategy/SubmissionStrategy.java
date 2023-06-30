package com.example.onlinejudge.common.authentication.authorityFactoryAndStrategy;

import com.example.onlinejudge.common.authentication.UserInfo;
import com.example.onlinejudge.common.exception.exception.NoAccessException;
import com.example.onlinejudge.common.exception.exception.ServiceException;
import com.example.onlinejudge.entity.Submission;
import com.example.onlinejudge.service.SubmissionService;
import com.example.onlinejudge.vo.ProblemModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubmissionStrategy  implements AuthorityStrategy {
    @Autowired
    private SubmissionService submissionService;
    @Override
    public void execute(Object arg0) {
        if (arg0.getClass() == Long.class)
            isOwner((Long) arg0);
        else
            ServiceException.throwException("SubmissionStrategy中 " + arg0 + " 无法解析");
    }

    @Override
    public void isOwner(long submissionId) {
        Submission submission = submissionService.getByIdNotNull(submissionId);
        if(!submission.getUserId().equals(UserInfo.getUserId()))
            NoAccessException.throwException(submissionId, "问题");
    }
}
