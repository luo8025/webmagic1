package com.luo.webmagic.process;

import com.luo.webmagic.unitl.UserAgentUtil;
import com.luo.webmagic.vo.CSDNVo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.ArrayList;
import java.util.List;


public class Magic implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);


    @Override
    public void process(Page page) {
        List<CSDNVo> list=new ArrayList<>();
        List<String> str=page.getHtml().xpath("//ul[@class='feedlist_mod db']/li//h2/a/@href").all();
                page.addTargetRequests(str);
                CSDNVo csdn=new CSDNVo();
                csdn.setTitle(page.getHtml().xpath("//div[@class='article-title-box']/h1/text()").toString());
                csdn.setAuthor(page.getHtml().xpath("//div[@class='article-info-box']//a/text()").toString());
                csdn.setTime(page.getHtml().xpath("//div[@class='article-info-box']//span/text()").toString());
                csdn.setUrl(page.getHtml().xpath("//div[@class='article-info-box']//a/@href").toString());
                csdn.setReading(page.getHtml().xpath("//div[@class='article-info-box']//span[@class='read-count']/text()").toString());
                csdn.setLabel(page.getHtml().xpath("//span[@class='tags-box artic-tag-box']/a/text()").toString());
                csdn.setAuthorUrl(page.getHtml().xpath("//link[@rel='canonical']/@href").toString());
                if(csdn.getTitle()!=null&&csdn.getAuthor()!=null&&csdn.getTime()!=null) {
                    list.add(csdn);
                    page.putField("csdnListInfo",list);
                }
            }
    @Override
    public Site getSite() {
        site.setUserAgent(UserAgentUtil.getRandomUserAgent());
        site.addCookie("uuid_tt_dd","10_28867322980-1540460387498-589041");
        site.setCharset("UTF-8");
        return site;
    }
}
