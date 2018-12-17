package com.luo.webmagic.service.impl;

import com.luo.webmagic.entity.Blog;
import com.luo.webmagic.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Blog> query() {
        return mongoTemplate.findAll(Blog.class);
    }

    @Override
    public void add(Blog blog) {
        mongoTemplate.save(blog,"test");
    }
}
