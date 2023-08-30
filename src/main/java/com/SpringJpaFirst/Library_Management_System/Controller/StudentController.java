package com.SpringJpaFirst.Library_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;

import com.SpringJpaFirst.Library_Management_System.Converter.StudentConverter;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import com.SpringJpaFirst.Library_Management_System.Exception.StudentNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.FileService;
import com.SpringJpaFirst.Library_Management_System.Service.Impl.FileServiceImpl;
import com.SpringJpaFirst.Library_Management_System.Service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    FileServiceImpl fileService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/add")
    public  StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentServiceImpl.addStudent(studentRequestDto);
    }

    @GetMapping("/find_by_email/{mail}")
    public StudentResponseDto getStudentByEmail(@PathVariable("mail") String mail){
        return studentServiceImpl.findByEmail(mail);
    }

    @GetMapping("/find_by_id/{id}")
    public ResponseEntity<StudentResponseDto> getStudentByNo(@PathVariable("id") int id) throws StudentNotFoundException{
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        try{
            studentResponseDto=studentServiceImpl.findById(id);
        }
        catch(StudentNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentResponseDto,HttpStatus.ACCEPTED);
    }
    @PostMapping("/image/addPhoto/{studentId}")
    public ResponseEntity<StudentResponseDto> addStudentImage(@RequestParam("image") MultipartFile image , @PathVariable("studentId") Integer studentId) throws IOException, StudentNotFoundException {
        StudentResponseDto studentDto;
        try{
            studentDto=studentServiceImpl.findById(studentId);
        }catch (StudentNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        Student student= StudentConverter.StudentResponseDtoToStudent(studentDto);
        String name=fileService.uploadImage(path,image);
        StudentRequestDto dto=StudentConverter.StudentToStudentRequestDto(student);
        dto.setImageFile(name);
        StudentResponseDto newStudentImage=studentServiceImpl.updateImage(dto,studentId);
        return new ResponseEntity(newStudentImage,HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/getImage/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)throws IOException{

        InputStream resource=fileService.getResources(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }
    @PutMapping("update_by_id")
    public StudentResponseDto updateStudentById(@RequestBody StudentRequestDtoForUpdate email){
        return studentServiceImpl.updateStudentById(email);
    }

    @GetMapping("/allStudent")
    public List<StudentResponseDto> allStudentDetails(){
        return studentServiceImpl.allStudentDetails();
    }

    @GetMapping("/highestAgeStudent")
    public StudentResponseDto highestAgeStudent(){
        return studentServiceImpl.highestAgeStudent();
    }
    @GetMapping("/getStudentByAge/{age}")
    public List<StudentResponseDto> findStudentBySameAge(@PathVariable("age") int age){
        return studentServiceImpl.findStudentBySameAge(age);
    }
    @DeleteMapping("/delete_by_id")
    private  String  deleteStudentById(@RequestBody StudentRequestDtoById id)
    {
       return studentServiceImpl.deleteStudentById(id);
    }
}
