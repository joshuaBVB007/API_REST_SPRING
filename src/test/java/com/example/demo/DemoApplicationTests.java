package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;


@SpringBootTest
class DemoApplicationTests {
	
	// mock creation
	List<String> mockedList = mock(List.class);
	Controller controller=mock(Controller.class);
	
	@Test
	void veri(){
		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();

		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
   
	@Test
	@Description("Metodo Get")
	void GetMethodTest() {
		Iterable<Employee> lista=controller.getAllEmployees();
		assertTrue(lista instanceof Iterable<Employee>);
	}
	
	@Test
	@Description("Metodo Post")
	void PostMethodTest() {
		/*Ejemplo de un falso Post: si tu le pasas Jonathan Calderon
		 * pasa el test si le pasas Jonath Calderon falla
		 * 
		 * explicaion: when es la ejecucion imitada del post,es cmo si la ejecucion se hubiese
		 * hecho a la base de datos pero en realidad no,aunque es correcta
		 */
		when(controller.addNewEmp("Jonathan", "Calderon")).thenReturn("Saved");
		
		assertEquals("Saved", controller.addNewEmp("Jonathan", "Calderon"));
	}
	
}
