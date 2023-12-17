package com.example.teacheraddress.Controller;

import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
@RestController
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/getCourse")
    public ResponseEntity getCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourse());
    }
    @PostMapping("/addCourse")
    public ResponseEntity addTeacher(@RequestBody@Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course add");
    }
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Course course){
          courseService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body("Course updated");
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted");
    }

}

