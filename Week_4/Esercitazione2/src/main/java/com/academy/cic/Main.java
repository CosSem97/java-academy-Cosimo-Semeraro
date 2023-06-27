package com.academy.cic;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.academy.cic.model.Course;
import com.academy.cic.model.Module;

public class Main {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		
		
		
		// creo dei moduli
		Module mod1 = new Module("Modulo1", "Teacher_1");
		Module mod2 = new Module("Modulo2", "Teacher_2");
		Module mod3 = new Module("Modulo3", "Teacher_3");
		Module mod4 = new Module("Modulo4", "Teacher_4");
		Module mod5 = new Module("Modulo5", "Teacher_4");
		Module mod6 = new Module("Modulo6", "Teacher_3");
		Module mod7 = new Module("Modulo7", "Teacher_5");
		Module mod8 = new Module("Modulo8", "Teacher_4");
		Module mod9 = new Module("Modulo9", "Teacher_3");
		
		
		
		// --- moduli del corso1 ---
		Set<Module> moduliC1 = new HashSet<Module>();
		moduliC1.add(mod1);
		moduliC1.add(mod2);
		moduliC1.add(mod3);
		
		Course c1 = new Course("NomeCorso1", Date.valueOf("2022-04-09"), Date.valueOf("2022-08-04"), moduliC1);
		
		
		// --- moduli del corso2 ---
		Set<Module> moduliC2 = new HashSet<Module>();
		moduliC2.add(mod4);
		moduliC2.add(mod5);
		
		Course c2 = new Course("NomeCorso2", Date.valueOf("2022-01-09"), Date.valueOf("2022-04-03"), moduliC2);
		
		
		// --- moduli del corso3 ---
		Set<Module> moduliC3 = new HashSet<Module>();
		moduliC3.add(mod6);
		
		Course c3 = new Course("NomeCorso3", Date.valueOf("2022-03-05"), Date.valueOf("2022-06-03"), moduliC3);
		
		
		
		// --- Inserisco i 3 corsi nel DB ---
		System.out.println("--- Inserimento nel DB del corso con id: " + dao.insertCourse(c1));
		System.out.println("--- Inserimento nel DB del corso con id: " + dao.insertCourse(c2));
		System.out.println("--- Inserimento nel DB del corso con id: " + dao.insertCourse(c3));
		

		
		// --- Seleziono dal DB un corso dato il suo nome ---
		Course c = dao.findCourseByName("NomeCorso1");
		
		System.out.println("\n--- Corso1 ---");
		System.out.println(c);
		
		
		
		// --- Aggiungo al corso1 i moduli 7, 8 e 9 ---
		dao.addModuleToCourse(mod7, c1.getCourseId());
		dao.addModuleToCourse(mod8, c1.getCourseId());
		dao.addModuleToCourse(mod9, c1.getCourseId());
		
		
		
		// --- Elenco dei moduli del corso1 ---
		Set<Module> moduliC = dao.findCourseModules(c1.getCourseId());
		
		System.out.println("\n--- Elenco dei moduli del corso1 ---");
		if(moduliC != null) {
			for(Module module : moduliC)
				System.out.println(module);
		}
		
		
		
		// --- Elenco dei corsi che hanno start_date compresa tra 2022-01-03 e 2022-03-31 ---
		List<Course> corsi = dao.findStartingCourseInRange(Date.valueOf("2022-01-03"), Date.valueOf("2022-03-31"));
		
		System.out.println("\n--- Elenco dei corsi che hanno start_date tra 2022-01-03 e 2022-03-31 ---");
		if(corsi != null) {
			for(Course corso : corsi)
				System.out.println(corso);
		}
		
		
		
		// --- Aggiorno la start_date del corso3 ---
		dao.updateStartDate(Date.valueOf("2022-03-15"), c3.getCourseId());
		
		c3 = dao.findCourseByName("NomeCorso3");
		System.out.println("\n--- StartDate del Corso3 aggiornata ---");
		System.out.println(c3);
		
		
		
		// --- Elimino dal DB il Corso1 ---
		dao.deleteCourse(c1.getCourseId());
		
	}

}
