package com.academy.cic.entity;

import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course extends PrimaryKey {
	
	private static final Logger logger = Logger.getLogger(Student.class.getName());
	
	
	
	@Column(nullable = false, length = 64)
	private String name;
	
	
	// Relazione N a N tra Course e Student
	// La gestisco come relazione 1 a N tra Course e Registration
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Registration> registrationSet; 	// elenco delle registrazioni di quel corso
	
	// --- COSTRUTTORI ---
	public Course(String name) {
		this.name = name;
	}
	
	public Course() {
		
	}
	
	
	
	// --- Metodi get e set ---
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Registration> getRegistrationSet() {
		return registrationSet;
	}

	public void setRegistrationSet(Set<Registration> registrationSet) {
		this.registrationSet = registrationSet;
	}

	@PrePersist
	public void logNewCourseAttempt() {
	    logger.info("Inserimento nel DB di un nuovo corso: " + name);
	}
	    
	@PostPersist
	public void logNewCourseAdded() {
	    logger.info("Inserito nel DB il nuovo corso " + name + " con id: " + super.getId());
	}

	@Override
	public String toString() {
		return "Corso ---> id: " + super.getId()
				+ ", nome: " + name;
	}
	
}
