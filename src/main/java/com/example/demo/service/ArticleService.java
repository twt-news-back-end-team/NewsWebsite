package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.ArticleCreateDTO;
import com.example.demo.pojo.ArticleSelectSummaryByIdsDTO;
import com.example.demo.pojo.ArticleUpdateStatusDTO;
import com.example.demo.utils.APIResponse;

public interface ArticleService extends IService<Article> {
    APIResponse articleCreate(ArticleCreateDTO articleCreateDTO);

    APIResponse articleDelete(Integer id);

    APIResponse articleUpdate(Article article);

    APIResponse articleUpdateStatus(ArticleUpdateStatusDTO articleUpdateStatusDTO);

    APIResponse articleSelectById(Integer id);

    APIResponse articleSelectSummaryById(Integer id);

    APIResponse articleSelectSummary();

    APIResponse articleSelectSummaryTop();

    APIResponse articleSelectSummaryNor();

    APIResponse articleSelectSummaryByIds(ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO);

    APIResponse articleSelectSummarySeeByIds(ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO);
}
