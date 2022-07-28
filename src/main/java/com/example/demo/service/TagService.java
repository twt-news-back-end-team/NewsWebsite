package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Tag;
import com.example.demo.utils.APIResponse;

import java.util.List;

public interface TagService extends IService<Tag> {
    APIResponse saveTag(String name);
    APIResponse deleteTagById(Integer id);
    APIResponse updateTag(String oldName,String newName);
    APIResponse searchTagByName(String name);
    APIResponse addTagToArticle(List<String> tagNameList, Integer articleId);
    APIResponse deleteTagFromArticle(String tagName,Integer articleId);

    APIResponse searchArticleByTags(List<String> tagNames);
}
