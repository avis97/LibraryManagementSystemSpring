package com.SpringJpaFirst.Library_Management_System.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    Book findByBookTitle(String name);

}
