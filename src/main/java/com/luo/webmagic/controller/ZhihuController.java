package com.luo.webmagic.controller;

import com.luo.webmagic.mapper.ZhihuMapper;
import com.luo.webmagic.pipeline.ZhiHuPipeline;
import com.luo.webmagic.process.Magic;
import com.luo.webmagic.process.Zhihu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

@RestController
public class ZhihuController {
    @Autowired
    ZhiHuPipeline zhiHuPipeline;
    @GetMapping("/zh")
    public String index() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new Zhihu())
                .addUrl("https://www.zhihu.com/question/286837417")
                .addPipeline(zhiHuPipeline)
                .thread(5)
                .run();
        return "xxxx";
    }
}
