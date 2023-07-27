package com.SpringJpaFirst.Library_Management_System.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
    Author findByAuthorName(String name);

    @Query(
            value = "SELECT * from author WHERE author_age=?1",
            nativeQuery = true
    )
    List<Author> findByAuthorAge(int age);
}
