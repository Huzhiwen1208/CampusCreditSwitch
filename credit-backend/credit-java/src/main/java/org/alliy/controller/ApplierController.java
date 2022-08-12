package org.alliy.controller;

import org.alliy.Result;
import org.alliy.pojo.Applier;
import org.alliy.pojo.ApplyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/appliers")
public class ApplierController {
    @Autowired
    private Applier applier;
    @GetMapping("/students")
    public Result getAllStudent() {
        Result r = new Result();
        try {
            List<ApplyForm> applyForms = Applier.applyForms;
            List<ApplyForm> applyFormeds = Applier.applyFormeds;
            r.setMsg("操作成功");
            r.setCode(200);
            r.setData(applyForms.addAll(applyFormeds));
        } catch (Exception e) {
            r.setData(null);
            r.setMsg("操作失败");
            r.setCode(500);
            e.printStackTrace();
        }
        return  r;
    }
    @DeleteMapping("/students/{list}")
    public Result deleteOneStudent(@PathVariable ArrayList list){
        Result r = new Result();
        List<ApplyForm> applyForms = Applier.applyForms;
        List<ApplyForm> applyFormeds = Applier.applyFormeds;
        for(int i = 0;i < applyForms.size();i++){
            if(applyForms.get(i).getId() == list.get(0)) {
                ApplyForm applyForm = applyForms.get(i);
                applyForm.setProcessStatus(1);
                applyForm.setResult((String) list.get(1));
                applyFormeds.add(applyForm);
                applyForms.remove(i);
                break;
            }
        }
        return this.getAllStudent();
    }
}
