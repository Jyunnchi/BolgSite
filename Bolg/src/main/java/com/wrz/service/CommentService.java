package com.wrz.service;

import com.wrz.pojo.Comment;

import java.util.List;

public interface CommentService {
   public void MakeComment(Integer aid, Integer uid, String commentTime, Integer likes, String content);


   List<Comment> selectAllComment(Integer aid);
}
