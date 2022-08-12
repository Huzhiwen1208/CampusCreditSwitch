package org.alliy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("notice")
@Data
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String content;
    @TableField("put_time")
    private Date date;
    private String head;
}
