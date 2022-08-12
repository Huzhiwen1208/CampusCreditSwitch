package org.alliy.service;

import org.alliy.pojo.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<Course> selectByStudentId(Integer studentId);
    List<Course> selectAll();
}
