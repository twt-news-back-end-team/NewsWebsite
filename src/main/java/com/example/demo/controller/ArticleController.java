package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/art")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/create")
    public APIResponse articleCreate(@RequestBody ArticleCreateDTO articleCreateDTO) {
        return articleService.articleCreate(articleCreateDTO);
    }

    @PostMapping("/delete")
    public APIResponse articleDelete(@RequestBody ArticleDeleteDTO articleDeleteDTO) {
        return articleService.articleDelete(articleDeleteDTO.getId());
    }

    @PostMapping("/update")
    public APIResponse articleUpdate(@RequestBody ArticleAndTagsDTO articleAndTagsDTO) {
        return articleService.articleUpdate(articleAndTagsDTO);
    }

    @PostMapping("/update/status")
    public APIResponse articleUpdateStatus(@RequestBody ArticleUpdateStatusDTO articleUpdateStatusDTO) {
        return articleService.articleUpdateStatus(articleUpdateStatusDTO);
    }

    @GetMapping("/select/{id}")
    public APIResponse articleSelectById(@PathVariable("id") Integer id) {
        return articleService.articleSelectById(id);
    }

    @GetMapping("/select/summary/{id}")
    public APIResponse articleSelectSummaryById(@PathVariable("id") Integer id) {
        return articleService.articleSelectSummaryById(id);
    }

    @GetMapping("/select/summary")
    public APIResponse articleSelectSummary() {
        return articleService.articleSelectSummary();
    }

    @GetMapping("/select/summary/top")
    public APIResponse articleSelectSummaryTop() {
        return articleService.articleSelectSummaryTop();
    }

    @GetMapping("/select/summary/nor")
    public APIResponse articleSelectSummaryNor() {
        return articleService.articleSelectSummaryNor();
    }

    @PostMapping("/select/summary/ids")
    public APIResponse articleSelectSummaryByIds(
            @RequestBody ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO) {
        return articleService.articleSelectSummaryByIds(articleSelectSummaryByIdsDTO.getIdList());
    }

    @PostMapping("/select/summary/see/ids")
    public APIResponse articleSelectSummarySeeByIds(
            @RequestBody ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO) {
        return articleService.articleSelectSummarySeeByIds(articleSelectSummaryByIdsDTO.getIdList());
    }


}
