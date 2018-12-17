package com.luo.webmagic.mapper;

import com.luo.webmagic.entity.Blog;
import com.luo.webmagic.vo.CSDNVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
    List<Blog> query();

    void add(Blog blog);

    Void save(CSDNVo csdnVo);

}
