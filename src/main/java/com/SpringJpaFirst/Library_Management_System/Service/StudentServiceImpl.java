package com.SpringJpaFirst.Library_Management_System.Service;
import com.SpringJpaFirst.Library_Management_System.Converter.StudentConverter;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {
        //convert studentRequestDto to student by using StudentConverter
        Student student = StudentConverter.studentRequestDtoToStudent(studentRequestDto);

        // Have to generate new card when student will register.
        LibraryCard card = new LibraryCard();
        card.setStatus(Status.ACTIVATED);
        card.setValidDate("06/2025");
        card.setStudent(student);
        //put the card details in student models.
        student.setCard(card);

        //save the student in the database.
        studentRepository.save(student);

        //convert student to studentResponseDto
        StudentResponseDto studentResponseDto = StudentConverter.studentToStudentResponseDto(student);

        return studentResponseDto;
    }
    public StudentResponseDto findByEmail(StudentRequestDtoByEmail forEmail){

        //find the student by email...the filebyemail method have in student repository
        Student student=studentRepository.findByStudentEmail(forEmail.getStudentEmail());

        StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(student);
        return studentResponseDto;

    }
    public StudentResponseDto findById(StudentRequestDtoById id){
        //get the student by id
        Student student=studentRepository.findById(id.getStudentId()).get();

        StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(student);
        return studentResponseDto;
    }
    public String deleteStudentById(StudentRequestDtoById id){

        Student student=studentRepository.findById(id.getStudentId()).get();
        studentRepository.delete(student);
        String name=student.getStudentName();
        return name+" This student deleted!!";
    }
    public StudentResponseDto updateStudentById(StudentRequestDtoForUpdate email){

        Student student=studentRepository.findById(email.getStudentId()).get();
         //set the new email in student
        student.setStudentEmail(email.getNewEmail());
        //newStudent variable Hold the New Student all property..
        Student newStudent=studentRepository.save(student);
        //convert student to studentResponse Dto,,
        StudentResponseDto NewStudent=StudentConverter.studentToStudentResponseDto(newStudent);

        return NewStudent;
    }

    public List<StudentResponseDto> allStudentDetails(){
         List<Student> students=studentRepository.findAll();

         List<StudentResponseDto> studentList=new ArrayList<>();
         for(Student student:students)
         {
             StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(student);
             studentList.add(studentResponseDto);
         }

         return studentList;
    }

    public StudentResponseDto highestAgeStudent(){
        List<Student> students=studentRepository.findAll();
        int maxAge=0;
        Student mainStudent=new Student();
        for(Student student:students)
        {
            int age=student.getStudentAge();
            if(maxAge<age)
            {
                maxAge=age;
                mainStudent=student;
            }
        }
        //convert to studentResponseDto
        StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(mainStudent);
        return studentResponseDto;
    }
}
