package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.*;
import com.example.demo.utils.APIResponse;

import java.util.List;

public interface ArticleService extends IService<Article> {
    APIResponse articleCreate(ArticleCreateDTO articleCreateDTO);

    APIResponse articleDelete(Integer id);

    APIResponse articleUpdate(ArticleAndTagsDTO articleAndTagsDTO);

    APIResponse articleUpdateStatus(ArticleUpdateStatusDTO articleUpdateStatusDTO);

    APIResponse articleSelectById(Integer id);

    APIResponse articleSelectSummaryById(Integer id);

    APIResponse articleSelectSummary();

    APIResponse articleSelectSummaryTop();

    APIResponse articleSelectSummaryNor();

    APIResponse articleSelectSummaryByIds(List<Integer> idList);

    APIResponse articleSelectSummarySeeByIds(List<Integer> idList);

    APIResponse articleSelectTitle(String keyword);
}
