package com.niit.backend;

import java.util.List;

public interface StudentService {
	
	public List<Student> getStudentList();
	public Student getStudentid(int studid);
	public boolean addStudent(Student stud);
	public boolean updateStudent(Student stud);
	public boolean deleteStudent(int stud);
	public void deleteAll();
	

}