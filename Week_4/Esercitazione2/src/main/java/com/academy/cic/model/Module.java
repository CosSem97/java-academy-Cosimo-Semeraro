package com.academy.cic.model;

public class Module {
	
	private int moduleId;
	private String name;
	private String teacher;
	
	// --- COSTRUTTORI ---
	public Module(String name, String teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public Module() {}

	
	
	// --- metodi get e set ---
	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

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

	
	
	@Override
	public String toString() {
		return "Module ---> moduleId: " + moduleId
				+ ", name: " + name
				+ ", teacher: " + teacher;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + moduleId;
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
		if (moduleId != other.moduleId)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
