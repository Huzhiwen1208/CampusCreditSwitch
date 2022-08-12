package org.alliy;

import org.alliy.pojo.Student;
import org.alliy.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.alliy.mapper")
class CreditJavaApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    public  void testStudent() {
        List<Student> students = studentService.selectAll();
        System.out.println(students);
    }

    @Test
    void testStudentController(){

    }
}
