package com.wrz.controller;

import com.wrz.pojo.Article;
import com.wrz.pojo.FavoriteItem;
import com.wrz.pojo.LikeItem;
import com.wrz.pojo.Result;
import com.wrz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/edit")
    public Result Edit(Article article, HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        article.setUid(uid);
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        article.setPublishTime(df.format(date));
        try {
            articleService.edit(article);
            return new Result(200,"发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"发布失败");
        }
    }
    @GetMapping("/showAll")
    public Result ShowAll(){
        try {
            List<Article> articles = articleService.showAll();
            Collections.reverse(articles);
            return new Result(200,"检索成功",articles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"检索失败");
        }
    }

    @PostMapping("/favoriteBlogs")
    public Result AddFavoriteBlogs(Integer aid,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String favorite_time=df.format(date);

        try {
            articleService.addFavoriteToFavorites(aid,uid,favorite_time);
            articleService.addFavorite(aid,uid);
            return new Result(200,"收藏成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"您已收藏！",e);
        }
    }
    @PostMapping("/likeBlogs")
    public Result LikeBlogs(Integer aid,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String like_time=df.format(date);
        try {
            articleService.AddLikeToLikes(aid,uid,like_time);
            articleService.LikeBlog(aid);
            return new Result(200,"点赞成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"点赞失败！",e);
        }
    }

//    判断当前文章是否已经被当前用户收藏
    @PostMapping("/JudgeFavorite")
    public Result JudgeFavorite(Integer aid,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
//        Integer uid=15;
        try {
            FavoriteItem fi= articleService.judgeFavorite(aid,uid);
            if(fi==null){
                return new Result(250,"用户未收藏");
            }else return new Result(200,"用户已收藏");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"判断异常！",e);
        }
//        return new Result(300,"'xxx'",articleService.judgeFavorite(aid,uid));
    }
//    判断当前文章是否已点赞
@PostMapping("/JudgeLike")
public Result JudgeLike(Integer aid,HttpSession session){
    Integer uid=(Integer) session.getAttribute("uid");
    try {
        LikeItem li= articleService.judgeLike(aid,uid);
        if(li==null){
            return new Result(250,"用户未点赞");
        }else return new Result(200,"用户已点赞");
    } catch (Exception e) {
        e.printStackTrace();
        return new Result(300,"判断异常！",e);
    }
}
    @GetMapping("/MyArticles")
    public Result selectArticlesByUid(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        try {
            List<Article> articles= articleService.selectByUid(uid);
            return new Result(200,"我的稿件加载成功",articles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"我的稿件加载失败",e);
        }
    }

    @GetMapping("/FavoriteArticles")
    public Result selectFavoritesByUid(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        try {
            List<Article> articles=articleService.selectFavoritesByUid(uid);
            return new Result(200,"收藏加载成功",articles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"收藏加载失败",e);
        }
    }

    @PostMapping("/deleteArticle")
    public Result DeleteArticle(Integer aid){
        try {
            articleService.deleteArticle(aid);
            return new Result(200,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"删除失败",e);
        }
    }
    @PostMapping("/searchArticles")
    public Result SearchArticles(String search){
        try {
            List<Article> articles = articleService.showAll();
            List<Article> res=new ArrayList<Article>();
            for(Article article:articles){
                if(article.getTitle().contains(search)||article.getContent().contains(search))
                    res.add(article);
            }
            return new Result(200,"搜索成功",res);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"检索失败",e);
        }

    }
}
