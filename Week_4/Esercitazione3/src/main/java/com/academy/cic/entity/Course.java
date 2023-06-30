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
	
	
	// Relazione 1 a N tra Course e Module
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Module> modules;
	
	
	
	// --- COSTRUTTORI ---
	public Course(String name, Set<Module> modules) {
		this.name = name;
		this.modules = modules;
	}
	
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
	
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
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
				+ ", nome: " + name
				+ ", modules: " + modules.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.getId();
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (super.getId() != other.getId())
			return false;
		return true;
	}

	
}
