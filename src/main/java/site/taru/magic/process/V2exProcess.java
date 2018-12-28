package site.taru.magic.process;

import site.taru.magic.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class V2exProcess implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);


    @Override
    public void process(Page page) {
        page.addTargetRequest("https://www.v2ex.com/?tab=hot");
        List<News> ObjectList = new ArrayList<News>();

        List<String> listTitle = page.getHtml().xpath("//div[@class='box']//span[@class='item_title']/a/text()").all();
        List<String> listUrl = page.getHtml().xpath("//div[@class='box']//span[@class='item_title']/a/@href").all();
        for (int i = 0; i < listTitle.size(); i++) {
            News news = new News();
            news.setTitle(listTitle.get(i));
            news.setUrl("https://www.v2ex.com" + listUrl.get(i));
            news.setSource("V2EX");
            ObjectList.add(news);
        }

        page.putField("news", ObjectList);
    }

    @Override
    public Site getSite() {
        site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        return site;
    }
}
