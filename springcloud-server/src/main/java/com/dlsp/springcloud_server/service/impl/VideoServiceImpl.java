package com.dlsp.springcloud_server.service.impl;

import com.dlsp.springcloud_server.mapper.VideoMapper;
import com.dlsp.springcloud_server.pojo.Video;
import com.dlsp.springcloud_server.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "videoServiceImpl")
public class VideoServiceImpl implements VideoService {

    @Autowired(required = false)
    private VideoMapper videoMapper;

    @Override
    public List<Video> selAllVideo() {
        return videoMapper.selectAll();
    }

    @Override
    public List<Video> selVideoByPid(Integer pid) {
        return videoMapper.getVideoByPid(pid);
    }
}
