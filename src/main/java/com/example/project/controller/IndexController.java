package com.example.project.controller;

import com.example.project.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.ObjectInputStream;
@Slf4j
@Controller
public class IndexController {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromLS() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from lose", Long.class);
        return aLong.toString();

    }

    /*
    来登录页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (!(StringUtils.isEmpty(user.getUserName())) && "123456".equals(user.getPassWord())){
//         把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
//登录成功重定向到main.html
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    /*
     去main页面
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
        log.info("当前页面是: {}","mainPage");
//        是否登录成功 拦截器
/*
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录 ");
            return "login";
        }
*/

        return "main";
    }

}
