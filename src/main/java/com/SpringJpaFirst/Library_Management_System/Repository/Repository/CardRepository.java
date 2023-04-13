package com.SpringJpaFirst.Library_Management_System.Repository.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer>{
}
