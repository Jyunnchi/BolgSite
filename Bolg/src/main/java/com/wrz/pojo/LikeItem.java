package com.wrz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeItem {
    Integer lid;
    Integer aid;
    Integer uid;
    String like_time;
}
