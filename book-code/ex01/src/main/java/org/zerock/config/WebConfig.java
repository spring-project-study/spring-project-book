package org.zerock.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
