package com.luo.webmagic.pipeline;

import com.luo.webmagic.biz.CsdnBiz;
import com.luo.webmagic.entity.Csdn;
import com.luo.webmagic.vo.CSDNVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("CsdnInfoDaoPipeline")
public class CsdnInfoDaoPipeline implements Pipeline {

    @Autowired
    private CsdnBiz csdnBiz;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<CSDNVo> items=resultItems.get("csdnListInfo");

        for (CSDNVo item:items) {
            //csdnBiz.add(item);
            csdnBiz.save(item);
        }
    }
}
