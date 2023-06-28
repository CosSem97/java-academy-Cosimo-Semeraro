package com.academy.cic.entity;

import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "Student.findByNameSurname", query = "SELECT s FROM Student s WHERE s.first_name = :name AND s.last_name = :surname")
public class Student extends PrimaryKey{
	
	private static final Logger logger = Logger.getLogger(Student.class.getName());
	
	
	
	@Column(nullable = false, length = 32)
	private String first_name;
	
	@Column(nullable = false, length = 32)
	private String last_name;
	
	@Column
	private int age;
	
	
	// Relazione N a N tra Student e Course
	// La gestisco come relazione 1 a N tra Student e Registration
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Registration> registrationSet; 	// elenco delle registrazioni di quello studente
	
	
	// --- COSTRUTTORI ---
	public Student(String first_name, String last_name, int age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	
	public Student() {
		
	}
	
	
	
	// --- Metodi get e set ---
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Set<Registration> getRegistrationSet() {
		return registrationSet;
	}

	public void setRegistrationSet(Set<Registration> registrationSet) {
		this.registrationSet = registrationSet;
	}

	@PrePersist
	public void logNewStudentAttempt() {
	    logger.info("Inserimento nel DBdi un nuovo studente: " + first_name + last_name);
	}
	    
	@PostPersist
	public void logNewStudentAdded() {
	    logger.info("Inserito nel DB il nuovo studente " + first_name + last_name + " con id: " + super.getId());
	}

	@Override
	public String toString() {
		return "Studente ---> id: " + super.getId()
				+ ", nome: " + first_name
				+ ", cognome: " + last_name
				+ ", età: " + age;
	}
	
}
