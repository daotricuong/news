package com.News.Controller;
import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import com.News.implement.CatalogueShowimp;
import com.News.implement.HomeTopicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HomeController{

    @Autowired
    HomeTopicImp homeTopic;
    @Autowired
    CatalogueShowimp catalogue;
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request) {
            List<Topic> top3 = homeTopic.top3Topic().getTopics();
            List<ListTopic> listTopic = homeTopic.getHomeTopic();
            List<Topic> topComment = homeTopic.getTopCommentTopic().getTopics();
            List<Topic> topNewTopic = homeTopic.getTopNewTopic().getTopics();
            List<Catalogue> list = catalogue.getAllCatalogue();
            System.out.println("session" + request.getSession().getAttribute("username"));
        if(list != null){
            modelMap.addAttribute("catalogues",list);
            request.setAttribute("catalogues",list);
        }
            modelMap.addAttribute("topComment", topComment);
            modelMap.addAttribute("topNews", topNewTopic);
            modelMap.addAttribute("top3", top3);
            modelMap.addAttribute("listTopic", listTopic);
            modelMap.addAttribute("title", "GROUP7");
            return "../../home";
        }

    }





