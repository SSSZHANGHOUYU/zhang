package com.dj.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.ssm.common.BusinessException;
import com.dj.ssm.pojo.User;

public interface UserService extends IService<User> {
    User getUser(User user) throws BusinessException;

    void add(User user) throws BusinessException;
}
