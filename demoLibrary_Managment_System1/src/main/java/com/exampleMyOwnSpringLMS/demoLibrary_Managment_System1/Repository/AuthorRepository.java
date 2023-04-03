package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
