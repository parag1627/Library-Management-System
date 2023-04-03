package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUpdateEmailResponseDTO {

    private String name;
    private String email;
    private int id;
}
