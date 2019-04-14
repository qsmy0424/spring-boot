package com.qsmy.springboot.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(final WebRequest webRequest, final boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.remove("trace");
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", WebRequest.SCOPE_REQUEST);
        map.put("test", "qsmy");
        map.put("ext", ext);
        return map;
    }
}
