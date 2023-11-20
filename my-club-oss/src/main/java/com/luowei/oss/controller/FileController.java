package com.luowei.oss.controller;

import com.luowei.oss.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/oss")
public class FileController {
    @Resource
    private FileService fileService;

    @GetMapping("test")
    public List<String> test() throws Exception{
        return fileService.getAllBucket();
    }
}
