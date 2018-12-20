package site.taru.magic.process;

import site.taru.magic.entity.News;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ZhihuProcess implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    List<News> ObjectList =new ArrayList<News>();


    @Override
    public void process(Page page) {
        page.addTargetRequest("https://www.zhihu.com/hot");
        System.out.println(page.toString());
        try{
            News news=new News();
            news.setId(UUID.randomUUID().toString());
            news.setTitle(page.getHtml().xpath("//div[@class='Topstory-hot HotList']//section[@class='HotItem']//a/@href").toString());
            news.setUrl(page.getHtml().xpath("//section[@class='HotItem']//a/@href").toString());
            news.setHot(page.getHtml().xpath("//section[@class='HotItem']//svg/text()").toString());
            ObjectList.add(news);
        }catch(Exception e){
            e.printStackTrace();
        }
        page.putField("news",ObjectList);
    }
    @Override
    public Site getSite() {
        site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        return site;
    }
}
