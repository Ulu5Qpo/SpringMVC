package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/j1")
    @ResponseBody //不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("c137", 18, "男");

        String str = mapper.writeValueAsString(user);

        return str;
    }
}
