package org.alliy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.alliy.mapper.CourseMapper;
import org.alliy.pojo.Course;
import org.alliy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper mapper;

    @Override
    public List<Course> selectByStudentId(Integer studentId) {
        return mapper.selectByStudentId(studentId);
    }

    @Override
    public List<Course> selectAll() {
        return mapper.selectList(null);
    }
}
