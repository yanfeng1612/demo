package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot Main 程序方法入口
 * @author model-driven
 * @date 2020-11-30
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.demo.dao"})
public class Bootstrap {

    /**
     * 程序启动入口
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

}
