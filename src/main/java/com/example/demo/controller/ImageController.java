package com.example.demo.controller;

import com.example.demo.service.ImageService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@RestController
@RequestMapping("/img")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @PostMapping("/upload")
    public APIResponse imgUpload(@RequestParam("img")MultipartFile img, HttpSession session) throws IOException {
        return imageService.uploadImage(img,session);
    }
}
