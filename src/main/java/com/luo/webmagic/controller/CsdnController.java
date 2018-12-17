package com.luo.webmagic.controller;

import com.luo.webmagic.biz.CsdnBiz;
import com.luo.webmagic.entity.Csdn;
import com.luo.webmagic.pipeline.CsdnInfoDaoPipeline;
import com.luo.webmagic.process.Magic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;

@RestController
public class CsdnController{
    @Autowired
    CsdnBiz csdnBiz;
    @Autowired
    CsdnInfoDaoPipeline csdnInfoDaoPipeline;

    @PostMapping("/add")
     void add(@RequestBody Csdn csdn) throws Exception {
        csdnBiz.add(csdn);
        }

    //@Scheduled(fixedRate = 10000)
    @GetMapping("/")
    public String index() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new Magic())
                .addUrl("https://www.csdn.net/nav/db")
                .addPipeline(csdnInfoDaoPipeline)
                .thread(5)
                .run();
        return "xxxx";
    }
}