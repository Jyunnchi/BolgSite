package com.wrz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer aid;
    private Integer uid;
    private String title;
    private String content;
    private String publishTime;
    private Integer likes;
    private Integer favorites;
    private Integer comments;
}
