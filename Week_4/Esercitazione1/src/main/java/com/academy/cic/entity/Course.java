package com.academy.cic.entity;

public class Course {
	
	private int id;
	private String name;
	
	// --- COSTRUTTORI ---
	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Course() {
		
	}
	
	
	
	// --- Metodi get e set ---
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Corso ---> id: " + id
				+ ", nome: " + name;
	}
	
}
