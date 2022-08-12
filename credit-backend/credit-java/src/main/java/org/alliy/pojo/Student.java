package org.alliy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    @TableId
    private Integer id;
    private String name;
    private String gender;
    private String grade;
    private Integer age;
    private String mail;
    private String academy;
    private String major;
    private String card;
//    由账户表获得的学生登录密码
    @TableField(exist = false)
    private String password;
}
