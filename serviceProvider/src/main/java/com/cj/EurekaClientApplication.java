package com.cj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者集群
 *
 * @author wb-cj189958
 * @date 2018/5/26 20:56
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        //模拟响应时间，ribbon按权重分配请求
        if ("8762".equals(port)) {
            for (int i = 0; i < 10000; i++) {
            }
        }
        return "Client request param, name:" + name + ",Server port:" + port;
    }
}
