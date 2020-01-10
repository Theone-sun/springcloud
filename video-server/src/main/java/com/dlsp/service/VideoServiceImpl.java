package com.dlsp.service;

import com.dlsp.mapper.VideoMapper;
import com.dlsp.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> getAllVideo() {
        List<Video> videos = videoMapper.selectAll();
        return videos;
    }

    @Override
    public Video getVideoById(Integer vid) {
        Video video = videoMapper.selectByPrimaryKey(vid);
        return video;
    }

    @Override
    public Integer addVedio(Video video) {
        Integer nResult=videoMapper.insert(video);
        return nResult;
    }

    @Override
    public Integer delVideoById(Integer vid) {
        int i = videoMapper.deleteByPrimaryKey(vid);
        return i;
    }
}
