package org.zerock.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    {
        System.out.println("static..");
    }

    public RootConfig() {
        System.out.println("construct Root Config");
    }
}
