package org.alliy.service;

import org.alliy.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();
    boolean updateByStudent(Student student);
    boolean deleteByStudent(Student student);
    List<Student> selectByName(String name);
    boolean addByStudent(Student student);
    boolean submit2Teacher(Student student,String major);
    List<Student> showStudentListByTeacherId(Integer teacherId,List<Student> oldStudentList);
}
