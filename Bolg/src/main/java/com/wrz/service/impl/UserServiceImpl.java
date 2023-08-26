package com.wrz.service.impl;

import com.wrz.mapper.UserMapper;
import com.wrz.pojo.User;
import com.wrz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User selectByUsername(String uname) {
       return userMapper.selectByUsername(uname);
    }

    @Override
    public User seachUserByUid(Integer uid) {
        User res= userMapper.seacherUserByUid(uid);
        return res;
    }

    @Override
    public Integer countLikes(Integer uid) {
        return userMapper.countLikes(uid);

    }

    @Override
    public Integer countFavorites(Integer uid) {
        return userMapper.countFavorites(uid);
    }

}
