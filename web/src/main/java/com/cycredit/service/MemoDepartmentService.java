package com.cycredit.service;

import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qiyubin on 2017/11/24 0024.
 *
 * @author qiyubin
 */
@Service
public class MemoDepartmentService {

    @Resource
    UniMemoDepartmentMapper uniMemoDepartmentMapper;



}
