package site.taru.magic.process;

import site.taru.magic.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;


public class DankeProcess  implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);


    @Override
    public void process(Page page) {
        page.addTargetRequest("https://www.dankegongyu.com/room/bj?from=hot_keywords&search_text=%E9%9D%92%E5%B9%B4%E8%B7%AF");
        System.out.println(page.getHtml());
    }

    @Override
    public Site getSite() {
        site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        return site;
    }
}