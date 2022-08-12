package org.alliy.service.Impl;

import org.alliy.mapper.CourseMapper;
import org.alliy.mapper.StudentMapper;
import org.alliy.mapper.TeacherMapper;
import org.alliy.pojo.Teacher;
import org.alliy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Teacher> getAllTeacher(){
        List<Teacher> teachers = teacherMapper.selectList(null);
        for (Teacher teacher : teachers) {
            teacher.setCourses(courseMapper.selectByTeacherId(teacher.getId()));
            teacher.setStudents(studentMapper.selectByTeacherId(teacher.getId()));
        }
        return teachers;
    }
}
