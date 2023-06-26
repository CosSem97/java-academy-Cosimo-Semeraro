package com.academy.cic.entity;

// classe che mi dice quanti corsi ha quello studente
public class StudentNumCourses {
	
	private Student student;
	private int numCorsi;
	
	
	
	// --- COSTRUTTORI ---
	public StudentNumCourses(Student student, int numCorsi) {
		this.student = student;
		this.numCorsi = numCorsi;
	}
	
	public StudentNumCourses(int student_id, int numCorsi) {
		this.student = new Student(student_id, null, null, -1);
		this.numCorsi = numCorsi;
	}
	
	public StudentNumCourses() {
		
	}

	
	
	// --- Metodi get e set ---
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public int getNumCorsi() {
		return numCorsi;
	}
	
	public void setNumCorsi(int numCorsi) {
		this.numCorsi = numCorsi;
	}
	
}
