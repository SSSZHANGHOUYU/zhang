package com.dj.ssm.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ssm.common.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private ResultModel login(User user, HttpSession session) throws Exception{
            Assert.hasText(user.getUsername(),"用户名不能为空");
            Assert.hasText(user.getPassword(),"密码不能为空");
            User loginUser = userService.getUser(user);
            session.setAttribute("USER", user);
            return new ResultModel().success();
    }

    @PostMapping("/update")
    private ResultModel update(User user) throws Exception{
            userService.saveOrUpdate(user);
            return new ResultModel().success();
    }

    @PostMapping("/add")
    private ResultModel add(User user){
            Assert.hasText(user.getUsername(), "用户名不能为空");
            Assert.hasText(user.getPassword(), "密码不能为空");
            userService.add(user);
            return new ResultModel().success();
    }
}
