package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Student;
import com.example.teacheraddress.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/getStudents")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @PostMapping("/addStudent")
    public ResponseEntity addStudents(@RequestBody@Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student add");
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody@Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body("Student updated");
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
    }

    @PutMapping("/changeMajor/{id}/{major}")
    public ResponseEntity ChangeStudentMajor(@PathVariable Integer id,@PathVariable String major,@RequestBody@Valid Student student){
        studentService.changeMajor(id, major,student);
        return ResponseEntity.status(HttpStatus.OK).body("Student major changed");
    }
    @PutMapping("/assign/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
      studentService.assignStudentToCourse(student_id, course_id);
        return ResponseEntity.status(HttpStatus.OK).body("assign done");
    }
    @GetMapping("/getByCourse/{course_id}")
    public ResponseEntity getByCourse(@PathVariable Integer course_id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByCourse(course_id));
    }
}

