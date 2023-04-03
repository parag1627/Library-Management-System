package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Controller;


import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentUpdateEmailRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentUpdateEmailResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Student;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        studentService.addStudent(studentRequestDTO);
        return "Student has been added successfully";
    }
    @GetMapping("/find_by_email")
         public String findStudentByEmail(@RequestParam("email") String email){
            return studentService.findStudentByEmail(email);
    }


    @GetMapping("/find_by_age")
    public List<Student> findStudentByAge(@RequestParam("age") int age){
         return studentService.findStudentByAge(age);
    }

@PutMapping("update_email")
    public StudentUpdateEmailResponseDTO updateEmail(@RequestBody StudentUpdateEmailRequestDTO studentUpdateEmailRequestDTO){
    return studentService.updateEmail(studentUpdateEmailRequestDTO);
}


}
