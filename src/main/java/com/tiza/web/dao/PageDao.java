package com.tiza.web.dao;

import com.tiza.support.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Description: PageDao
 * Author: DIYILIU
 * Update: 2017-12-08 09:58
 */

public class PageDao {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String dialect = "oracle";
    protected JdbcTemplate jdbcTemplate;

    public String buildPageSql(String sql, Object[] params, Pagination pagination) {
        int offset = pagination.getOffset();
        int limit = pagination.getLimit();

        // 设置分页参数
        setPageParameter(sql, params, pagination);

        if (dialect.equalsIgnoreCase("mysql")) {

            return buildPageSqlForMysql(sql, offset, limit).toString();
        }

        if (dialect.equalsIgnoreCase("oracle")) {

            return buildPageSqlForOracle(sql, offset, limit).toString();
        }

        return null;
    }

    private StringBuilder buildPageSqlForMysql(String sql, int offset, int limit) {
        StringBuilder pageSql = new StringBuilder(sql);
        pageSql.append(" limit " + offset + "," + limit);
        return pageSql;
    }

    private StringBuilder buildPageSqlForOracle(String sql, int offset, int limit) {
        StringBuilder pageSql = new StringBuilder();
        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(offset + limit);
        pageSql.append(") where row_id > ").append(offset);
        return pageSql;
    }

    /**
     * 从数据库里查询总的记录数，回写进分页参数
     *
     * @param sql
     * @param params
     * @param pagination
     */
    private void setPageParameter(String sql, Object[] params, Pagination pagination) {
        // 记录总记录数
        String countSql = "select count(0) from (" + sql + ")";

        if (dialect.equalsIgnoreCase("mysql")) {
            countSql += " as total";
        }

        long total = jdbcTemplate.queryForObject(countSql, params, Long.class);
        pagination.setTotal(total);
    }


    public boolean update(String sql, Object[] values) {
        int result = jdbcTemplate.update(sql, values);
        if (result > 0) {

            return true;
        }

        return false;
    }

    public boolean update(String sql) {

        return update(sql, null);
    }
}
