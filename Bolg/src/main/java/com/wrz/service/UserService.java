package com.wrz.service;

import com.wrz.pojo.User;

public interface UserService {
    public void add(User user);

    public User selectByUsername(String uname);

    User seachUserByUid(Integer uid);

    Integer countLikes(Integer uid);

    Integer countFavorites(Integer uid);
}
