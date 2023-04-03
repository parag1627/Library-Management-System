package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Genere;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorAddRequestDTO {
    private  String name;
    private String email;
    private int age;
  // private Genere genere;
}
