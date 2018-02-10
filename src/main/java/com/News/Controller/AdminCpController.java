package com.News.Controller;


import com.News.Entity.Catalogue;
import com.News.Entity.User;
import com.News.Service.TopicService;
import com.News.implement.CatalogueShowimp;
import com.News.implement.TopicShowImp;
import com.News.implement.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminCpController {
    @RequestMapping(value = "/admincp", method = RequestMethod.GET)
    public String admin(){
        return "admincp";
    }


    @Autowired
    TopicShowImp topicService;
    @RequestMapping(value = "/editors", method = RequestMethod.GET)
    public String adminTopic(ModelMap modelMap){
        if(topicService.getAllTopic() !=  null){
            modelMap.addAttribute(topicService.getAllTopic());
        }
        return "adminTopic";
    }


    @Autowired
    CatalogueShowimp catalogue;
    @RequestMapping(value = "/CatalogueManager", method = RequestMethod.GET)
    public String adminCatalogue(ModelMap modelMap){
        List<Catalogue> list = catalogue.getAllCatalogue();
        if(list !=  null){
            modelMap.addAttribute("listCatalogue",list);
        }
        return "adminCatalogue";
    }

    @Autowired
    UserServiceImp userServiceImp;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userManager(ModelMap modelMap){
        List<User> list = userServiceImp.getAllUser();
        if(list !=  null){
            modelMap.addAttribute("listUser",list);
        }
        return "adminUser";
    }

}
