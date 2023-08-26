package com.wrz.controller;

import com.wrz.pojo.Comment;
import com.wrz.pojo.Result;
import com.wrz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/makeComment")
    public Result MakeComment(String content, Integer aid, HttpSession session){
        Integer uid=(Integer)session.getAttribute("uid");
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String commentTime= df.format(date);
        Integer likes=0;
        try {
            commentService.MakeComment(aid,uid,commentTime,likes,content);
            return new Result(200,"评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"评论失败");
        }
    }

    @PostMapping("/loadComment")
    public Result LoadComment(Integer aid){
        try {
            List<Comment> comments= commentService.selectAllComment(aid);
            Collections.reverse(comments);
            return new Result(200,"评论加载成功",comments);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"评论加载失败",e);
        }

    }
}
