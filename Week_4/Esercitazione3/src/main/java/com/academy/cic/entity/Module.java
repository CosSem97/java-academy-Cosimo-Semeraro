package com.academy.cic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE")
public class Module extends PrimaryKey{
	
	@Column(nullable = false, length = 64)
	private String name;
	
	@Column(nullable = true, length = 64)
	private String teacher;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "course_id")
	private Course course;
	
	
	
	// --- COSTRUTTORI ---
	public Module(String name, String teacher, Course course) {
		this.name = name;
		this.teacher = teacher;
		this.course = course;
	}
	
	public Module(String name, String teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public Module() {}

	
	
	// --- metodi get e set ---
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	
	@Override
	public String toString() {
		return "Module ---> moduleId: " + super.getId()
				+ ", name: " + name
				+ ", teacher: " + teacher
				+ ", course: " + course.getName();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.getId();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		Module other = (Module) obj;
		if (super.getId() != other.getId())
			return false;
		return true;
	}
	
	
	
	
	
}



