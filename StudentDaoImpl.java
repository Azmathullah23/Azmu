package com.niit.backend;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Component("ben")
@Transactional
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Student").list();

	}

	
	public Student getStudent(int studid) {
		// TODO Auto-generated method stub
		return (Student)sessionFactory.getCurrentSession().createQuery("from Student where Id="+studid).uniqueResult();
	}


	public boolean addStudent(Student stud) {
		// TODO Auto-generated method stub
		try
		{	
			System.out.println("in dao");
			sessionFactory.getCurrentSession().save(stud);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(stud);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	
	public boolean deleteStudent(int stud) {
		// TODO Auto-generated method stub
		    System.out.println("in dao");
		
			Session current = sessionFactory.getCurrentSession();
			
			Query theQuery = current.createQuery("delete from Student where id=:customerId");
			
			theQuery.setParameter("customerId",stud);
			
			theQuery.executeUpdate();
			
			
			return true;
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		Session current = sessionFactory.getCurrentSession();
		
		Query theQuery = current.createSQLQuery("Truncate table student_details");
		
		theQuery.executeUpdate();
	}

}
