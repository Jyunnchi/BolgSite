package com.wrz.service;

import com.wrz.pojo.Article;
import com.wrz.pojo.FavoriteItem;
import com.wrz.pojo.LikeItem;

import java.util.List;

public interface ArticleService {
   public void edit(Article article);

   public List<Article> showAll();

   public void addFavorite(Integer aid, Integer uid);

   public void addFavoriteToFavorites(Integer aid, Integer uid,String favorite_time);

   public FavoriteItem judgeFavorite(Integer aid, Integer uid);

   public List<Article> selectByUid(Integer uid);

   public List<Article> selectFavoritesByUid(Integer uid);

   public void deleteArticle(Integer aid);

   void LikeBlog(Integer aid);

   void AddLikeToLikes(Integer aid, Integer uid, String likeTime);

   LikeItem judgeLike(Integer aid, Integer uid);
}
