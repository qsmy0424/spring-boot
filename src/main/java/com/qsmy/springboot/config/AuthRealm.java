package com.qsmy.springboot.config;

import com.qsmy.springboot.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

/**
 * @author qsmy
 * @date 2019-07-10
 */
// @Configuration
public class AuthRealm extends AuthorizingRealm {

    /**
     * 只有需要验证权限时才会调用，授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，在配有缓存的情况下，只加载一次。
     * 如果需要动态权限，但是又不想每次去数据库校验，可以存在ehcache中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        // 权限信息对象info，用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用户的角色集合
        Set<String> roles = new HashSet<>();
        roles.add(user.getRoleName());
        info.setRoles(roles);
        // 用户的角色对应的所有权限
        // 只有角色并没有颗粒到每一个按钮 或 操作选项 PERMISSIONS是可选项
        final Map<String, Collection<String>> permissionCache = DBCache.PERMISSIONS_CACHE;
        final Collection<String> permissions = permissionCache.get(user.getRoleName());
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证回调函数,登录时调用
     * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
     * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
     * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user = Optional.ofNullable(DBCache.USERS_CACHE.get(principal))
                .orElseThrow(UnknownAccountException::new);
        if (user.isLocked()) {
            throw new LockedAccountException();
        }

        // 从数据库查询出来的账号名与密码，与用户输入的账号与密码对比
        // 当用户执行登录时，在方法处理上要实现 user.login(token)
        // 然后会自动进入这个类进行认证
        // 交给 AuthenticatingRealm 使用CredentialsMatcher 进行密码匹配，可以自定义实现
        // 如果使用HashedCredentialsMatcher 这里认证方式要改下：
        // SimpleAuthenticationInfo authenticationInfo =
        // new SimpleAuthenticationInfo(principal, "密码", ByteSource.Util.bytes("密码盐"), getName());
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(principal, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);
        return authenticationInfo;
    }
}
