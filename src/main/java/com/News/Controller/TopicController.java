package com.News.Controller;
import com.News.Entity.Topic;
import com.News.Service.CatalogueShow;
import com.News.Service.TopicService;
import com.News.Service.TopicShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value = "/topic", method = RequestMethod.GET)

public class TopicController {
    @Autowired
    TopicShow topicShow;
    @Autowired
    CatalogueShow catalogue;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getTopic(@PathVariable("id") String id, ModelMap modelMap,HttpServletRequest request) {
//        String url = request.getContextPath().toString();
        Topic topic;
        List<Topic> topComment = topicShow.getTopCommentTopic().getTopics();
        List<Topic> topNewTopic = topicShow.getTopNewTopic().getTopics();
        modelMap.addAttribute("topComment", topComment);
        modelMap.addAttribute("topNews", topNewTopic);
        List<Topic> topViewTopic = topicShow.getTopViewTopic(1).getTopics();
        modelMap.addAttribute("topView", topViewTopic);
        if(catalogue.getAllCatalogue() != null){
            modelMap.addAttribute("catalogues",catalogue.getAllCatalogue());
        }
        if(topicShow.getTopicId(id).isEmpty()){
            return "topic404";
        } else {
            topic =  topicShow.getTopicId(id).get(0);
            modelMap.addAttribute("topic", topic);
            modelMap.addAttribute("title",topic.getTopicName());
            return "topic";
        }


    }
    @Autowired
    TopicService topicService;
    @RequestMapping(value = "/addTopic",method = RequestMethod.POST)
    public String addTopic(HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) throws InterruptedException {
        if(httpServletRequest.getParameter("topicId").equals("notcreate")){
            if (topicService.createTopic(httpServletRequest)){
                redirectAttributes.addFlashAttribute("message","Đã tạo topic");
            } else {
                redirectAttributes.addFlashAttribute("message","Tạo thất bại");
            }

        } else {
            if (topicService.updateTopic(httpServletRequest,httpServletRequest.getParameter("topicId"))){
                redirectAttributes.addFlashAttribute("message","Cập nhật thành công");
            }else {
                redirectAttributes.addFlashAttribute("message","Cập nhật thất bại");
            }

        }

        String redirectUrl = httpServletRequest.getContextPath() + "/editor.html";
        Thread.sleep(1000);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/deleteTopic",method = RequestMethod.POST)
    public String deleteTopic(HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) throws InterruptedException {
        if(topicService.delete(httpServletRequest.getParameter("topicId"))){
            redirectAttributes.addFlashAttribute("message",httpServletRequest.getParameter("topicId") + " Đã bị xóa!");
        } else {
            redirectAttributes.addFlashAttribute("message","Thất bại");
        }
        String redirectUrl = httpServletRequest.getContextPath() + "/admin/editors.html";
        Thread.sleep(1000);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/editStatus",method = RequestMethod.POST)
    public String editStatus( @RequestParam(value="status") int status, @RequestParam(value="topicId") String topicId, HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes){
        if(topicService.changeStatus(topicId,status)){
            redirectAttributes.addFlashAttribute("message",topicId +" Đã được thay đổi!");
        } else {
            redirectAttributes.addFlashAttribute("message","Thất bại");
        }
        String redirectUrl = httpServletRequest.getContextPath()+"/admin/editors.html";

        return "redirect:" + redirectUrl;
    }

}
