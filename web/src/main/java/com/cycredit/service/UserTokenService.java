package com.cycredit.service;

import com.cycredit.dao.entity.UserToken;
import com.cycredit.dao.mapper.UserTokenMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2017/11/21 0021.
 *
 * @author qiyubin
 */
@Service
public class UserTokenService {
    @Resource
    UserTokenMapper userTokenMapper;

    public UserToken findById(Long id) {
        UserToken userToken = userTokenMapper.selectByPrimaryKey(id);
        return userToken;
    }


}
