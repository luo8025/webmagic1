package site.taru.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.taru.magic.pipeline.NewsPipeline;
import site.taru.magic.process.V2exProcess;
import site.taru.magic.process.ZhihuProcess;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

@RestController
public class NewsController {
    @Autowired
    NewsPipeline newsPipeline;
    @GetMapping("/zh")
    public String index() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new V2exProcess())
                .addUrl("https://www.v2ex.com/?tab=hot")
                .addPipeline(newsPipeline)
                .thread(1)
                .run();
        return "xxxx";
    }
}