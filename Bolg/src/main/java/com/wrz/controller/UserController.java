package com.wrz.controller;

import com.wrz.pojo.Result;
import com.wrz.pojo.User;
import com.wrz.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result add(User user){
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegisterTime(df.format(date));
        String pwd=user.getPwd();
        String salt="451471";
        pwd=pwd+salt;
        pwd= DigestUtils.md5DigestAsHex(pwd.getBytes(StandardCharsets.UTF_8));
        user.setPwd(pwd);
        try{
            userService.add(user);
            return new Result(200,"注册成功");
        }catch(Exception e){
            e.printStackTrace();
            return new Result(500,"用户名已存在",e);
        }
    }
    @RequestMapping("/login")
    public Result Login(User user, HttpSession session){
        User result=userService.selectByUsername(user.getUname());
        if(result==null){
            return new Result(300,"用户未注册");
        }

        String pwd=user.getPwd();
        String salt="451471";
        pwd+=salt;
        pwd=DigestUtils.md5DigestAsHex(pwd.getBytes(StandardCharsets.UTF_8));

        if(result.getPwd().equals(pwd)){
            session.setAttribute("uid",result.getUid());
            return new Result(200,"登录成功");
        }else {
            return new Result(300,"密码错误");
        }
    }

    @PostMapping("/author")
    public Result SearchUserByUid(Integer uid){
        try {
            User user= userService.seachUserByUid(uid);
            return new Result(200,"查找成功",user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"加载失败",e);
        }
    }
    @GetMapping("/personalInfo")
    public Result GetUserInfo(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        System.out.println(uid);
        try {
            User user=userService.seachUserByUid(uid);
            return new Result(200,"个人信息加载成功",user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"个人信息加载失败",e);
        }

    }
    @GetMapping("/customerUid")
    public Result GetCustomerUid(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        return new Result(200,"个人信息加载成功",uid);
    }
    @PostMapping("/commenters")
    public Result SelectUsersByUids(@RequestBody Vector<Integer> uids){
        Vector<User> users=new Vector<User>();
        try {
            for(Integer uid:uids){
                users.add(userService.seachUserByUid(uid));
            }
            return new Result(200,"搜索成功",users);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"加载失败",e);
        }
    }
    @GetMapping("/countLikes")
    public Result countLikes(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        try {
            Integer cnt=userService.countLikes(uid);
            return new Result(200,"加载成功",cnt);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"加载失败",e);
        }
    }
    @GetMapping("/countFavorites")
    public Result countFavorites(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        try {
            Integer cnt=userService.countFavorites(uid);
            return new Result(200,"加载成功",cnt);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(300,"加载失败",e);
        }
    }

}
