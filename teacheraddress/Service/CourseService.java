package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.APiException;
import com.example.teacheraddress.Model.Course;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repository.CourseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Integer id,Course course){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new APiException("course id not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(course);
    }
    public void deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new APiException("course id not found");
        }
        courseRepository.delete(course);
    }


}
