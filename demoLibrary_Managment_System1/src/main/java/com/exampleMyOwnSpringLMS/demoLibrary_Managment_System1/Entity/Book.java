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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     private String title;
     private int  price;
     private boolean isIssued;

    @Enumerated(EnumType.STRING)
    Genere genere;


    @ManyToOne
    @JoinColumn
    //@JsonIgnore
    Author author;

    @OneToMany(mappedBy = "book" ,cascade = CascadeType.ALL)
    List<Transaction> transaction = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
