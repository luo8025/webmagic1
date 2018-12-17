package com.luo.webmagic.biz;

import com.luo.webmagic.entity.Csdn;
import com.luo.webmagic.mapper.BlogMapper;
import com.luo.webmagic.mapper.CsdnMapper;
import com.luo.webmagic.vo.CSDNVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CsdnBiz {
    @Autowired
    CsdnMapper csdnMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    public void add(Csdn csdn){
        csdnMapper.insert(csdn);
    }

    public void save(CSDNVo csdnVo){
        mongoTemplate.save(csdnVo,"CSDN");
    }
}
