package com.cj.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 默认是负载均衡的
 * @author wb-cj189958
 * @date 2018/6/1 19:13
 */
@FeignClient(value = "serviceProvider",fallback = HelloServiceImpl.class)
public interface HelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
