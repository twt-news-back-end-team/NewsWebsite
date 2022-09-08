package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleAndTagsDTO {
    private Integer id;
    private String text;
    private String title;
    private String origin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date releaseTime;
    private Integer status;
    private String contributorName;
    private String reviewerName;
    private Integer contributorId;
    private Integer coverImageId;
    private Integer bannerImageId;
    private Integer categoryId;
    private Integer viewsNumber;
    private List<String> tagNameList;

    public ArticleAndTagsDTO(Article article, List<String> tagNameList) {
        this.id = article.getId();
        this.text = article.getText();
        this.title = article.getTitle();
        this.origin = article.getOrigin();
        this.releaseTime = article.getReleaseTime();
        this.status = article.getStatus();
        this.contributorName = article.getContributorName();
        this.reviewerName = article.getReviewerName();
        this.contributorId = article.getContributorId();
        this.coverImageId = article.getCoverImageId();
        this.bannerImageId = article.getBannerImageId();
        this.categoryId = article.getCategoryId();
        this.viewsNumber = article.getViewsNumber();
        this.tagNameList = tagNameList;
    }

    public Article toArticle() {
        return new Article(id, text, title, origin, releaseTime, status, contributorName, reviewerName,
                contributorId, coverImageId, bannerImageId, categoryId, viewsNumber);
    }
}
