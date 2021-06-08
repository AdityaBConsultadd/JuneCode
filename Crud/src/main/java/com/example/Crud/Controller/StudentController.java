package com.example.Crud.Controller;


import com.example.Crud.JPA.StudentRepo;
import com.example.Crud.Model.Student;
import com.example.Crud.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    StudentRepo studentRepo;
    //read
    @GetMapping("/")
    List<Student> get(){
        return studentRepo.findAll();
    }
    //create
    @PostMapping
    Student post(@RequestBody Student student){
        return studentRepo.save(student);
    }

    //delete
    @DeleteMapping("/{id}")
    String delete(@PathVariable(value = "id")Integer integer) throws ResourceException {
        Student student= studentRepo.findById(integer).orElseThrow(()-> new ResourceException("Student",integer));
        studentRepo.delete(student);
        return "deleted";
    }

}
