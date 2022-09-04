package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cate")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/name/{id}")
    public APIResponse categoryGetName(@PathVariable("id") Integer id) {
        return categoryService.categoryGetName(id);
    }

    @GetMapping("/id/{name}")
    public APIResponse categoryGetId(@PathVariable("name") String name) {
        return categoryService.categoryGetId(name);
    }

    @GetMapping("/all")
    public APIResponse categoryGet() {
        return categoryService.categoryGet();
    }
}
