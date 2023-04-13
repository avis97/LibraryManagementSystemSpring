package com.SpringJpaFirst.Library_Management_System.Repository.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
