package com.wrz.service.impl;

import com.wrz.mapper.ArticleMapper;
import com.wrz.pojo.Article;
import com.wrz.pojo.FavoriteItem;
import com.wrz.pojo.LikeItem;
import com.wrz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
   private ArticleMapper articleMapper;

    @Override
    public void edit(Article article) {
        articleMapper.edit(article);
    }

    @Override
    public List<Article> showAll() {
        return articleMapper.showAll();
    }

    @Override
    public void addFavorite(Integer aid, Integer uid) {
        articleMapper.addFavorite(aid,uid);
    }

    @Override
    public void addFavoriteToFavorites(Integer aid, Integer uid,String favorite_time) {
        articleMapper.addFavoriteToFavorites(aid,uid,favorite_time);
    }

    @Override
    public FavoriteItem judgeFavorite(Integer aid, Integer uid) {
        return articleMapper.judgeFavorite(aid,uid);
    }

    @Override
    public List<Article> selectByUid(Integer uid) {
        return articleMapper.selectByUid(uid);
    }

    @Override
    public List<Article> selectFavoritesByUid(Integer uid) {
        return articleMapper.selectFavoritesByUid(uid);
    }

    @Override
    public void deleteArticle(Integer aid) {
        articleMapper.deleteArticle(aid);
    }

    @Override
    public void LikeBlog(Integer aid) {
        articleMapper.LikeBlog(aid);
    }

    @Override
    public void AddLikeToLikes(Integer aid, Integer uid, String likeTime) {
        articleMapper.AddLikeToLikes(aid,uid,likeTime);
    }

    @Override
    public LikeItem judgeLike(Integer aid, Integer uid) {
        return articleMapper.judgeLike(aid,uid);
    }
}
