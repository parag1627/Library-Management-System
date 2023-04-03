package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
