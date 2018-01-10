package com.app.config;

import com.app.config.beans.MvcConfig;
import org.springframework.lang.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringSecurity.class, JpaConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Nullable
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncoding = new CharacterEncodingFilter();
        characterEncoding.setEncoding("UTF-8");
        characterEncoding.setForceEncoding(true);
        return new Filter[]{characterEncoding};
    }

    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {

        if (filter instanceof CharacterEncodingFilter) {
            FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", filter);
            characterEncoding.addMappingForUrlPatterns(null, true, "/*");
            return characterEncoding;
        } else {
            return super.registerServletFilter(servletContext, filter);
        }
    }

}
