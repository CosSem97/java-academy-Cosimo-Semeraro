package com.academy.cic.entity;

public class Registration {
	
	private int id;
	private Student student;
	private Course course;
	private int grade;
	
	
	
	// --- COSTRUTTORI ---
	public Registration(int id, Student student, Course course, int grade) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
	
	public Registration() {
		
	}

	
	
	// --- Metodi get e set ---
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Registrazione ---> id: " + id
				+ ", studente " + student.getId() + " registrato al corso " + course.getId()
				+ ", grade: " + grade;
	}
	
}