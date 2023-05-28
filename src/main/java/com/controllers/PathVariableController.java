package com.controllers;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/path")
public class PathVariableController {

    @RequestMapping("/user01/{id}")
    public void pathVariable(@PathVariable String id){
        System.out.println("id:"+id);
    }

    @RequestMapping("/user02/{balance}/{name}")
    public void pathVariable02(User user){
        System.out.println("name:"+user.getName());
        System.out.println("balance:"+user.getBalance());
    }
}
