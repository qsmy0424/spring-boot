package com.qsmy.springboot.config;

import com.qsmy.springboot.bean.User;

import java.util.*;

/**
 * @author qsmy
 * @date 2019-07-10
 */
public class DBCache {
    /**
     * K    角色ID
     * V    用户信息
     */
    public static final Map<String, User> USERS_CACHE = new HashMap<>();
    /**
     * K    角色ID
     * V    权限编码
     */
    public static final Map<String, Collection<String>> PERMISSIONS_CACHE = new HashMap<>();

    static {
        // 假设为数据库记录
        USERS_CACHE.put("u1", new User(1L, "u1", "p1", "admin", true));
        USERS_CACHE.put("u2", new User(2L, "u2", "p2", "admin", false));
        USERS_CACHE.put("u3", new User(3L, "u3", "p3", "test", true));

        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list", "user:add", "user:edit"));
        PERMISSIONS_CACHE.put("test", Collections.singletonList("user:list"));
    }

}
