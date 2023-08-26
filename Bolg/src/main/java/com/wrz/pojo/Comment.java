package com.wrz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer cid;
    private Integer aid;
    private Integer uid;
    private String commentTime;
    private Integer likes;
    private String content;
}
