package com.example.project.controller;

import com.example.project.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("2021211000", "无","2021","1","tom"),
                new User("2021211001", "无","2021","1","jerry"));
        model.addAttribute("users",users);

        return "table/dynamic_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
