package com.crm_system.springbootback.config;
import com.crm_system.springbootback.tool.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authentication())
                .addPathPatterns("/**");
    }
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }
}