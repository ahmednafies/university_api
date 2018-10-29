package com.yourname.Dao;
import com.yourname.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
              put(1, new Student(1,"Said","Computer Science"));
              put(2, new Student(2,"Alex U","Finance"));
              put(3, new Student(3,"Anna","Maths"));

            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void deleteStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student _student){
        Student student = this.students.get(_student.getId());
        student.setCourse(_student.getCourse());
        student.setName(_student.getName());
        this.students.put(_student.getId(), _student);
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
