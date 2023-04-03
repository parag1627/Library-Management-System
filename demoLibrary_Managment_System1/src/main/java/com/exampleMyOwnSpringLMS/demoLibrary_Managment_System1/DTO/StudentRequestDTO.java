package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class StudentRequestDTO {
    private String email;
   private int age;
    private String name;
    private Department department;
}
