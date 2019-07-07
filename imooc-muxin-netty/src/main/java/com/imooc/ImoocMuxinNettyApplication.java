package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * description : 启动类
 *
  * @param
 * @return
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
@ComponentScan(basePackages = {"com.imooc"})
public class ImoocMuxinNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocMuxinNettyApplication.class, args);
    }

}
