package com.academy.cic;

import com.academy.cic.entity.Course;
import com.academy.cic.entity.Registration;
import com.academy.cic.entity.Student;
import com.academy.cic.entity.Module;
import com.academy.cic.exception.ApplicationException;
import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;

public class Service {
	
	private Dao dao;
	
	public Service(Dao dao) {
		this.dao = dao;
	}
	
	
	
	
	public int addModuleToCourse(Module module, int courseId)
		throws EntityNotFoundException, ApplicationException, BadRequestException {
		
			Course course = dao.findCourse(courseId); // cerca nel DB il corso con quell'id
			if (course == null)
				throw new EntityNotFoundException("Course not found");
			
			int numCourseModules = course.getModules().size();
			
			if(numCourseModules >= 10)
				throw new ApplicationException("No more than 10 modules can be added to a course");
			
			module.setCourse(course);
			course.getModules().add(module);
			
			// inserisco il modulo
			dao.insertModule(module);
			
			return course.getModules().size();
	}
}
