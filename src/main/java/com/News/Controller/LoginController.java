package com.News.Controller;

import com.News.Service.UserService;
import com.News.implement.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        modelMap.addAttribute("title","Login");
        return "login";
    }

    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest httpRequest,ModelMap modelMap,HttpSession session) {

        if (httpRequest.getParameter("username") != null) {
            if (userServiceImp.canLogin(httpRequest)) {
                String redirectUrl = httpRequest.getContextPath() + "/home.html";
                httpRequest.getSession().setAttribute("username",httpRequest.getParameter("username"));
                httpRequest.getSession().setAttribute("user",userServiceImp.getUser(httpRequest.getParameter("username")));
//                session.setAttribute("username", httpRequest.getParameter("username") );
                return "redirect:" + redirectUrl;
            } else {
                modelMap.addAttribute("message", "Login thất bại");
                return "login";
            }

        } else {
            modelMap.addAttribute("message", "chưa nhập username");
            return "login";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String doLogout(HttpServletRequest httpRequest, RedirectAttributes redirectAttributes, HttpSession session){
            String redirectUrl = httpRequest.getContextPath();
            if(httpRequest.getSession().getAttribute("username")!=null & httpRequest.getSession().getAttribute("username") != ""){
                httpRequest.getSession().invalidate();
                redirectAttributes.addFlashAttribute("message", "Logout thành công");
//                session.invalidate();
                return "redirect:" + redirectUrl + "/login.html";
            } else {
                redirectAttributes.addFlashAttribute("message", "Chưa Login logout làm gì?");
                return "redirect:" + redirectUrl + "/login.html";
            }


    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap modelMap){

        modelMap.addAttribute("title","Register");
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest httpRequest,ModelMap modelMap){
        String redirectUrl = httpRequest.getContextPath();

        if(userServiceImp.create(httpRequest)){

            return "redirect:" + redirectUrl + "/login.html";
        } else {
            modelMap.addAttribute("message",userServiceImp.getMessage());
            return "register";
        }
    }
}
