package com.cystrix.blog.controller.home;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 下载控制器
 *
 * @Title: DownloadController
 * @Author Shen_Muyan
 * @Package com.cystrix.blog.controller.home
 * @Date 2024/4/29 5:50
 */
@Slf4j
@Controller
@RequestMapping(value = "/download")
public class DownloadController {

    @GetMapping("/cover/{filename}")
    public ResponseEntity<Resource> downloadCoverImage(@PathVariable String filename) {
        // 根据文件名加载图片文件
        Resource resource = new FileSystemResource(new File("blog/upload/article/covers/" + filename));

        // 设置响应头,指定内容类型为图片
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "image/jpeg");

        // 返回响应实体,包含图片文件和响应头
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
