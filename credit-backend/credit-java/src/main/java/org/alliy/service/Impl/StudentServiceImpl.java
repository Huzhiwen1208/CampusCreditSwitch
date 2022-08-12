package org.alliy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.alliy.mapper.AccoutMapper;
import org.alliy.mapper.CourseMapper;
import org.alliy.mapper.StudentMapper;
import org.alliy.mapper.TeacherMapper;
import org.alliy.pojo.Accout;
import org.alliy.pojo.Course;
import org.alliy.pojo.Student;
import org.alliy.pojo.Teacher;
import org.alliy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AccoutMapper accoutMapper;

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Student> selectAll() {
        List<Student> students = studentMapper.selectList(null);
        for (Student student : students) {
            //给每个学生携带密码表中的密码信息
            student.setPassword( accoutMapper.selectById(student.getId()).getPassword() );
        }
        return students;
    }

    @Override
    public boolean updateByStudent(Student student) {
        studentMapper.updateById(student);
        return true;
    }

    @Override
    public boolean deleteByStudent(Student student) {
        studentMapper.deleteById(student);
        return true;
    }

    @Override
    public List<Student> selectByName(String name) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        List<Student> students = studentMapper.selectList(wrapper);
        for (Student student : students) {
            student.setPassword( accoutMapper.selectById(student.getId()).getPassword() );
        }
        return students;
    }

    @Override
    public boolean addByStudent(Student student) {
        studentMapper.insert(student);
        Accout accout = new Accout();
        accout.setId(student.getId());
        accout.setPassword(student.getPassword());
        accoutMapper.insert(accout);
        return true;
    }

    @Override
    public boolean submit2Teacher(Student student, String major) {
        //提交至教师系统
        boolean flag = false;
        try{
            Teacher teacher = new Teacher();
            teacher.setMajor(major);
            List<Student> students = teacher.getStudents();
            students.add(student);
            teacher.setStudents(students);
            teacherMapper.insert(teacher);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  flag;
    }

    @Override
    public List<Student> showStudentListByTeacherId(Integer teacherId,List<Student> oldStudentList) {
        for (Student student : oldStudentList) {
            //该学生是否已经删除了所有的该老师课程
            boolean flag = false;
            List<Course> courses = courseMapper.selectByStudentId(student.getId());
            for (Course course: courses) {
               if(courseMapper.selectByTeacherId(teacherId).contains(course)){
                   flag = true;
                   break;
               }
            }
            if( !flag){
                oldStudentList.remove(student);
            }
        }
        return oldStudentList;
    }
}
