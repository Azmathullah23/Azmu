package com.niit.backend;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@Component("student")
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentDao studDAO;
	
	
	@Override
	public List<Student> getStudentList() {
		return studDAO.getStudentList();

	}

	@Override
	public Student getStudentid(int studid) {
		// TODO Auto-generated method stub
		return studDAO.getStudent(studid);
	}

	@Override
	public boolean addStudent(Student stud) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		 studDAO.addStudent(stud);
		return true;
	}

	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		 studDAO.updateStudent(stud);
		return true;
	}

	@Override
	public boolean deleteStudent(int stud) {
		// TODO Auto-generated method stub
		 studDAO.deleteStudent(stud);
		return true;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		studDAO.deleteAll();
	}

}
