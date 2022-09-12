package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.ArticleTagMapper;
import com.example.demo.pojo.*;
import com.example.demo.service.ArticleService;
import com.example.demo.service.TagService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import com.example.demo.utils.LengthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private final ArticleMapper articleMapper;
    private final ArticleTagMapper articleTagMapper;
    private final TagService tagService;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper, ArticleTagMapper articleTagMapper, TagService tagService) {
        this.articleMapper = articleMapper;
        this.articleTagMapper = articleTagMapper;
        this.tagService = tagService;
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
        article.setCoverImageId(articleCreateDTO.getCoverImageId());
        article.setBannerImageId(articleCreateDTO.getBannerImageId());
        article.setCategoryId(articleCreateDTO.getCategoryId());
        article.setViewsNumber(0);


        articleMapper.insert(article);
        if (!articleCreateDTO.getTagNameList().isEmpty() && articleCreateDTO.getTagNameList() != null) {
            tagService.addTagToArticle(articleCreateDTO.getTagNameList(), article.getId());
        }
        return APIResponse.success(new ArticleAndTagsDTO(article, articleCreateDTO.getTagNameList()));
    }

    @Override
    @Transactional
    public APIResponse articleDelete(Integer id) {
        articleMapper.deleteById(id);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    @Transactional
    public APIResponse articleUpdate(ArticleAndTagsDTO articleAndTagsDTO) {
        if (LengthCheck.check(articleAndTagsDTO.getTitle(), articleAndTagsDTO.getOrigin(),
                articleAndTagsDTO.getContributorName(), articleAndTagsDTO.getReviewerName())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        if (LengthCheck.check(20000, articleAndTagsDTO.getText())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        Article preArticle = articleMapper.selectById(articleAndTagsDTO.getId());
        if (!preArticle.getReleaseTime().equals(articleAndTagsDTO.getReleaseTime())) {
            return APIResponse.error(ErrorCode.ARTICLE_DATE_ERROR);
        }

        articleMapper.updateById(articleAndTagsDTO.toArticle());

        QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", articleAndTagsDTO.getId());
        articleTagMapper.delete(wrapper);
        if (!articleAndTagsDTO.getTagNameList().isEmpty() && articleAndTagsDTO.getTagNameList() != null) {
            tagService.addTagToArticle(articleAndTagsDTO.getTagNameList(), articleAndTagsDTO.getId());
        }

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
        Article article = articleMapper.selectById(id);
        article.setViewsNumber(article.getViewsNumber() + 1);
        articleMapper.updateById(article);
        return APIResponse.success(
                new ArticleAndTagsDTO(article, tagService.getArticleTags(id))
        );
    }

    @Override
    public APIResponse articleSelectSummaryById(Integer id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status", "contributor_name",
                        "reviewer_name", "cover_image_id", "category_id", "views_number")
                .eq("id", id);
        return APIResponse.success(
                new ArticleAndTagsDTO(articleMapper.selectOne(wrapper), tagService.getArticleTags(id))
        );
    }

    private APIResponse getArticleAndTagsFromWrapper(QueryWrapper<Article> wrapper) {
        List<Article> articleList = articleMapper.selectList(wrapper);
        List<ArticleAndTagsDTO> articleAndTagsDTOList = new ArrayList<>();
        for (Article i : articleList) {
            articleAndTagsDTOList.add(new ArticleAndTagsDTO(i, tagService.getArticleTags(i.getId())));
        }
        return APIResponse.success(articleAndTagsDTOList);
    }

    @Override
    public APIResponse articleSelectSummary() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "origin", "release_time", "status", "contributor_name",
                "reviewer_name", "cover_image_id", "category_id", "views_number");
        return getArticleAndTagsFromWrapper(wrapper);
    }

    @Override
    public APIResponse articleSelectSummaryTop() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status", "contributor_name",
                        "reviewer_name", "cover_image_id", "category_id", "views_number")
                .eq("status", 1);
        return getArticleAndTagsFromWrapper(wrapper);
    }

    @Override
    public APIResponse articleSelectSummaryNor() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status", "contributor_name",
                        "reviewer_name", "cover_image_id", "category_id", "views_number")
                .eq("status", 0);
        return getArticleAndTagsFromWrapper(wrapper);
    }

    @Override
    public APIResponse articleSelectSummaryByIds(List<Integer> idList) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status", "contributor_name",
                        "reviewer_name", "cover_image_id", "category_id", "views_number")
                .in("id", idList);
        return getArticleAndTagsFromWrapper(wrapper);
    }

    @Override
    public APIResponse articleSelectSummarySeeByIds(List<Integer> idList) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.
                select("id", "title", "origin", "release_time", "status", "contributor_name",
                        "reviewer_name", "cover_image_id", "category_id", "views_number")
                .ne("status", 2)
                .in("id", idList);
        return getArticleAndTagsFromWrapper(wrapper);
    }

    @Override
    public APIResponse articleSelectTitle(String keyword) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title").like("title", keyword);
        return APIResponse.success(articleMapper.selectList(wrapper));
    }
}
