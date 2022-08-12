package org.alliy.controller;

import org.alliy.Result;
import org.alliy.pojo.Course;
import org.alliy.pojo.Student;
import org.alliy.service.CourseService;
import org.alliy.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/students",produces = "application/json;charset=utf-8")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private CourseService courseService;
    @GetMapping
    public Result getAll() {
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData( service.selectAll() );
        return  r;
    }
    @GetMapping("/{name}")
    public  Result getByName(@PathVariable String name){
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        if(name==null || "".equals(name)){
            r.setData(service.selectAll());
        }else {
            List<Student> students = service.selectByName(name);
            r.setData(students);
        }
        System.out.println(name);
        return r;
    }
    @PutMapping
    public  Result updateStudent(@RequestBody Student student) {
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        //更新数据库
        service.updateByStudent(student);
        r.setData(service.selectAll());
        return r;
    }
    @DeleteMapping
    public Result deleteOne(@RequestBody Student student){
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        System.out.println(student);
        service.deleteByStudent(student);
        r.setData(service.selectAll());
        return r;
    }
    @PostMapping
    public Result addOneStudent(@RequestBody Student student){
        Result r = new Result();
        if(service.addByStudent(student)) {
            r.setCode(200);
            r.setMsg("操作成功");
        }else{
            r.setCode(500);
            r.setMsg("操作失败");
        }
        return  r;
    }

//    @GetMapping("/selectCourses/{sid}/{cid}")
//    public Result selectCourses(@PathVariable Integer sid,@PathVariable String cid) {
//        //cid 为课程号 sid 为学生学号
//        Result r = new Result();
//        try {
//            Course course = courseService.selectByCid(cid);
//            Student student = service.selectBySid(sid);
//            student.setCourses(student.getCourses().add(course));
//            r.setMsg("操作成功");
//            r.setCode(200);
//            r.setData(student.getCourses());
//        } catch (Exception e) {
//            r.setMsg("操作失败");
//            r.setCode(500);
//            e.printStackTrace();
//        }
//        return  r;
//    }
}
