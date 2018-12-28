package site.taru.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.taru.magic.pipeline.NewsPipeline;
import site.taru.magic.process.V2exProcess;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

@RestController
public class NewsController {
    @Autowired
    NewsPipeline newsPipeline;

    @GetMapping("/v2")
    public String index() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new V2exProcess())
                .addUrl("https://www.v2ex.com/?tab=hot")
                .addPipeline(newsPipeline)
                .thread(1)
                .run();
        return "xxxx";
    }

    @GetMapping("/tt")
    public String toutiao() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new ToutiaoProcess())
                .addUrl("https://www.toutiao.com/ch/news_hot/")
                .addPipeline(newsPipeline)
                .thread(1)
                .run();
        return "xxxx";
    }
}