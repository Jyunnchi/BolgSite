package com.wrz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String pwd;
    private String nickname;
    private String registerTime;

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }
}
