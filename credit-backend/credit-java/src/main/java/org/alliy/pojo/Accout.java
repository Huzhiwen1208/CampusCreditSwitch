package org.alliy.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("passwd")
@Data
public class Accout {
    @TableId
    private Integer id;
    private String password;
}
