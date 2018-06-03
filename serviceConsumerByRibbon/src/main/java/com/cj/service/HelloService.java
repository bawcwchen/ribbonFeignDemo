package com.cj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wb-cj189958
 * @date 2018/6/1 18:50
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello1(String name) {
        return restTemplate.getForObject("http://serviceProvider/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello," + name + ",error!";
    }
}
