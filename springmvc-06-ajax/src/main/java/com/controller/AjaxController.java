package com.controller;

import com.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        if ("c137".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> userList = new ArrayList<>();

        //添加数据
        userList.add(new User("c137", 18, "男"));
        userList.add(new User("c138", 18, "女"));
        userList.add(new User("c139", 18, "男"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null) {
            //应该从数据库中查询数据，这里简化了
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            //应该从数据库中查询数据，这里简化了
            if ("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码错误";
            }
        }
        return msg;
    }
}
