package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;
import com.academy.cic.entity.Apartment;

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
	
	
	// -------- Metodi di test per il metodo service.rateApartment(int apartmentId) --------
	
	@Test
	void should_Return_Exception_When_NotFoundApartment_In_rateApartment() {
		
		// voglio simulare il caso in cui l'apartment con quell'id non sia presente nel DB
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);	
																			
		// creo l'executable del metodo che voglio testare
		Executable executable = () -> service.rateApartment(1);
		
		// verifico che sia lanciata un'eccezione EntityNotFoundException
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		
		// verifico il messaggio dell'eccezione lanciata
		assertEquals(String.format("Apartment with id %d not found", 1), e.getMessage());
	}
	
	
	@Test
	void should_Return_minus_1_When_FoundApartmentWithAreaEqualTo0()
			throws EntityNotFoundException, BadRequestException {

		Apartment apart = new Apartment(0.0, BigDecimal.valueOf(900000.0));
		
		int expectedReturn = -1;
		
		// voglio simulare il caso in cui l'apartment con quell'id sia presente nel DB
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apart);	
		
		int actualReturn = service.rateApartment(1);

		assertEquals(expectedReturn, actualReturn);
	}
	
	
	@ParameterizedTest			   			 // metodo di test eseguito 4 volte
	@CsvSource(value = {"72.0, 250000.0, 0", // la 1^ volta con questi parametri
    					"48.0, 350000.0, 1", // la 2^ volta con questi parametri
    					"30.0, 600000.0, 2", // la 3^ volta con questi parametri
    					"50.0, 300000.0, 1"} // la 4^ volta con questi parametri
			  )			// ho coperto anche il caso in cui ratio.compareTo(CHEAP_THRESHOLD) = 0
	void should_Return_Apartment_Rating_When_FoundApartment(double area, double price, int expectedRating)
			throws EntityNotFoundException, BadRequestException {

		Apartment apart = new Apartment(area, BigDecimal.valueOf(price));
		
		// voglio simulare il caso in cui l'apartment con quell'id sia presente nel DB
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apart);	
		
		int actualRating = service.rateApartment(1);

		assertEquals(expectedRating, actualRating);
	}
	
	
	
	// -------- Metodi di test per il metodo service.updateArea(int apartmentId, double area) --------
	
	@ParameterizedTest
	@CsvSource(value = {"1, 3000.0"})
	void should_ReturnException_When_WrongArea(int apartmentId, double area) {
		
		// creo un executable del metodo che voglio testare
		Executable executable = () -> service.updateArea(apartmentId, area);
		
		// verifico che quell'executable lanci effettivamente l'eccezione BadRequestException
		BadRequestException e = assertThrows(BadRequestException.class, executable);
		
		// verifico il messaggio dell'eccezione lanciata
		assertEquals("Cannot update area to a value greater than 1000", e.getMessage());
	}
	
	
	@Test
	void should_Return_Exception_When_NotFoundApartment_In_updateArea() {
		
		// voglio simulare il caso in cui l'apartment con quell'id non sia presente nel DB
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);	
																			
		// creo l'executable del metodo che voglio testare
		Executable executable = () -> service.updateArea(1, 39.0);
		
		// verifico che sia lanciata un'eccezione EntityNotFoundException
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		
		// verifico che il messaggio dell'eccezione
		assertEquals(String.format("Apartment with id %d not found", 1), e.getMessage());
	}
	
	
	@Test
	void should_Return_Apartment_Rating_When_ApartmentAreaUpdated() 
			throws EntityNotFoundException, BadRequestException {

		double newArea = 48.0;
		
		Apartment apart = new Apartment(90.0, BigDecimal.valueOf(350000.0));
		Apartment apartUpdate = new Apartment(newArea, BigDecimal.valueOf(350000.0));
		
		int expectedRating = 1;
		
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apart);
		Mockito.when(dao.updateApartment(Mockito.any())).thenReturn(apartUpdate);
		
		int actualRating = service.updateArea(1, newArea);

		assertEquals(expectedRating, actualRating);
	}
	
	
	@AfterAll 			
	static void printEndTesting() {
		
		System.out.println("-------- Test conclusi --------");
	}
}
