package com.SpringJpaFirst.Library_Management_System.Service.Impl;
import com.SpringJpaFirst.Library_Management_System.Converter.StudentConverter;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
import com.SpringJpaFirst.Library_Management_System.Exception.StudentNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.StudentRepository;
import com.SpringJpaFirst.Library_Management_System.Service.StudentService;
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

    public StudentResponseDto findByEmail(String mail){

        //find the student by email...the filebyemail method have in student repository
        Student student=studentRepository.findByStudentEmail(mail);

        StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(student);
        return studentResponseDto;

    }
    public StudentResponseDto updateImage(StudentRequestDto dto,int studentId) throws StudentNotFoundException {
        Student student;
        try{
            student=studentRepository.findById(studentId).get();
        }catch (Exception e){
            throw new StudentNotFoundException("Student Id invalid");
        }
        student.setImageName(dto.getImageFile());
        studentRepository.save(student);
        StudentResponseDto studentResponseDto=StudentConverter.studentToStudentResponseDto(student);
        return studentResponseDto;
    }
    public StudentResponseDto findById(int id) throws StudentNotFoundException {
        //get the student by id
        Student student;
        try {
            student = studentRepository.findById(id).get();
        }
        catch(Exception e){
            throw new StudentNotFoundException("StudentId is not present");
        }
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
        List<Student> studentsList=studentRepository.findAll();
        int maxAge=0;
        Student mainStudent=new Student();
        for(Student student:studentsList)
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
    public List<StudentResponseDto> findStudentBySameAge(int age){

        List<Student> studentList=studentRepository.findByStudentByAge(age);
        List<StudentResponseDto> finalList=new ArrayList<>();
        for(Student student:studentList){
            StudentResponseDto responseDto=StudentConverter.studentToStudentResponseDto(student);
            finalList.add(responseDto);
        }
        return finalList;
    }
}
