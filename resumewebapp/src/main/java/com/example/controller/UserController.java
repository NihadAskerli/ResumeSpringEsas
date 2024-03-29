package com.example.controller;

import com.example.entity.User;
import com.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceInter userService;
@RequestMapping(method = RequestMethod.GET)
    public String index (HttpServletRequest request){
    String name =request.getParameter("name");
    String surname=request.getParameter("surname");
    String nationalityIdStr=request.getParameter(("nid"));
    Integer nationalityId=null;
    if(nationalityIdStr!=null && nationalityIdStr.trim().isEmpty()){
        nationalityId=Integer.parseInt(nationalityIdStr);
    }
    List<User> list =userService.getAll(name,surname,nationalityId);
    request.setAttribute("list",list);
    return "users";
}
//@RequestMapping(method = RequestMethod.GET,value = "/users")
//public ModelAndView index (@RequestParam(value = "name",required = false) String name,
//                           @RequestParam(value ="surname",required = false) String surname,
//                           @RequestParam(value = "nid",required = false)Integer nationalityId){
//  List<User>list=userService.getAll(name,surname,nationalityId);
//  ModelAndView mv=new ModelAndView("users");
//      mv.addObject("list",list);
//      return mv;


//}

}
