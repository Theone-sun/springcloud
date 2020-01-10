package com.dlsp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
@Data
public class FileUploadProperties {
    //静态资源对外暴露的访问路径
    private String staticAccessPath;

    //文件上传目录
    private String uploadFolder ;
}
