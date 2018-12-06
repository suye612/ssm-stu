package com.ytj.ssm.util.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: amin
 * @Date: 2018/12/6 16:59
 * @Description:
 */
@Configuration
public class DefaultWebConfig extends WebMvcConfigurationSupport {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
