package com.News.Controller;
import com.News.implement.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class UserController{


//    @Autowired
//    UserServiceImp userService;
//    @RequestMapping(value = "/admin/user" , method = RequestMethod.GET)
//    public String test(ModelMap model) {
//
//        return "user";
//    }



    public String infor(ModelMap modelMap){

    return "com/";
    }

}
