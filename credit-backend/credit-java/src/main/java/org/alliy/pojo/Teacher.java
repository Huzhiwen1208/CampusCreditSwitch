package org.alliy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("teacher")
@Data
public class Teacher {
    @TableId
    private Integer id;
    private String name;
    private String mail;
    private String major;

    @TableField(exist = false)
    private List<Course> courses;
    @TableField(exist = false)
    private List<Student> students;
}
