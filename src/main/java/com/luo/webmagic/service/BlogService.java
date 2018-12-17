package com.luo.webmagic.service;

import com.luo.webmagic.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> query();


    void add(Blog blog);
}
