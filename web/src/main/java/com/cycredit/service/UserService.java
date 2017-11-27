package com.cycredit.service;

import com.cycredit.dao.entity.User;
import com.cycredit.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2017/11/21 0021.
 *
 * @author qiyubin
 */
@Service
public class UserService {


    @Resource
    UserMapper userMapper;

    public User findById(Long id) {

        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void save(User user) {
        if (user.getId() == null) {
            userMapper.insertSelective(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
    }


}
