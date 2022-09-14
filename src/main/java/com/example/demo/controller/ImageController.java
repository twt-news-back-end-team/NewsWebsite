package com.example.demo.controller;

import com.example.demo.service.ImageService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/imgbed")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @PostMapping("/upload")
    public APIResponse imgUpload(@RequestParam("img")MultipartFile img) {
        return imageService.uploadImage(img);
    }
    @GetMapping
    public APIResponse getImageByImageUploaderId(HttpSession session) {
        return imageService.getImageByImageUploaderId(session);
    }
    @GetMapping("{id}")
    public APIResponse getImageById(@PathVariable Integer id) {
        return APIResponse.success(imageService.getById(id));
    }
    @GetMapping("/download/{id}")
    public void downloadImageById(@PathVariable Integer id, HttpServletResponse response) throws Exception {
        imageService.downloadImageById(id,response);
    }
    @PostMapping("/download/url")
    public void downloadImageByUrl(@RequestParam String url,HttpServletResponse response) throws Exception {
        imageService.downloadImageByUrl(url,response);
    }
    @GetMapping("/del/{id}")
    public APIResponse deleteImageById(@PathVariable Integer id) {
        return imageService.deleteImageById(id);
    }
}
