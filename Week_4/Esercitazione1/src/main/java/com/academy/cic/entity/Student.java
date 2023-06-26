package com.academy.cic.entity;

public class Student {
	
	private int id;
	private String first_name;
	private String last_name;
	private int age;
	
	
	// --- COSTRUTTORI ---
	public Student(int id, String first_name, String last_name, int age) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	
	public Student() {
		
	}
	
	
	
	// --- Metodi get e set ---
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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

	@Override
	public String toString() {
		return "Studente ---> id: " + id
				+ ", nome: " + first_name
				+ ", cognome: " + last_name
				+ ", età: " + age;
	}
	
}