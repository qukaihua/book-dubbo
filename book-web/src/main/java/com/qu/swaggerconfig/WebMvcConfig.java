package com.qu.swaggerconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 96283 on 2018/10/11.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/") ;

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");



    }





}
