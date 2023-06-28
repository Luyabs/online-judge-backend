package com.example.onlinejudge.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcTemplateBean {
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过jdbctemplate执行Ddl
     * @param sql DDL
     */
    public void execute(String sql) {
        jdbcTemplate.execute(sql);
        System.out.println("[execute]\n" + sql);
    }

    /**
     * 通过jdbctemplate执行DQL
     * @param sql DQL
     */
    public List<List<Object>> query(String sql) {
        System.out.println("[query]\n" + sql);
        return jdbcTemplate.execute(sql, (PreparedStatement ps) -> {
            try (ResultSet rs = ps.executeQuery()) {    // ==> ps.query(); ResultSet rs = ps.getResultSet();
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

    /**
     * 通过jdbctemplate执行DML
     */
    public int update(String sql) {
        System.out.println("[update]\n" + sql);
        return jdbcTemplate.update(sql);
    }
}
