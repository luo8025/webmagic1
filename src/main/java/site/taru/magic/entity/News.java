package site.taru.magic.entity;

import lombok.Data;

@Data
public class News {
    private String id;
    private String title;
    private String url;
    private String source;
    private String hot;
    private String createTime;
    private String delete;
}
