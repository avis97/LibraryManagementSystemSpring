package com.SpringJpaFirst.Library_Management_System.Service;


import com.SpringJpaFirst.Library_Management_System.DTO.StudentRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.StudentResponseDTO;
import com.SpringJpaFirst.Library_Management_System.DTO.StudentUpdateClass;
import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import com.SpringJpaFirst.Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
@Service
public class StudentService{

    @Autowired
    StudentRepository repo;
    public void addStudent(StudentRequestDto studentDto){
        //create student object
        Student student=new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setDepartment(studentDto.getDepartment());

        //create card object..
        LibraryCard card=new LibraryCard();
        card.setStatus(Status.ACTIVATED);
        card.setValidDate("3/2025");
        card.setStudent(student);

        student.setCard(card);
        repo.save(student);

    }
    public String findNameByEmail(String email){
        Student student=repo.findByEmail(email);
        return student.getName();
    }
    public StudentResponseDTO updateStudentEmail(StudentUpdateClass sUpdate){
        Student student=repo.findById(sUpdate.getId()).get();
        student.setEmail(sUpdate.getEmail());
        //update step;
        Student updateStudentEmail=repo.save(student);
        //update the return type.. convert update to response..
        StudentResponseDTO updateStudentDto=new StudentResponseDTO();
        updateStudentDto.setId(updateStudentEmail.getStudentId());
        updateStudentDto.setName(updateStudentEmail.getName());
        updateStudentDto.setEmail(updateStudentEmail.getEmail());
        return updateStudentDto;
    }
}
