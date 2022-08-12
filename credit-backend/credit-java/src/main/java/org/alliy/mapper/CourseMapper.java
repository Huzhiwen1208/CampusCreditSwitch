package org.alliy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.alliy.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> selectByStudentId(Integer studentId);

    List<Course> selectByTeacherId(Integer teacherId);
}
