package com.bamboo.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor interceptor = new PaginationInterceptor();
        //亲求大于最后一页时， 回到首页
        interceptor.setOverflow(true);
        //每页最大行数
        interceptor.setLimit(100);
        return interceptor;
    }
}
