package com.example.onlinejudge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
//    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;


    @Test
    void test04() {
        secondaryJdbcTemplate.execute("SELECT * FROM user", (PreparedStatement ps) -> {
            try (ResultSet rs = ps.executeQuery()) {    // ==> ps.execute(); ResultSet rs = ps.getResultSet();
                ResultSetMetaData metaData = rs.getMetaData(); // 记录集统计数据
                List<List<Object>> results = new ArrayList<>();
                while (rs.next()) {
                    List<Object> result = new ArrayList<>();
                    for (int i = 1; i <= metaData.getColumnCount() ; i++) {
                        result.add(rs.getObject(i));
                    }
                    results.add(result);
                }
                System.out.println(results);
                return results;
            }
        });
    }

    @Test
    void test05() {
        secondaryJdbcTemplate.execute("update user set nickname = '丁真' where username like '%理塘丁真%'", (PreparedStatement ps) -> {
            int count = ps.executeUpdate();
            System.out.println(count);
            return count;
        });
    }
}
