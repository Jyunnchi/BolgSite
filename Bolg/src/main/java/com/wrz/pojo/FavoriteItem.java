package com.wrz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteItem {
    Integer faid;
    Integer aid;
    Integer uid;
    String favorite_time;
}
