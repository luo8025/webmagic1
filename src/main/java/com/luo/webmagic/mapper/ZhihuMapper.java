package com.luo.webmagic.mapper;

import com.luo.webmagic.entity.Csdn;
import com.luo.webmagic.entity.ZhiHu;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhihuMapper {
     void insert(String url);

}
