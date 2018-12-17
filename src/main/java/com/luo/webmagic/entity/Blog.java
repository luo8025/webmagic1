package com.luo.webmagic.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="test")
public class Blog {
    private String id;
    private String head;
    private String body;
}
