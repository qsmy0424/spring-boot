package com.qsmy.springboot.bean;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author qsmy
 * @desctiption TODO
 * @date 2019-04-11 16:14
 */
public class UserSql {
    public String getList(UserParam userParam) {
        StringBuffer sql = new StringBuffer("select id, userName, passWord, user_s ex as userSex, nick_name as nickName");
        sql.append(" from users where 1=1 ");
        if (userParam != null) {
            if (StringUtils.isNotBlank(userParam.getUserName())) {
                sql.append(" and userName = #{userName}");
            }
            if (StringUtils.isNotBlank(userParam.getUserSex())) {
                sql.append(" and user_sex = #{userSex}");
            }
        }
        sql.append(" order by id desc");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        return sql.toString();
    }

    public String getCount(UserParam userParam) {
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("users");
            if (StringUtils.isNotBlank(userParam.getUserName())) {
                WHERE("userName = #{userName}");
            }
            if (StringUtils.isNotBlank(userParam.getUserSex())) {
                WHERE("user_sex = #{userSex}");
            }
        }};
        return sql.toString();
    }
}
