package com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Repository;

import com.exampleMyOwnSpringLMS.demoLibrary_Managment_System1.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
}
