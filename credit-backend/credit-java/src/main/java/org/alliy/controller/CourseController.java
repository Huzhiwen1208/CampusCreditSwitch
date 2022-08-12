package org.alliy.controller;

import org.alliy.Result;
import org.alliy.mapper.CourseMapper;
import org.alliy.pojo.Course;
import org.alliy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/courses",produces = "application/json;charset=utf-8")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/{studentId}")
    public Result getByStudentId(@PathVariable Integer studentId){
        Result r = new Result();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(service.selectByStudentId(studentId));
        return r;
    }

    @GetMapping
    public Result getAll(){
        Result r = new Result();
        List<Course> courses = new ArrayList<>();
        if((courses = service.selectAll())!=null){
            r.setCode(200);
            r.setMsg("操作成功");
            r.setData(courses);
        }else{
            r.setCode(500);
            r.setData(null);
            r.setMsg("失败");
        }
        return  r;
    }

}
