package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class PathVariableController {

    @RequestMapping("/pathVariable/{id}")
    public void pathVariable(@PathVariable String id){
        System.out.println("id:"+id);
    }
}
