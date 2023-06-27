package com.academy.cic.model;

import java.sql.Date;
import java.util.Set;

public class Course {
	
	private int courseId;
	private String name;
	private Date startDate;
	private Date endDate;
	private Set<Module> modules;
	
	// --- COSTRUTTORI ---
	public Course(String name, Date startDate, Date endDate, Set<Module> modules) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = modules;
	}
	
	public Course() {}

	
	
	// --- metodi get e set ---
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	
	
	@Override
	public String toString() {
		return "Course ---> courseId: " + courseId
				+ ", name: " + name
				+ ", startDate: " + startDate
				+ ", endDate: " + endDate
				+ ", modules: " + modules.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (courseId != other.courseId)
			return false;
		return true;
	}

	
	
		
}
