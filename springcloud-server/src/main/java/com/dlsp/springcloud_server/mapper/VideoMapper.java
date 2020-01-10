package com.dlsp.springcloud_server.mapper;

import com.dlsp.springcloud_server.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {

    @Select("select vid,vname,vaddress,pid from video where pid=:pid")
    List<Video> getVideoByPid(Integer pid);
}
