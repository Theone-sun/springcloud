package com.dlsp.springcloud_server.service;


import com.dlsp.springcloud_server.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> selAllVideo();

    List<Video> selVideoByPid(Integer pid);
}
