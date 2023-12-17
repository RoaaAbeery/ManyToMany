package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.APiException;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Student;
import com.example.teacheraddress.Repository.CourseRepository;
import com.example.teacheraddress.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void updateStudent(Integer id,Student student){
        Student oldStudent=studentRepository.findStudentById(id);
        if(oldStudent==null){
            throw new APiException("Student not found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }
    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new APiException("Student not found");
        }
        studentRepository.delete(student);
    }

public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student student=studentRepository.findStudentById(student_id);
        Course course=courseRepository.findCourseById(course_id);
        if(student==null||course==null){
            throw new APiException("you cant complete assign");
        }
        course.getStudents().add(student);
        student.getCourse().add(course);
        courseRepository.save(course);
        studentRepository.save(student);
}

    public void changeMajor(Integer id,String major,Student student){
        Student students=studentRepository.findStudentByIdAndMajor(id, major);
        if(students==null){
            throw new APiException("Student not found");
        }
        students.setMajor(student.getMajor());
        for (Course c :courseRepository.findAll()) {
            c.getStudents().remove(students);
        }
        students.setCourse(null);
        studentRepository.save(student);
    }
    public Set<Student> getStudentsByCourse(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        if(course==null){
            throw new APiException(" course not found");
        }
        return course.getStudents();
    }
}
