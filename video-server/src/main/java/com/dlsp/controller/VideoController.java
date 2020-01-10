package com.dlsp.controller;

import com.dlsp.pojo.Video;
import com.dlsp.service.VideoService;
import com.dlsp.util.FileUploadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideoById/{id}")
    //@ResponseBody
    public String getVideoById(@PathVariable("id") Integer id, Model model){
        Video videoById = videoService.getVideoById(id);
        //return videoById;
        model.addAttribute("video",videoById);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/addVideo")
    public String addVideo(Video video, MultipartFile video1){
        System.out.println(video);
        if(!video1.getOriginalFilename().equals("")){
            String newName = FileUploadFactory.upload(video1);
            video.setVaddress(newName);

        }
        video.setVdate(new Date());
        Integer nResult = videoService.addVedio(video);
        String msg=null;
        if(nResult>0){
            msg="ok";
        }else {
            msg="failed";
        }
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/toAddVideo")
    public String toAddVideo(){

        return "addVideo";
    }

    @RequestMapping("/getAllVideo")
    @ResponseBody
    public List<Video> getAllVideo(){
        List<Video> allVideo = videoService.getAllVideo();
        return allVideo;
    }

    @RequestMapping("/delVideoByVid/{vid}")
    @ResponseBody
    public Integer delVideoByVid(@PathVariable("vid") Integer vid){
        return videoService.delVideoById(vid);
    }
}
