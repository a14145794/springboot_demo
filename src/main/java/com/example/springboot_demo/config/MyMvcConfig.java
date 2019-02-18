package com.example.springboot_demo.config;

import com.example.springboot_demo.component.MyLocaleResolver;
import com.example.springboot_demo.component.loginHandlerIntercetor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//全面接管SpringMVC
//@EnableWebMvc
@Configuration //不需要写spring的xml配置  可以直接写这个标签 说明这个类是配置类
//extends WebMvcConfigurerAdapter  这个已经过时了
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/su").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new loginHandlerIntercetor());
        interceptor.addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/**","/asserts/**","/webjars/**");

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
