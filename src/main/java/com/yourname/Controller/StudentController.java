package com.yourname.Controller;

import com.yourname.Entity.Student;
import com.yourname.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id){
        this.studentService.deleteStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        this.studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        this.studentService.insertStudent(student);
    }

}
