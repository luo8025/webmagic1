package com.luo.webmagic.pipeline;

import com.luo.webmagic.mapper.ZhihuMapper;
import com.luo.webmagic.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
@Component("ZhiHuPipeline")
public class ZhiHuPipeline implements Pipeline {
    @Autowired
    ZhihuMapper zhihuMapper;
    @Autowired
    FileService fileService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> items=resultItems.get("zhurl");
        //fileService.downloadPicture(items);
//        for (String item:items) {
////            System.out.println(item);
////            zhihuMapper.insert(item);
//            fileService.downloadPicture();
//        }
    }
}