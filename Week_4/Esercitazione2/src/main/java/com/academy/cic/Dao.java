package com.academy.cic;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

import com.academy.cic.model.Course;
import com.academy.cic.model.Module;
import com.academy.cic.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Dao {
	
	// Inserisce un nuovo corso nel DB e restituisce l'id
	public Integer insertCourse(Course course){
		System.out.println("\n---------------- Inserimento di un corso nel DB ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer courseId = 0;
	   
		try {
			tx = session.beginTransaction();
			courseId = (Integer) session.save(course);
			tx.commit();
			
			/*
			// --- oppure ---
			//
			// inserisco il corso nel DB con persist
			session.persist(course);
			
			// poi faccio la query per recuperare l'id del corso appena inserito nel DB
			TypedQuery<Integer> query = session.createQuery("SELECT c.courseId FROM Course c WHERE c.courseId = :idCorso", Integer.class);
			query.setParameter("idCorso", course.getCourseId());
			courseId = query.getSingleResult();
			
			tx.commit();
			*/
			
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return courseId;
	}
	
	
	
	
	// Seleziona dal DB il corso che ha quel nome e restituisce il corso
	public Course findCourseByName(String name) {
		System.out.println("\n---------------- Selezione dal DB di un corso per nome ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = null;
		try {
			// query per recuperare dal DB il corso che ha quel nome 
			TypedQuery<Course> query = session.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class);
			query.setParameter("name", name);
			
			query.setMaxResults(1); // metto a 1 il numero di risultati che voglio, in quanto potrei avere più corsi con lo stesso nome
			course = query.getSingleResult();
			
			// recupero dal DB anche i moduli di quel corso
			if (course != null) {
				Hibernate.initialize(course.getModules());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		
		return course;
	}
	
	
	
	// Aggiunge un nuovo modulo ad un corso
	public void addModuleToCourse(Module module, int courseId) {
		System.out.println("\n---------------- Aggiunta nel DB di un modulo ad un corso ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		Course course = null;
	   
		try {
			tx = session.beginTransaction();
			
			// recupero il corso dal DB
			course = session.get(Course.class, courseId);
			
			// aggiungo il modulo alla Set dei moduli di quel corso
			course.getModules().add(module);
			
			// aggiorno/inserisco i nuovi dati del corso nel DB
			session.saveOrUpdate(course);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	
	
	// Seleziona dal DB il corso e i relativi moduli, restituisce i moduli
	public Set<Module> findCourseModules(int courseId){
		System.out.println("\n---------------- Selezione dal DB dei moduli di un corso ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Course course = null;
	   
		try {
			// recupero il corso dal DB
			course = session.get(Course.class, courseId);
			
			// recupero dal DB anche i moduli di quel corso
			if (course != null)
				Hibernate.initialize(course.getModules());
			
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return course.getModules();
	}
	
	
	
	// Seleziona dal DB la lista dei corsi che iniziano tra le date from e to 
	public List<Course> findStartingCourseInRange(Date from, Date to){
		System.out.println("\n---------------- Selezione dal DB dei corsi che hanno startDate compresa tra due date ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Course> listaCorsi = null;
		
		try {
			// query per recuperare dal DB la lista dei corsi che hanno startDate compresa tra from e to 
			TypedQuery<Course> query = session.createQuery("SELECT c "
														 + "FROM Course c "
														 + "WHERE c.startDate BETWEEN :fromDate AND :toDate", Course.class);
			query.setParameter("fromDate", from);
			query.setParameter("toDate", to);
			
			listaCorsi = query.getResultList();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return listaCorsi;
	}
	
	
	
	// Aggiorna nal DB la start_date del corso con id courseId
	public void updateStartDate(Date startDate, int courseId) {
		System.out.println("\n---------------- Aggiorna nel DB la startDate di un corso ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Course course = null;
		
		try {
			tx = session.beginTransaction();
			
			// Recupero dal DB il corso che ha quell'id
			course = session.get(Course.class, courseId);
			// Aggiorno la startDate di quel corso
			course.setStartDate(startDate);
			// Aggiorno le modifiche nel DB
			session.update(course);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	
	
	// Elimina dal DB il corso che ha quell'id
	void deleteCourse(int courseId) {
		System.out.println("\n---------------- Elimina dal DB un corso ----------------");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Course course = null;
		
		try {
			tx = session.beginTransaction();
			
			// Recupero dal DB il corso che ha quell'id
			course = session.get(Course.class, courseId);
			// Elimino dal DB quel corso
			session.delete(course);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
}
