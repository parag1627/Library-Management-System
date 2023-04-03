package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
//    private String validTill;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updationDate;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;


    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card" ,cascade = CascadeType.ALL)
    List<Transaction> transactionList  = new ArrayList<>();

    @OneToMany(mappedBy = "card" ,cascade = CascadeType.ALL)
    List<Book> bookIssued= new ArrayList<>();



}

