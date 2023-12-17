package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.APiException;
import com.example.teacheraddress.Controller.TeacherController;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repository.CourseRepository;
import com.example.teacheraddress.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
     public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new APiException("Teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
     }
     public void deleteTeacher(Integer id){
         Teacher teacher=teacherRepository.findTeacherById(id);
         if(teacher==null){
             throw new APiException("Teacher not found");
         }
         teacherRepository.delete(teacher);
     }
     public Teacher getByTeacherId(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new APiException("teacher not found");
        }
        return teacher;
     }
     public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
         Course course=courseRepository.findCourseById(course_id);
         if(teacher==null||course==null){
             throw new APiException("teacher not found");
         }
         course.setTeacher(teacher);
         courseRepository.save(course);

     }
     public String getByCourse(Integer course_id){
         Course course=courseRepository.findCourseById(course_id);
         if(course==null) {
             throw new APiException("Course not found");
         }
         return course.getTeacher().getName();
     }
}
