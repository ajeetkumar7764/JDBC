package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Student;



public class Controller {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction et = em.getTransaction();
	
	
	
	public void saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
	}
	
	public Student find(int id)
	{
		Student s = em.find(Student.class, id);
		
		return s;
	}
	
	public boolean updateStudentById(int id, String email)
	{
		Student s = em.find(Student.class, id);
		
		if (s!=null) 
		{
			et.begin();
			em.merge(s);
			et.commit();
			
			return true;
		}
		return false;
	}
	
	public boolean deleteStudentById(int id)
	{
		Student s = em.find(Student.class, id);
		
		if (s!=null) 
		{
			et.begin();
			em.remove(s);
			et.commit();
			
			return true;
		}
		return false;
	}
}
