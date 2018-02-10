package com.News.Controller;

import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import com.News.Service.CatalogueService;
import com.News.implement.CatalogueServiceImp;
import com.News.implement.CatalogueShowimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CatalogueController {
    @Autowired
    CatalogueShowimp catalogue;
        @RequestMapping(value = "/{catalogue}", method = RequestMethod.GET)
        public String getCatalogue(@PathVariable("catalogue") String id, ModelMap modelMap){
            ListTopic listTopic;
            List<Topic> topComment = catalogue.getTopCommentTopic().getTopics();
            List<Topic> topNewTopic = catalogue.getTopNewTopic().getTopics();
            modelMap.addAttribute("topComment", topComment);
            modelMap.addAttribute("topNews", topNewTopic);
            if(catalogue.getAllCatalogue() != null){
                modelMap.addAttribute("catalogues",catalogue.getAllCatalogue());
            }
            if(catalogue.getCatalogueTopic(id).isEmpty()){
                return "404";
            } else {
                listTopic = catalogue.getCatalogueTopic(id).get(0);
                modelMap.addAttribute("catalogue",listTopic.getListName());
                modelMap.addAttribute("title",listTopic.getListName());
                modelMap.addAttribute("topic",listTopic.getTopics());

                return "catalogue";
            }

        }
    @Autowired
    CatalogueServiceImp catalogueService;
    @RequestMapping(value = "/admin/createcatalogue",method = RequestMethod.POST)
    public String createCatalogue(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws InterruptedException {
        if(catalogueService.createCatalogue(httpServletRequest)){
            redirectAttributes.addFlashAttribute("message", " Catalogue đã được tạo!");
        } else {
            redirectAttributes.addFlashAttribute("message","Thất bại");
        }
        String redirectUrl = httpServletRequest.getContextPath() + "/admin/CatalogueManager.html";
        Thread.sleep(1000);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/admin/updatecatalogue",method = RequestMethod.POST)
    public String updateCatalogue(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws InterruptedException {
        if(catalogueService.updateCatalogue(httpServletRequest,httpServletRequest.getParameter("catalogueId"))){
            redirectAttributes.addFlashAttribute("message", " Catalogue đã được sửa!");
        } else {
            redirectAttributes.addFlashAttribute("message","Thất bại");
        }
        String redirectUrl = httpServletRequest.getContextPath() + "/admin/CatalogueManager.html";
        Thread.sleep(1000);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/admin/deletecatalogue",method = RequestMethod.POST)
    public String deleteCatalogue(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws InterruptedException {
        if(catalogueService.deleteCatalogue(httpServletRequest.getParameter("catalogueId"))){
            redirectAttributes.addFlashAttribute("message", " Catalogue đã được xóa!");
        } else {
            redirectAttributes.addFlashAttribute("message","Thất bại");
        }
        String redirectUrl = httpServletRequest.getContextPath() + "/admin/CatalogueManager.html";
        Thread.sleep(1000);
        return "redirect:" + redirectUrl;
    }

}
