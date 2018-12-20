package site.taru.magic.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.taru.magic.entity.News;
import site.taru.magic.mapper.NewsMapper;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("NewsPipeline")
public class NewsPipeline implements Pipeline {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<News> items=resultItems.get("news");
        System.out.println(items.size());

        for (int i=0;i<items.size();i++) {
            System.out.println();
            newsMapper.insert(items.get(i));
        }
    }
}