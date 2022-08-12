package org.alliy.controller;

import org.alliy.Result;
import org.alliy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")
@CrossOrigin
public class NoticeController {


    @Autowired
    private NoticeService service;

    @GetMapping
    public Result getAll(){
        Result r = new Result();
        if(service.selectAll()!=null){
            r.setCode(200);
            r.setMsg("success");
            r.setData(service.selectAll());
        }else{
            r.setData(null);
            r.setCode(500);
            r.setMsg("error");
        }
        return  r;
    }
}
