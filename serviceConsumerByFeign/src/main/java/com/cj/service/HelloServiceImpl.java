package com.cj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wb-cj189958
 * @date 2018/6/1 19:13
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "sorry" + name;
    }
}
