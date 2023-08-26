package com.wrz.service.impl;

import com.wrz.mapper.CommentMapper;
import com.wrz.pojo.Comment;
import com.wrz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
   private CommentMapper commentMapper;

    @Override
    public void MakeComment(Integer aid, Integer uid, String commentTime, Integer likes, String content) {
        commentMapper.MakeComment(aid,uid,commentTime,likes,content);
    }

    @Override
    public List<Comment> selectAllComment(Integer aid) {
        return commentMapper.selectAllComment(aid);
    }


}
