package site.taru.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.taru.magic.pipeline.NewsPipeline;
import site.taru.magic.process.DankeProcess;
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
    @GetMapping("/danke")
    public String danke() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Spider.create(new DankeProcess())
                .addUrl("https://www.dankegongyu.com/")
                .addPipeline(newsPipeline)
                .thread(1)
                .run();
        return "xxxx";
    }

}