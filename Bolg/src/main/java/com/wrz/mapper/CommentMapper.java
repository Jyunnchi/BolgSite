package com.wrz.mapper;

import com.wrz.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

   public void MakeComment(Integer aid, Integer uid, String commentTime, Integer likes, String content);


   List<Comment> selectAllComment(Integer aid);
}
