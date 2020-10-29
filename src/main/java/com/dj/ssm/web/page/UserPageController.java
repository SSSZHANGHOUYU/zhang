package com.dj.ssm.web.page;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    private String toLogin(){
        return "user/login";
    }

    @RequestMapping("/toShow")
    private String toShow(ModelMap model){
        List<User> listUsers = userService.list();
        model.put("listUsers", listUsers);
        return "user/show";
    }

    @RequestMapping("/toUpdate/{userId}")
    private String toUpdate(ModelMap model, @PathVariable("userId") Integer userId){
        User updUser = userService.getById(userId);
        model.put("updUser", updUser);
        return "user/update";
    }

    @RequestMapping("/toAdd")
    private String toAdd(){
        return "user/add";
    }
}
