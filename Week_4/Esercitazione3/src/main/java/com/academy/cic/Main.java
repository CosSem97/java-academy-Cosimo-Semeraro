package com.academy.cic;

import java.util.List;

import com.academy.cic.entity.*;
import com.academy.cic.entity.Module;

public class Main {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		
		
		
		// creo 4 studenti (gli id saranno generati dal DB)
		Student s1 = new Student("Carlo", "Verdi", 30);
		Student s2 = new Student("Luca", "Seri", 19);
		Student s3 = new Student("Chiara", "Verdi", 20);
		Student s4 = new Student("Carlo", "Verdi", 22);
		
		// inserisco i 4 studenti nel DB
		dao.insertStudent(s1);
		dao.insertStudent(s2);
		dao.insertStudent(s3);
		dao.insertStudent(s4);
		
		
		
		// creo 3 corsi
		Course c1 = new Course("Corso1");
		Course c2 = new Course("Corso2");
		Course c3 = new Course("Corso3");
		
		// inserisco i corsi nel DB
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		dao.insertCourse(c3);
		
		
		
		// creo dei moduli
		Module m1 = new Module("Modulo1", "Teacher1", c1);
		Module m2 = new Module("Modulo2", "Teacher1", c1);
		Module m3 = new Module("Modulo3", "Teacher2", c1);
		Module m4 = new Module("Modulo4", "Teacher3", c2);
		Module m5 = new Module("Modulo5", "Teacher3", c3);
		
		
		
		// creo delle registrazioni di studenti a dei corsi
		Registration r1 = new Registration(s1, c1, 30);
		Registration r2 = new Registration(s1, c2, 29);
		Registration r3 = new Registration(s1, c3, 28);
		Registration r4 = new Registration(s2, c1, 30);
		Registration r5 = new Registration(s2, c2, 20);
		Registration r6 = new Registration(s3, c1, 26);
		Registration r7 = new Registration(s3, c3, 30);
		Registration r8 = new Registration(s4, c1, 29);
		Registration r9 = new Registration(s4, c2, 30);
		
		// inserisco le registrazioni nel DB
		dao.registryStudentCourse(r1);
		dao.registryStudentCourse(r2);
		dao.registryStudentCourse(r3);
		dao.registryStudentCourse(r4);
		dao.registryStudentCourse(r5);
		dao.registryStudentCourse(r6);
		dao.registryStudentCourse(r7);
		dao.registryStudentCourse(r8);
		dao.registryStudentCourse(r9);
		
		
		
		System.out.println("\n---------------- Ricerca degli studenti dato nome e cognome ----------------");
		List<Student> students = dao.findByNameSurname("Carlo", "Verdi");
		
		if(students != null) {
			for (Student s : students)
				System.out.println(s);
		}
		
		
		
		System.out.println("\n---------------- Aggiornamento voto registrazione r1 ----------------");
		dao.updateCourseGradeById(r3.getId(), 29);
		
		
		
		System.out.println("\n---------------- Media Voti studente s1 ----------------");
		System.out.println("Media Voti: " + dao.findAvgGradeByStudentId(s1.getId()));
		
		
		
		System.out.println("\n---------------- Informazioni dello studente s3 ----------------");
		Student stud = dao.getStudentAllData(s3.getId());
		
		if(stud != null) {
			System.out.println(stud);
			
			// per ogni registrazione di quello studente
			System.out.println("Lo studente è registrato ai seguenti corsi:");
			for (Registration reg : stud.getRegistrationSet()) {
				System.out.println("   - " + reg.getCourse());
				
				if(reg.getGrade() != 0)
					System.out.println("   - Voto: " + reg.getGrade());
				System.out.println();
			}
		}
		
		
		
		
	}

}
