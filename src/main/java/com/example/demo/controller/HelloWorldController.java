package com.example.demo.controller;

import com.example.demo.bean.configBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({configBean.class})
public class HelloWorldController {
    @Autowired
    configBean configBean;

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/hello")
    public String index() {
        return name+":"+age;
    }

    @RequestMapping(value="/lucya")
    public String lucy(){
        return configBean.getGreeting()+">>>>>>"+configBean.getName()+">>>>>"+configBean.getUuid()+">>>>>"+configBean.getValue()+">>>>"+configBean.getAge()+">>>"+configBean.getMax()+">>>>"+
                configBean.getNumber();
    }
}