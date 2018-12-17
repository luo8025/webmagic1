package com.luo.webmagic.vo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CSDN")
@Data
public class CSDNVo {
    private String title;
    private String time;
    private String author;
    private String url;
    private String reading;
    private String label;
    private String authorUrl;
}
