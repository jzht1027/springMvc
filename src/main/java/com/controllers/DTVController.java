package com.controllers;

import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
// SessionAttributes用于类上面，从Model中获取指定属性，底层会从Model中找个type的属性,然后写入session，此方式依赖于Model;
// SessionAttribute用于方法上面，读取session;
// 使用@SessionAttribute注解的前提下: Model 和 session 是互通的，session 可以从Model中获取写入指定的属性，Model 也可以从Session 中获取写入的指定属性；
@SessionAttributes("type") //注意当前控制器下所有的处理方法，都会将model中指定的属性写入session;
public class DTVController {

    /**
     * 使用servlet API 方式传输数据到视图
     * @param request
     * @return
     */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request){
        request.setAttribute("type","servletAPI");
        return "main";
    }

    /**
     * 使用model 方式传输数据到视图
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String model(Model model){
        model.addAttribute("type","model");
        return "main";
    }

    /**
     * 使用Map 方式传输数据到视图
     * @param map
     * @return
     */
    @RequestMapping("/map")
    public String map(Map map){
        map.put("type","map");
        return "main";
    }

    /**
     * 使用ModelMap 方式传输数据到视图
     * @param modelMap
     * @return
     */
    @RequestMapping("/modelMap")
    public String map(ModelMap modelMap){
        modelMap.addAttribute("type","modelMap");
        return "main";
    }

    /**
     * 使用ModelAndView 方式传输数据到视图
     * @param
     * @return
     */
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("type","ModelAndView");
        return modelAndView;
    }

    /**
     * 通过参数绑定的方式获取servlet API 的 session
     * @param httpSession
     * @return
     */
    @RequestMapping("/httpSession")
    public String httpSession(HttpSession httpSession){
        httpSession.setAttribute("type","httpSession");
        return "main";
    }

    @Autowired
    HttpSession session;
    /**
     * 通过自动注解 session【推荐使用】
     * @param
     * @return
     */
    @RequestMapping("/autoSession")
    public String autoSession(){
        session.setAttribute("type","autoSession");
        return "main";
    }

    // SessionAttribute用于方法上面，读取session;
    // 使用@SessionAttribute注解的前提下: Model 和 session 是互通的，
    //      session 可以从Model中获取写入指定的属性，Model 也可以从Session 中获取写入的指定属性；
    @RequestMapping("/sessionAttribute")
    public String sessionAttribute(@SessionAttribute(value = "type",required = false) String type){
        System.out.println("type:"+type);
        return "main";
    }

    HttpSession httpSession01;
    //1.通过@ModelAttribute来设置全局变量【不推荐使用】
    @ModelAttribute
    public void mdelAttribute(HttpSession httpSession){
        System.out.println("@ModelAttribute注解，优先在当前控制器的所有执行处置方法之前执行");
        this.httpSession01 = httpSession;
    }

    @RequestMapping("/mdelAttribute")
    public String httpSession01(){
        httpSession01.setAttribute("type","mdelAttribute-httpSession");
        return "main";
    }

//    @ModelAttribute
//    public void mdelAttribute(Model model){
//        System.out.println("@ModelAttribute注解，优先在当前控制器的所有执行处置方法之前执行");
//        User user = new User();
//        user.setName("name");
//        user.setAge(12);
//        user.setBalance(1000.12);
//        model.addAttribute(user);
//    }
//
//    //2.update(User user) 方法是全表字段更新sql，  @ModelAttribute 方法是 全表字段查询sql，
//    // 若直接执行update 方法，则有可能将数据更新为空；
//    // 所以再执行update方法前，自动执行了@ModelAttribute方法先获取了user的源数据，
//    // 然后再执行update(User user新数据)方法时，model中的user中参数相同的进行合并，将新字段数据进行覆盖，没有的字段进行保留源数据，这样问题就解决了；
//    @RequestMapping("/update")
//    public String update(User user){
//        System.out.println(user);
//        return "main";
//    }
}
