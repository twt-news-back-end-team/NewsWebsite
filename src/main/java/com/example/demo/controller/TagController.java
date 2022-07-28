package com.example.demo.controller;

import com.example.demo.pojo.AddTagToArticleDTO;
import com.example.demo.pojo.SearchArticleByTagsDTO;
import com.example.demo.pojo.Tag;
import com.example.demo.service.TagService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    APIResponse createTag(@RequestParam String name) {
        return tagService.saveTag(name);
    }

    @GetMapping("/del/{id}")
    APIResponse deleteTag(@PathVariable Integer id) {
        return APIResponse.success(tagService.deleteTagById(id));
    }

    @GetMapping("{id}")
    APIResponse getTagById(@PathVariable Integer id) {
        return APIResponse.success(tagService.getById(id));
    }

    @GetMapping
    APIResponse getTags() {
        return APIResponse.success(tagService.list());
    }

    @GetMapping("/search/{name}")
    APIResponse getTagIdByName(@PathVariable String name) {
        return tagService.searchTagByName(name);
    }

    @PostMapping("/update")
    APIResponse updateTag(@RequestParam String oldName,@RequestParam String newName) {
        return tagService.updateTag(oldName,newName);
    }
    @PostMapping("/article")
    APIResponse addTagToArticle(@RequestBody AddTagToArticleDTO addTagToArticleDTO) {
        return tagService.addTagToArticle(addTagToArticleDTO.getTagNames(),addTagToArticleDTO.getArticleId());
    }
    @PostMapping("/article/del")
    APIResponse delTagFromArticle(@RequestParam String tagName,@RequestParam Integer articleId) {
        return tagService.deleteTagFromArticle(tagName,articleId);
    }
    @PostMapping("/article/search")
    APIResponse searchArticleByTags(@RequestBody SearchArticleByTagsDTO sat) {
        return tagService.searchArticleByTags(sat.getTagNames());
    }

}
