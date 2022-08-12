package org.alliy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {
    @TableId
    private String id;
    @TableField("chinese_name")
    private String chineseName;
    @TableField("english_name")
    private String englishName;
    private String detail;
    private Double credits;
}
