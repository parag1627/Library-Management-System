package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    private String name;
    @Column(nullable = true)
    private String email;
    private int age;


    @Enumerated(EnumType.STRING)
    private Department department;
//    @JsonIgnore

    @OneToOne(mappedBy ="student", cascade = CascadeType.ALL)
    LibraryCard card;
}
