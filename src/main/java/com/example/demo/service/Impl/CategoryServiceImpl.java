package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public APIResponse categoryGetName(Integer id) {
        return APIResponse.success(categoryMapper.selectById(id).getName());
    }

    @Override
    public APIResponse categoryGetId(String name) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.select("id").eq("name", name);
        return APIResponse.success(categoryMapper.selectOne(wrapper).getId());
    }

    @Override
    public APIResponse categoryGet() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        return APIResponse.success(categoryMapper.selectList(wrapper));
    }
}
