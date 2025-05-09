package org.bea.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override //....
    protected String[] getServletMappings(){
        return new String[] { "/" };
    }

    @Override //...
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[] { DataSourceConfiguration.class };
    }

    @Override //.....
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[] { WebConfiguration.class };
    }
}