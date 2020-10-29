package com.dj.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ssm.common.BusinessException;
import com.dj.ssm.mapper.UserMapper;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUser(User user) throws BusinessException {

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("username", user.getUsername());
            User onlyUser = super.getOne(wrapper);
//            Assert.notNull(onlyUser, "不存在该用户");
//            Assert.isTrue(onlyUser.getPassword().equals(user.getPassword()), "密码错误");
            if(onlyUser == null){
                throw new BusinessException("不存在该用户");
            }
            if(!onlyUser.getPassword().equals(user.getPassword())){
                throw new BusinessException("密码错误");
            }
            return onlyUser;
    }

    @Override
    public void add(User user) throws BusinessException {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", user.getUsername());
        if(null == getOne(wrapper));
        Assert.isNull(userService.,"用户名已重复");
    }
}
