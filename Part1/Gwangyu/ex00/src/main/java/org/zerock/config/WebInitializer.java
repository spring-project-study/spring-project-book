package org.zerock.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public static Logger logger = LoggerFactory.getLogger(WebInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {   //root-context.xml을 구현
        logger.debug("initWebConfig {}", "getRootConfigClasses");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
