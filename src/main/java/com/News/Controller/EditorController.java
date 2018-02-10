package com.News.Controller;


import com.News.Service.CatalogueShow;
import com.News.Service.TopicService;
import com.News.Service.TopicShow;
import com.News.implement.CatalogueShowimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditorController {
    @Autowired
    CatalogueShowimp catalogue;
    @Autowired
    TopicShow topicShow;
    @RequestMapping(value = "/editor",method = RequestMethod.GET)
    public String editor(ModelMap modelMap, @RequestParam(value="submitFromAdmin",required=false) String topicId ){
        if(catalogue.getAllCatalogue() != null){
            modelMap.addAttribute("catalogue",catalogue.getAllCatalogue());
        }
        if(topicId == null || topicId == ""){
            modelMap.addAttribute("topicId","notcreate");
            modelMap.addAttribute("authorid","-1");
        } else {
            if(topicShow.getTopicForAdmin(topicId) != null){
                modelMap.addAttribute("topicId",topicShow.getTopicForAdmin(topicId).get(0).getTopicId());
                modelMap.addAttribute("topic",topicShow.getTopicForAdmin(topicId).get(0));
                modelMap.addAttribute("authorid",topicShow.getTopicForAdmin(topicId).get(0).getAuthorId());
            }

        }
        return "TextEditor";
    }

}
