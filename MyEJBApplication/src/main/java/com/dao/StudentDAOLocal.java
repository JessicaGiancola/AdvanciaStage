package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.model.Student;

/**
 *
 * @author Joseph
 */
@Local
public interface StudentDAOLocal {

    void addStudent(Student student);

    void editStudent(Student student);

   void deleteStudent(int studentId);

    Student getStudent(int studentId);

    List<Student> getAllStudents();
    
}
