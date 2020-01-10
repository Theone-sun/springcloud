package com.dlsp.service;

import com.dlsp.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAllVideo();

    Video getVideoById(Integer vid);

    Integer addVedio(Video video);

    Integer delVideoById(Integer vid);
}
