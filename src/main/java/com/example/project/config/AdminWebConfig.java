package com.example.project.config;

import com.example.project.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }
/*
定义静态资源  /aa/**访问aa路径下的所有请求都去classpath:/static/匹配
 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
    //    @Bean
    /*public WebMvcRegistrations webMvcRegistrations(){
        return new WebMvcConfigurer(){
            public RequestMappingHandlerMapping requestMappingHandlerMapping(){
                return null;
            }
        };
    }*/
}
