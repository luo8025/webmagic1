package com.luo.webmagic.process;


import com.luo.webmagic.entity.ZhiHu;
import com.luo.webmagic.mapper.ZhihuMapper;
import com.luo.webmagic.unitl.UserAgentUtil;
import com.luo.webmagic.vo.CSDNVo;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;


public class Zhihu implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);


    @Override
    public void process(Page page) {
        int i=0;
        List<String> list1=new ArrayList<String>();
        List<String> list2=page.getHtml().regex("https://www.zhihu.com/question/286837417/answer/\\w+").all();
        for (String str1:list2) {
            System.out.println(str1);
        }
        page.addTargetRequests(list2);
        List<String> list=page.getHtml().xpath("//div[@class='RichContent-inner']//figure//img/@src").all();
        for (String str:list) {
            i++;
            if(i%2!=0){
                list1.add(str);
                System.out.println(str);
            }
        }
        page.putField("zhurl",list1);
    }
    @Override
    public Site getSite() {
        site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        return site;
    }
}

