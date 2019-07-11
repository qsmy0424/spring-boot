package com.qsmy.springboot.interceptor;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.qsmy.springboot.annotation.LocalLock;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author qsmy
 * @date 2019-07-10
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

    public static final Cache<String, Object> CACHE = CacheBuilder.newBuilder()
            // 最大缓存1000个
            .maximumSize(1000)
            // 设置写缓存后5秒钟过期
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @Around("execution(public * *(..)) && @annotation(com.qsmy.springboot.annotation.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(), pjp.getArgs());
        if (!StringUtils.isBlank(key)) {
            if (CACHE.getIfPresent(key) != null) {
                throw new RuntimeException("请勿重复提交！");
            }
            // 如果是第一次提交，就将key当前对象压入缓存中
            CACHE.put(key, key);
        }

        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * key的生成策略，如果想灵活可以写成接口与实现类的方式
     * @param keyExpress 表达式
     * @param args 参数
     * @return 生成的key
     */
    private String getKey(String keyExpress, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("args[" + i + "]", args[i].toString());
        }
        return keyExpress;
    }

}
