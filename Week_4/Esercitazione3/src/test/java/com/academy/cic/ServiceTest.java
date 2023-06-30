package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import com.academy.cic.exception.ApplicationException;
import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;
import com.academy.cic.entity.*;
import com.academy.cic.entity.Module;

public class ServiceTest {
	
	private static Dao dao;
	private static Service service;
	
	
	
	// inizializzo dao e service
	@BeforeAll 			
	static void init() {
		
		System.out.println("-------- Inizializzazione delle variabili utili per il testing --------");
		
		// creo il mock dao
		dao = Mockito.mock(Dao.class);
		service = new Service(dao);
	}
	
	
	@BeforeEach
	void printTestingMessage() {
		
		System.out.println("---- Esecuzione di un test ----");
	}
	
	
	
	// -------- Metodi di test per il metodo service.addModuleToCourse() --------
	
	@Test
	void should_Return_Exception_When_NotFoundCourse() {
		
		// voglio simulare il caso in cui il corso con quell'id non sia presente nel DB
		Mockito.when(dao.findCourse(Mockito.anyInt())).thenReturn(null);	
																			
		// creo l'executable del metodo che voglio testare
		Executable executable = () -> service.addModuleToCourse(new Module(), 1);
		
		// verifico che sia lanciata un'eccezione EntityNotFoundException
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		
		// verifico che il messaggio dell'eccezione lanciata sia effettivamente "Course not found"
		assertEquals("Course not found", e.getMessage());
	}
	
	
	@Test
	void should_ReturnException_When_Already10Modules() {
		
		// voglio simulare il caso in cui il corso con quell'id sia presente nel DB e che quel corso
		// abbia già 10 moduli
		Set<Module> courseModules = new HashSet<Module>();
		for(int i = 0; i < 10; i++)
			courseModules.add(new Module("Module" + i, "Teacher"));
		
		System.out.println(courseModules.size());
		
		Course course = new Course("Corso1", courseModules);
		
		Mockito.when(dao.findCourse(Mockito.anyInt())).thenReturn(course);
		
		// creo un executable del metodo che voglio testare, nel mio caso addModuleToCourse()
		Executable executable = () -> service.addModuleToCourse(new Module(), 1);
		
		// verifico che quell'executable lanci effettivamente l'eccezione ApplicationException
		ApplicationException e = assertThrows(ApplicationException.class, executable);
		
		// verifico il messaggio dell'eccezione lanciata
		assertEquals("No more than 10 modules can be added to a course", e.getMessage());
	}
	
	
	
	@Test
	void should_Return_NewNumOfModules_When_ModuleIsAddedToCourse() 
			throws EntityNotFoundException, ApplicationException, BadRequestException {

		// voglio simulare il caso in cui il corso con quell'id sia presente nel DB e che abbia meno di 10 moduli
		Course course = new Course("Corso1", new HashSet<Module>()); // creo un corso fittizio che non ha moduli
		
		Mockito.when(dao.findCourse(Mockito.anyInt())).thenReturn(course);

		int expectedReturn = 1;
		int actualReturn = service.addModuleToCourse(new Module(), 1);
		
		assertEquals(expectedReturn, actualReturn);
	}
		
	}