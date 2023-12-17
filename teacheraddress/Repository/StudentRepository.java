package com.example.teacheraddress.Repository;

import com.example.teacheraddress.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
    Student findStudentByIdAndMajor(Integer id,String major);

}
