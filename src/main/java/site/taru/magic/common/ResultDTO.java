package site.taru.magic.common;

import lombok.Data;

@Data
public class ResultDTO<T> {
    private int status;
    private String message;
    private T data;
}