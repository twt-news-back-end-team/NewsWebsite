package com.example.demo.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.pojo.Image;
import com.example.demo.service.ImageService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import com.example.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    private final static String imgPath = "/root/img/";
//    private final static String imgPath = "E:\\mp4\\";
    @Override
    @Transactional
    public APIResponse uploadImage(MultipartFile img, HttpSession session) {
        //获得文件名
/*
        String userId =(String) session.getAttribute("userId");
        if(userId.isEmpty()) {
            return APIResponse.error(ErrorCode.LOGIN_ERROR);
        }
*/
//        String imgName = img.getOriginalFilename();
//        String suffixName = imgName.substring(imgName.lastIndexOf("."));
        String path;
        Image image = new Image();
        try {
            //获得哈希码
            String hashcode = MD5Util.md5HashCode(img.getInputStream());
//            imgName = hashcode +"$" + imgName.substring(0,imgName.lastIndexOf('.')) + suffixName;
//            path = imgPath + imgName;
            path = imgPath + hashcode;
            List<Image> imageList = imageMapper.selectByHashcode(hashcode);
            if(imageList.size()!=0) {
                path = imageList.get(0).getImageUrl();
            }
            else {
                img.transferTo(new File(path));
            }
            image.setImageUrl(path);
            image.setHashcode(hashcode);
            imageMapper.insert(image);
        } catch (IOException e) {
            return APIResponse.error(ErrorCode.MD5_ERROR);
        }
        return APIResponse.success(image.getId());
    }

    @Override
    @Transactional
    public APIResponse getImageByImageUploaderId(HttpSession session) {
        String userId = (String)session.getAttribute("userId");
        if(userId.isEmpty()) {
            return APIResponse.error(ErrorCode.LOGIN_ERROR);
        }
        List<Image> imageList = imageMapper.selectByImageUploaderId(userId);
        List<String> urlList = new ArrayList<>();
        for(Image image : imageList) {
            urlList.add(image.getImageUrl());
        }
        return APIResponse.success(urlList);
    }

    private void downloadImage(String url,HttpServletResponse response) throws Exception {
//        String fileName = url.substring(url.indexOf('$')+1);
        String fileName = url.substring(url.lastIndexOf('/'));
        response.reset();
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("image/jepg"); //二进制传输数据
//        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(url);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
    }

    @Override
    @Transactional
    public APIResponse downloadImageById(Integer id, HttpServletResponse response)throws Exception {
        Image img = imageMapper.selectById(id);
        if(img == null) {
            return APIResponse.error(ErrorCode.IMAGE_ID_ERROR);
        }
        downloadImage(img.getImageUrl(),response);
        return APIResponse.success("下载完成");
    }

    @Override
    @Transactional
    public APIResponse downloadImageByUrl(String url, HttpServletResponse response) throws Exception {
        List<Image> imgList = imageMapper.selectByImageUrl(url);
        if(imgList == null) {
            return APIResponse.error(ErrorCode.IMAGE_URL_ERROR);
        }
        downloadImage(url,response);
        return APIResponse.success("下载完成");
    }

    @Override
    @Transactional
    public APIResponse deleteImageById(Integer id) {
        Image img = imageMapper.selectById(id);
        if(img == null) {
            return APIResponse.error(ErrorCode.IMAGE_ID_ERROR);
        }
        imageMapper.deleteById(id);
        List<Image> imageList = imageMapper.selectByHashcode(img.getHashcode());
        if(imageList.isEmpty()) {
            File file = new File(img.getImageUrl());
            if(!file.delete()) {
                return APIResponse.error(ErrorCode.IMAGE_DELETE_ERROR);
            }
        }
        return  APIResponse.success("图片删除成功");
    }
}
