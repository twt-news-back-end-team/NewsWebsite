package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ArticleTagMapper;
import com.example.demo.mapper.TagMapper;
import com.example.demo.pojo.ArticleTag;
import com.example.demo.pojo.Tag;
import com.example.demo.service.TagService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Autowired
    ArticleTagMapper articleTagMapper;
    @Override
    @Transactional
    public APIResponse saveTag(String name) {
        Tag tag = tagMapper.selectByName(name);
        if(tag!=null) {
            return APIResponse.error(ErrorCode.Tag_EXIST_ERROR);
        }
        tag = new Tag(null,name);
        tag.setId(tagMapper.insert(tag));
        return APIResponse.success(tag);
    }

    @Override
    @Transactional
    public APIResponse deleteTagById(Integer id) {
        tagMapper.deleteById(id);
        return APIResponse.success("删除成功");
    }

    @Override
    @Transactional
    public APIResponse updateTag(String oldName, String newName) {
        Tag tag = tagMapper.selectByName(oldName);
        if(tag==null) {
            return APIResponse.error(ErrorCode.Tag_NOT_EXIST_ERROR);
        }
        tag.setName(newName);
        tagMapper.updateById(tag);
        return APIResponse.success(tag);
    }

    @Override
    @Transactional
    public APIResponse searchTagByName(String name) {
        Tag tag = tagMapper.selectByName(name);
        if(tag==null) {
            return APIResponse.error(ErrorCode.Tag_NOT_EXIST_ERROR);
        }
        return APIResponse.success(tag);
    }

    @Override
    @Transactional
    public APIResponse addTagToArticle(List<String> tagNameList, Integer articleId) {
        //如果标签不存在则新建
        for (String name : tagNameList) {
            Tag tag = tagMapper.selectByName(name);
            if(tag==null) {
                tag = new Tag();
                tag.setName(name);
                tag.setId(tagMapper.insert(tag));
            }
            ArticleTag articleTag = new ArticleTag(null,articleId, tag.getId());
            QueryWrapper<ArticleTag> qw = new QueryWrapper<>();
            qw.eq("article_id",articleId);
            qw.eq("tag_id",tag.getId());
            ArticleTag articleTag1 = articleTagMapper.selectOne(qw);
            if(articleTag1==null) {
                articleTagMapper.insert(articleTag);
            }

        }
        return APIResponse.success("添加完成");
    }

    @Override
    @Transactional
    public APIResponse deleteTagFromArticle(String tagName, Integer articleId) {
        Tag tag = tagMapper.selectByName(tagName);
        QueryWrapper<ArticleTag> qw = new QueryWrapper<>();
        qw.eq("article_id",articleId);
        qw.eq("tag_id",tag.getId());
        ArticleTag articleTag = articleTagMapper.selectOne(qw);
        articleTagMapper.deleteById(articleTag.getId());
        return APIResponse.success("删除完成");
    }

    @Override
    @Transactional
    public APIResponse searchArticleByTags(List<String> tagNames) {
        List<String> idsList = new ArrayList<>();
        List<ArticleTag> articleTags;
        List<Integer> articleIds = new ArrayList<>();
        for (String tagName : tagNames) {
            QueryWrapper<ArticleTag> qw = new QueryWrapper<>();
            Tag tag = tagMapper.selectByName(tagName);
            qw.eq("tag_id",tag.getId());
            //只在限定数据内找
            if(!idsList.isEmpty()) {
                qw.in("id",idsList);
            }
            articleTags = articleTagMapper.selectList(qw);
            idsList.clear();
            if(articleTags.isEmpty()) {
                return APIResponse.success(null);
            }
            //获得匹配的稿件id
            articleIds.clear();
            for (ArticleTag articleTag : articleTags) {
                articleIds.add(articleTag.getArticleId());
            }
            //根据稿件id获得限定数据
            for (Integer articleId : articleIds) {
                QueryWrapper<ArticleTag> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("article_id",articleId);
                articleTags = articleTagMapper.selectList(queryWrapper);
                for (ArticleTag articleTag : articleTags) {
                    idsList.add(Integer.toString(articleTag.getId()));
                }
            }
        }
        return APIResponse.success(articleIds);
    }
}
