package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.ArticleCreateDTO;
import com.example.demo.pojo.ArticleSelectSummaryByIdsDTO;
import com.example.demo.pojo.ArticleUpdateStatusDTO;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import com.example.demo.utils.LengthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    @Transactional
    public APIResponse articleCreate(ArticleCreateDTO articleCreateDTO) {
        if (LengthCheck.check(articleCreateDTO.getTitle(), articleCreateDTO.getOrigin(),
                articleCreateDTO.getContributorName(), articleCreateDTO.getReviewerName())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        if (LengthCheck.check(20000, articleCreateDTO.getText())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }

        Article article = new Article();
        article.setOrigin(articleCreateDTO.getOrigin());
        article.setTitle(articleCreateDTO.getTitle());
        article.setText(articleCreateDTO.getText());
        article.setStatus(articleCreateDTO.getStatus());
        article.setContributorName(articleCreateDTO.getContributorName());
        article.setReviewerName(articleCreateDTO.getReviewerName());
        article.setReleaseTime(new Date());

        articleMapper.insert(article);
        return APIResponse.success(article);
    }

    @Override
    @Transactional
    public APIResponse articleDelete(Integer id) {
        articleMapper.deleteById(id);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    @Transactional
    public APIResponse articleUpdate(Article article) {
        if (LengthCheck.check(article.getTitle(), article.getOrigin(),
                article.getContributorName(), article.getReviewerName())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        if (LengthCheck.check(20000, article.getText())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        Article preArticle = articleMapper.selectById(article.getId());
        if (!preArticle.getReleaseTime().equals(article.getReleaseTime())) {
            return APIResponse.error(ErrorCode.ARTICLE_DATE_ERROR);
        }

        articleMapper.updateById(article);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    @Transactional
    public APIResponse articleUpdateStatus(ArticleUpdateStatusDTO articleUpdateStatusDTO) {
        if (articleUpdateStatusDTO.getStatus() > 2 || articleUpdateStatusDTO.getStatus() < 0) {
            return APIResponse.error(ErrorCode.STATUS_ERROR);
        }

        Article article = new Article();
        article.setId(articleUpdateStatusDTO.getId());
        article.setStatus(articleUpdateStatusDTO.getStatus());

        articleMapper.updateById(article);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    public APIResponse articleSelectById(Integer id) {
        return APIResponse.success(articleMapper.selectById(id));
    }

    @Override
    public APIResponse articleSelectSummaryById(Integer id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status").eq("id", id);
        return APIResponse.success(articleMapper.selectOne(wrapper));
    }

    @Override
    public APIResponse articleSelectSummary() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status");
        return APIResponse.success(articleMapper.selectList(wrapper));
    }

    @Override
    public APIResponse articleSelectSummaryTop() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status").eq("status", 1);
        return APIResponse.success(articleMapper.selectList(wrapper));
    }

    @Override
    public APIResponse articleSelectSummaryNor() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status").eq("status", 0);
        return APIResponse.success(articleMapper.selectList(wrapper));
    }

    @Override
    public APIResponse articleSelectSummaryByIds(ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status")
                .in("id", articleSelectSummaryByIdsDTO.getIdList());
        return APIResponse.success(articleMapper.selectList(wrapper));
    }

    @Override
    public APIResponse articleSelectSummarySeeByIds(ArticleSelectSummaryByIdsDTO articleSelectSummaryByIdsDTO) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status")
                .ne("status", 2)
                .in("id", articleSelectSummaryByIdsDTO.getIdList());
        return APIResponse.success(articleMapper.selectList(wrapper));
    }
}
