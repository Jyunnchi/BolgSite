package com.wrz.mapper;

import com.wrz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    public List<User> GetAll();

    public void add(User user);

    public User selectByUsername(String uname);

    public User seacherUserByUid(Integer uid);

    Integer countLikes(Integer uid);

    Integer countFavorites(Integer uid);
}
