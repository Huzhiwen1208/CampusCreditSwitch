package org.alliy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplyForm implements Serializable {
    private String name;
    private Integer id;
    private String major;
    private String academy;
    private Double credits;
    private String mail;
    private Date date;
    private Integer preStatus;

    private Integer processStatus;
    private String result;
}
