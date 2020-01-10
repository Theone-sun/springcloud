package com.dlsp.springcloud_server.controller;

import com.dlsp.springcloud_server.pojo.Product;
import com.dlsp.springcloud_server.pojo.Video;
import com.dlsp.springcloud_server.service.ProductService;
import com.dlsp.springcloud_server.service.VideoService;
import com.dlsp.springcloud_server.utils.CodeMsg;
import com.dlsp.springcloud_server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sourcesCenter")
public class SourcesCenterController {

    @Autowired
    @Qualifier(value = "videoServiceImpl")
    private VideoService videoService;

    @Autowired
    private ProductService productService;

    /**
     * 获得全部的视频信息
     * @return
     */
    @GetMapping("/getVideoInfo")
    public R<Video> getAllVideoInfo(){
        R<Video> result=new R<>();
        result.setCodeMsg(CodeMsg.SUCCESS_CODE);
        result.setList(videoService.selAllVideo());
        return result;
    }

    /**
     * 根据产品id获得该产品的视频信息
     * @return
     */
    @GetMapping("/getVideoInfoByPid/{pid}")
    public R<Video> getVideoInfoByPid(@PathVariable(value = "pid") Integer pid){
        R<Video> result=new R<>();
        result.setCodeMsg(CodeMsg.SUCCESS_CODE);
        result.setList(videoService.selVideoByPid(pid));
        return result;
    }

    /**
     * 获得用户已购买的产品信息列表
     * @param uid
     * @return
     */
    @GetMapping("/getProductsByUid/{uid}")
    public R<Product> getProductsByUid(@PathVariable("uid") Integer uid){
        R<Product> result=new R<>();
        result.setCodeMsg(CodeMsg.SUCCESS_CODE);
        result.setList(productService.selProductsByUid(uid));
        return result;
    }

    @GetMapping("/downVideoByvid/{vid}")
    public R<Product> downVideoByvid(@PathVariable("vid") Integer vid, HttpServletResponse response){
        R<Product> result=new R<>();
        /* 到数据库查找当前视频的存储地址 */

        /* 根据地址访问视频进行下载 */

        /* 确定视频的保存地址 */


        String downloadFilePath = "/root/fileSavePath/";//被下载的文件在服务器中的路径,
        String fileName = "demo.xml";//被下载文件的名称

        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                /*return "下载成功";*/
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        /*return "下载失败"; */

        result.setCodeMsg(CodeMsg.SUCCESS_CODE);
        //result.setList(productService.selProductsByUid(uid));
        return result;
    }

}
