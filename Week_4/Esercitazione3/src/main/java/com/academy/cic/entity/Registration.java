package com.academy.cic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRATION")
@NamedQuery(name = "Registration.findAvgGradeByStudentId", query = "SELECT AVG(grade) "
				 												 + "FROM Registration r "
				 												 + "WHERE r.student.id = :studentId ")
public class Registration extends PrimaryKey {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER) // uso il FETCH di tipo EAGER in questo caso in quanto voglio anche i dati del corso quando prelevo dal DB una registrazione
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column
	private int grade;
	
	
	
	// --- COSTRUTTORI ---
	public Registration(Student student, Course course, int grade) {
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
	
	public Registration() {
		
	}

	
	
	// --- Metodi get e set ---
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
		return "Registrazione ---> id: " + super.getId()
				+ ", studente " + student.getId() + " registrato al corso " + course.getId()
				+ ", con voto: " + grade;
	}
	
}