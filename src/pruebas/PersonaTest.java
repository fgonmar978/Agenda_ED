package pruebas;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import paquete.Persona;

class PersonaTest {

	@Test
	void testPersona() {
		Persona p1 = new Persona("Pepe", "Pepito", LocalDate.now());
		Persona p2 = new Persona("Chachi", "Piruli", null);
		Persona p3 = new Persona();
		Persona p4 = new Persona("Pepa", "pppp", LocalDate.of(2017,05,11));
		
	}

	@Test
	void testGetNombre() {
		try{

		}catch(Exception e){
			
		}
	}

	@Test
	void testSetNombre() {
		Persona p = new Persona(null, null, null);

		try 
		{
			p.setNombre("Pepe");
		} catch (Exception e) {
			fail("Falla cambio de nombre" + e.getMessage());
		}

		try 
		{
			p.setNombre("");
		} catch (Exception e) {
			fail("Falla cambio de nombre vacio" + e.getMessage());
		}

		try 
		{
			p.setNombre("adohjklsdfljadsh foka hdkjfh kasdhfkhasdklfhakjdshkjfah kdhkjfah dskhfaklhdskjf h pojqpiehdfkjla·····#######||||||111111sffasdfadfdsa");
		} catch (Exception e) {
			fail("Falla cambio de nombre muuuuuuuuy largo" + e.getMessage());
		}		
	}
	

	@Test
	void testGetApellidos() {

	}

	@Test
	void testSetApellidos() {
		Persona p = new Persona(null, null, null);
		try{
			p.setApellidos("apellido apellido apellido apellido");
		}catch(Exception e){
			fail("Falla el cambio de apellidos con varios apellidos" + e.getMessage());
		}

		try{
			p.setApellidos("");
		}catch(Exception e){
			fail("Falla el cambio de apellidos vacio" + e.getMessage());
		}
		
	}
		

	@Test
	void testGetFechaNac() {
		
	}

	@Test
	void testSetFechaNac() {
		Persona p = new Persona(null, null, null);
		try{
			p.setFechaNac(LocalDate.now());
		}catch(Exception e){
			fail("Falla pasarle metedo LocalDate" + e.getMessage());
		}

		try{
			p.setFechaNac(null);
		}catch(Exception e){
			fail("Falla pasarle a la fecha null" + e.getMessage());
		}
		try{
			p.setFechaNac(LocalDate.of(2017, 7, 4));
		}catch(Exception e){
			fail("Falla pasarle el metodo LocalDate.of" + e.getMessage());
		}


	}

}
