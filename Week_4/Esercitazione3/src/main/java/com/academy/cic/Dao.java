package com.academy.cic;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.academy.cic.entity.*;
import com.academy.cic.util.JpaUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

public class Dao {
	
private static final Logger logger = Logger.getLogger(Dao.class.getName());

	public void insertStudent(Student student){
		logger.info("-------- Inserimento di un nuovo studente nel DB --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			eM.getTransaction().begin();  // inizio la transazione
			eM.persist(student); 		  // inserisco lo studente nel DB 
			eM.getTransaction().commit(); // faccio la commit della transazione
		} catch (Exception e) {
			eM.getTransaction().rollback(); // se ci sono stati errori nell'inserimento della person anel DB, faccio il rollback (il DB tornerà nel precedente stato consistente)
			e.printStackTrace(); 
		} finally {
			eM.close(); 
		}
	}
	
	
	
	public void insertCourse(Course course){
		logger.info("-------- Inserimento di un nuovo corso nel DB --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			eM.getTransaction().begin();  // inizio la transazione
			eM.persist(course); 		  // inserisco il corso nel DB 
			eM.getTransaction().commit(); // faccio la commit della transazione
		} catch (Exception e) {
			eM.getTransaction().rollback(); 
			e.printStackTrace(); 
		} finally {
			eM.close(); 
		}
	}
	
	
	
	public void registryStudentCourse(Registration registration){
		logger.info("-------- Inserimento di una nuova registrazione nel DB --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			eM.getTransaction().begin();  // inizio la transazione
			eM.persist(registration); 	  // inserisco la registrazione nel DB 
			eM.getTransaction().commit(); // faccio la commit della transazione
		} catch (Exception e) {
			eM.getTransaction().rollback(); 
			e.printStackTrace(); 
		} finally {
			eM.close(); 
		}
	}
	
	

	public List<Student> findByNameSurname(String name, String surname) {
		logger.info("-------- Ricerca nel DB degli studenti, dato nome e cognome --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Student> students = null;
		
		try {
			TypedQuery<Student> query = eM.createNamedQuery("Student.findByNameSurname", Student.class);
			query.setParameter("name", name);
			query.setParameter("surname", surname);
			students = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close(); 
		}
		return students;
	}
	
	
	
	public void updateCourseGradeById(int registrationId, int grade) {
		logger.info("-------- Aggiornamento nel DB del grade di una registrazione --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Registration reg = eM.find(Registration.class, registrationId); // recupero dal DB la registrazione
			reg.setGrade(grade);
			
			// Aggiorno reg nel DB
			eM.getTransaction().begin(); 
			eM.merge(reg);			
			eM.getTransaction().commit();
			
		} catch (HibernateException e) {
			eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			eM.close(); 
		}
	}
	
	
	
	public Double findAvgGradeByStudentId(int studentId) {
		logger.info("-------- Ricerca dal DB della media dei voti di uno studente --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
		Double avgGrade = -1.0;
		
		try {
			TypedQuery<Double> query = eM.createNamedQuery("Registration.findAvgGradeByStudentId", Double.class);
			query.setParameter("studentId", studentId);
			query.setMaxResults(1);
			avgGrade = query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eM.close(); 
		}
		return avgGrade;
	}
	
	
	
	public Student getStudentAllData(int studentId) {
		logger.info("-------- Ricerca dal DB di tutte le informazioni di uno studente e di tutti i voti per ogni suo corso --------");
		
		EntityManager eM = JpaUtil.getEntityManagerFactory().createEntityManager();
		Student student = null;
		
		try {
			student = eM.find(Student.class, studentId); // recupero dal DB lo studente che ha quell'id
			
			// poichè ho impostato il FETCH di tipo LAZY per l'attributo registrationSet nella classe Student, in automatico non è stato prelevato anche l'elenco delle registrazioni di quello studente 
			// Quindi recupero anche l'elenco delle registrazioni di quello studente
			if(student != null)
				Hibernate.initialize(student.getRegistrationSet());
				// Poichè ho impostato il FETCH di tipo EAGER per l'attributo course della classe REgistration, allora in automatico verranno prelevati anche i dati del corso per ogni registrazione e messi nell'attributo course
			
		} catch (HibernateException e) {
			eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			eM.close(); 
		}
		
		return student;
	}
}













