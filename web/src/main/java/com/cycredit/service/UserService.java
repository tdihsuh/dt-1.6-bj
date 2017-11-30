package com.cycredit.service;

import com.cycredit.dao.entity.User;
import com.cycredit.dao.entity.UserExample;
import com.cycredit.dao.mapper.UserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/21 0021.
 *
 * @author qiyubin
 */
@Service
public class UserService {


    @Resource
    UserMapper userMapper;

    public User findByName(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> list = userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }


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
