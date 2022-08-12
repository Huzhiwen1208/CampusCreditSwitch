package org.alliy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.alliy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> selectByTeacherId(Integer teacherId);
}
