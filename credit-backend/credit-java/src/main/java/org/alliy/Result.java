package org.alliy;

import lombok.Data;

@Data
public class Result {
    private String msg;
    private Integer code;
    private Object data;
}
