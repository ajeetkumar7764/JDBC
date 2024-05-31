package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Student;

public class StudentController 
{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		EntityManager em= emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setId(101);
		s.setName("Tanvi");
		s.setEmail("tan@gmail.com");
		s.setPasword("Tan69");
		s.setMob(8100256586L);
		s.setGender("Female");
		s.setRelationshipstatus("commited");
		
		et.begin();
		em.persist(s);
		et.commit();
		
		System.out.println("Data Saved..");
		
	}
	

}
