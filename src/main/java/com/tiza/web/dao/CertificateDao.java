package com.tiza.web.dao;

import com.tiza.web.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

/**
 * Description: CertificateDao
 * Author: DIYILIU
 * Update: 2017-12-06 10:22
 */

@Repository
public class CertificateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Operator findOperator(String operatorId) {

        String sql = "SELECT id, operatorId, name, secret FROM BS_OPERATOR WHERE operatorId=?";

        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Operator operator = new Operator();
            operator.setId(rs.getLong("id"));
            operator.setOperatorId(rs.getString("operatorId"));
            operator.setName(rs.getString("name"));
            operator.setSecret(rs.getString("secret"));

            return operator;
        }, new Object[]{operatorId});
    }
}
