package org.alliy.controller;

import org.alliy.Result;
import org.alliy.pojo.Course;
import org.alliy.pojo.Student;
import org.alliy.pojo.Teacher;
import org.alliy.service.CourseService;
import org.alliy.service.StudentService;
import org.alliy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/teachers", produces = "application/json;charset=utf-8")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping
    public Result getAllTeacher() {
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(teacherService.getAllTeacher());
        return r;
    }

//    @PostMapping("/students/{sid}/{cid}")
//    public Result addCourseByCid(@PathVariable Integer sid, @PathVariable String cid) {
//        Result r = new Result();
//        try {
//            Course course = courseService.selectByCid(cid);
//            Student student = service.selectBySid(sid);
//            //操作数据库存储修读课程
//            student.setPreCourses(student.getPreCourses().add(course));
//            r.setMsg("操作成功");
//            r.setCode(200);
//            r.setData(true);
//        } catch (Exception e) {
//            r.setData(false);
//            r.setMsg("操作失败");
//            r.setCode(500);
//            e.printStackTrace();
//        }
//        return  r;
//    }
}
