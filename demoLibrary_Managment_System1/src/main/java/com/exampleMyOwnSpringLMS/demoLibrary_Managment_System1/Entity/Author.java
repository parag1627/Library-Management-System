package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity;


import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.Genere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Author {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
   private String email;
   private int age;
   private int mobNo;


   
   @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
   List<Book> books = new ArrayList<>();


}
