package com.qsmy.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qsmy
 * @date 2019-07-10
 */
@Slf4j
@Configuration
public class ShiroConfiguration {

    @Bean
    public EhCacheManager getEhcacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return ehCacheManager;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    // /**
    //  * 加密器
    //  *
    //  * @return hashedCredentialsMatcher
    //  */
    // @Bean
    // public HashedCredentialsMatcher hashedCredentialsMatcher() {
    //     HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
    //     // 散列算法：这里使用MD5算法
    //     hashedCredentialsMatcher.setHashAlgorithmName("md5");
    //     // 散列的次数，比如散列两次，相当于md5(md5(""))
    //     hashedCredentialsMatcher.setHashIterations(2);
    //     return hashedCredentialsMatcher;
    // }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    @Bean(name = "authRealm")
    public AuthRealm authRealm(EhCacheManager cacheManager) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCacheManager(cacheManager);
        return authRealm;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(AuthRealm authRealm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(authRealm);
        // 用户授权/认证信息Cache，采用Ehcache 缓存
        webSecurityManager.setCacheManager(getEhcacheManager());
        return webSecurityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/denied");
        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    /**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     * @param shiroFilterFactoryBean
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        // 下列规则配置最好配置到配置文件中
        // 过滤顺序一定要根据自己需要配置
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 需要验证的写 authc 不需要的写 anon
        filterChainDefinitionMap.put("/resource/**", "anon");
        filterChainDefinitionMap.put("/hello", "anon");

        // anon:它对应的过滤器里面是空的，什么都没做
        log.info("###########从数据库读取权限规则，加载到shiroFilter中###########");

        // 不用注解也可以通过API方式加载权限规则
        Map<String, String> permissions = new LinkedHashMap<>();
        permissions.put("/users/find", "perms[user:find]");
        filterChainDefinitionMap.putAll(permissions);
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }

}
