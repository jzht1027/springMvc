package com.controllers;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("hello mvc:"+name);

        // redirect 重定向
        return "redirect:index.jsp";
        // forward 转发 默认
//        return "index.jsp";
    }

    @RequestMapping("/show")
    public String show(User user){
        System.out.println(user.toString());
        return "show";
    }

    @RequestMapping("/user")
    public String user(@Valid User user, BindingResult bindingResult, Model model){
        //将错误信息放入map key=错误信息的属性名 value=错误信息
        //有利于在jsp中分别取出${errors.name}
        Map<String,Object> errors = new HashMap<String, Object>();
        //将错误信息取出来放到jsp页面
        //判断当时是否有错误
        if(bindingResult.hasErrors()){
            //获取所有的错误信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                System.out.println(fieldError.getDefaultMessage());
                System.out.println(fieldError.getField());
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errorInfo",errors);
            return "user/add";
        }

        System.out.println(user.toString());
        return "show";
    }

    @RequestMapping("/form")
    public String form(@Valid User user,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/add";
        }

        System.out.println(user.toString());
        return "show";
    }

    @ModelAttribute
    public void initData(Model model){
        List<String> list = Arrays.asList("唱歌","跳舞");
        model.addAttribute("list",list);

        Map<String,String> map = new HashMap<String, String>();
        map.put("北京","北京");
        map.put("石家庄","石家庄");
        model.addAttribute("map",map);

    }

//    @RequestMapping("/add")
//    public String form(User user){
////      public String from(Model model){
////        model.addAttribute("user",new User());
//        return "user/add";
//    }
}
