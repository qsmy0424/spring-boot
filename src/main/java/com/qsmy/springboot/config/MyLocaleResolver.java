package com.qsmy.springboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(final HttpServletRequest request) {
        String lange = request.getParameter("lange");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(lange)) {
            String[] s = lange.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(final HttpServletRequest request, final HttpServletResponse response, final Locale locale) {

    }
}
