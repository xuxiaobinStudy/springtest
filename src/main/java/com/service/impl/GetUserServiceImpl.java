package com.service.impl;

import com.mapper.TestMapper;
import com.service.GetUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GetUserServiceImpl
 * @Description TODO
 * @Author acer
 * @Date 2019/7/28 14:22
 * @Version 1.0
 **/
@Service
public class GetUserServiceImpl implements GetUsersService {

    @Autowired
    TestMapper testMapper;

    @Override
    public void getCount() {
        Integer count = testMapper.getCount();
        System.out.println(count);
    }
}
