package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Category;
import com.example.demo.utils.APIResponse;

public interface CategoryService extends IService<Category> {
    APIResponse categoryGetName(Integer id);

    APIResponse categoryGetId(String name);

    APIResponse categoryGet();
}
