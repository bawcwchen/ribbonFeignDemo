package com.cj;

import com.cj.service.HelloService;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign方式消费服务
 * @author wb-cj189958
 * @date 2018/6/1 18:50
 */
@SpringBootApplication
@EnableDiscoveryClient
//改注解包含断路器功能，不包含断路器仪表盘功能
@EnableFeignClients
@RestController
//以下2个注解，是启用仪表盘功能
@EnableHystrixDashboard
//@EnableCircuitBreaker
@EnableHystrix
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Autowired
    private HelloService helloService;

    @Bean
    public IRule weightedResponseTimeRule() {
        return new WeightedResponseTimeRule();//这里配置策略，和配置文件对应
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return helloService.hello(name);
    }
}
