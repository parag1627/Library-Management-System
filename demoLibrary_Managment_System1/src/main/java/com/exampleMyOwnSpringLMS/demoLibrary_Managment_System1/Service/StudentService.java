package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Service;


import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentAddResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentUpdateEmailRequestDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO.StudentUpdateEmailResponseDTO;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.LibraryCard;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Student;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.CardStatus;
import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void  addStudent(StudentRequestDTO studentRequestDTO){

        //create student obj
       Student student = new Student();
       student.setName(studentRequestDTO.getName());
       student.setAge(studentRequestDTO.getAge());
       student.setDepartment(studentRequestDTO.getDepartment());
       student.setEmail(studentRequestDTO.getEmail());

       LibraryCard card = new LibraryCard();
       card.setCardStatus(CardStatus.ACTIVATED);
       card.setStudent(student);

       student.setCard(card);

       studentRepository.save(student);


    }
    public String findStudentByEmail(String email){
       Student student = studentRepository.findByEmail(email);
       return student.getName();
    }
    public List<Student> findStudentByAge(int age){
        //Student student = new Student();
        List<Student> studentAge = new ArrayList<>();
        for(Student student : studentRepository.findByAge(age)){
        if(student.getAge() ==age) {
            studentAge.add(student);
        }

        }
        return studentAge;
    }
    public StudentUpdateEmailResponseDTO updateEmail(StudentUpdateEmailRequestDTO studentUpdateEmailRequestDTO){

        Student student = studentRepository.findById(studentUpdateEmailRequestDTO.getId()).get();
        student.setEmail(studentUpdateEmailRequestDTO.getEmail());

        //update step
        Student updatedEmail = studentRepository.save(student);

        StudentUpdateEmailResponseDTO studentUpdateEmailResponseDTO = new StudentUpdateEmailResponseDTO();
        studentUpdateEmailResponseDTO.setId(updatedEmail.getId());
        studentUpdateEmailResponseDTO.setName(updatedEmail.getName());
        studentUpdateEmailResponseDTO.setEmail(updatedEmail.getEmail());

        return studentUpdateEmailResponseDTO;
    }
}
