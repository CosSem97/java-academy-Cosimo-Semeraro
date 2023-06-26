package com.academy.cic;

import java.sql.SQLException;
import java.util.List;

import com.academy.cic.entity.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Dao dao = new Dao();
		
		// --- creo 3 nuovi studenti e li aggiungo al DB ---
		Student s1 = new Student(1, "Carlo", "Verdi", 30);
		Student s2 = new Student(2, "Luca", "Seri", 20);
		Student s3 = new Student(3, "Chiara", "Verdi", 30);
		
		dao.insertStudent(s1);
		dao.insertStudent(s2);
		dao.insertStudent(s3);
		
		
		
		// --- creo due nuovi corsi e li aggiungo al DB ---
		Course c1 = new Course(1, "OOP");
		Course c2 = new Course(2, "Controlli Automatici");
		
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		
		
		
		// --- registro gli studenti ai corsi ---
		Registration regS1C1 = new Registration(1, s1, c1, 30); // registro lo studente s1 al corso c1
		dao.registryStudentCourse(regS1C1);
		
		Registration regS1C2 = new Registration(2, s1, c2, 29); // registro lo studente s1 al corso c2
		dao.registryStudentCourse(regS1C2);
		
		Registration regS2C1 = new Registration(3, s2, c1, 28); // registro lo studente s2 al corso c1
		dao.registryStudentCourse(regS2C1);
		
		Registration regS3C1 = new Registration(4, s3, c1, 30); // registro lo studente s3 al corso c1
		dao.registryStudentCourse(regS3C1);
		
		
		
		// --- Recupero dal DB uno studente per nome e cognome ---
		Student s = dao.selectByNameSurname("Carlo", "Verdi");
		System.out.println(s + "\n");
		
		
		
		// --- Aggiorno il grade della registrazione 4 con il grade 29
		dao.updateCourseGradeById(4, 29);
		
		
		
		// --- Ottengo la lista dei corsi a cui lo studente 1 è registrato
		List<Course> corsiS1 = dao.findStudentCourses(1);
		
		System.out.println("--- Corsi dello studente S1:");
		for(Course corso : corsiS1) {
			System.out.println(corso);
		}
		
		
		
		// --- Ottengo la lista degli studenti con il relativo numero di corsi
		List<StudentNumCourses> studentiIdNumCorsi = dao.findStudentIdNumcourses();
		
		System.out.println("\n--- Numero di corsi per ogni studentId:");
		for(StudentNumCourses stNumC : studentiIdNumCorsi) {
			System.out.println("Lo studente " + stNumC.getStudent().getId() + " è registrato a " + stNumC.getNumCorsi() + " corsi");
		}
		
		
		
		// --- Ottengo la lista degli studenti, con anche i loro dati, con il relativo numero di corsi
		List<StudentNumCourses> studentiDataNumCorsi = dao.findStudentDataNumcourses();
		
		System.out.println("\n--- Numero di corsi per ogni studentData:");
		for(StudentNumCourses stNumC : studentiDataNumCorsi) {
			System.out.println("Lo studente " + stNumC.getStudent() + " è registrato a " + stNumC.getNumCorsi() + " corsi");
		}


		
		
		

	}

}
