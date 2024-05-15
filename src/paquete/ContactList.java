package paquete;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import IO_Managers.InputManager;

public class ContactList
{

	/**
	 * Constante
	 */
	final int TAM = 10;
	
	/**
	 * Atributo : array de contacto
	 */
	private Contact contactos[];
	
	/**
	 * Constructor: crea el array contactos
	 */
	public ContactList() {
		contactos = new Contact[TAM];
	}
	

	/**
	 * Descripción: pide los datos al usuario y crea un nuevo contacto
	 * @return Contact
	 */
	public Contact createContact() {
		
		String name;
		String surname;
		LocalDate birthdate;
		int anio;
		int mes;
		int dia;
		String prefix;
		short pre = 0;
		String phone;
		String email;
		
		name = InputManager.askForString("\nIntroduzca nombre del contacto: ", false);
		surname = InputManager.askForString("\nIntroduzca apellido del contacto: ", false);
		anio = InputManager.askForInt("\nIntroduzca su anio de nacimiento: ");

		do {
			mes = InputManager.askForInt("\nIntroduzca el mes:");
		}while(mes < 1 || mes > 12);
		
		do {
			dia = InputManager.askForInt("\nIntroduzca el dia:");
		}while(dia < 1 && dia > 31);
		/* Creamos la instancia de birthdate */
		birthdate = LocalDate.of(anio, mes, dia);
		
		prefix = InputManager.askForString("\nIntroduzca el prefijo telefonico (34 por defecto): ", true);		
		phone = InputManager.askForString("\nIntroduzca su numero de telefono: ", false);
		email = InputManager.askForString("\nIntroduzca su correo electronico: ", false);		
				 
		if(prefix.length() == 0) {
			return new Contact(name, surname, birthdate, phone, email);
		}else {
			
			/*
			 * Comprobamos que el usuario haya introducido números en vez de letras.
			 */
			try {
				pre = Short.parseShort(prefix);
			}catch(NumberFormatException e) {
				System.err.println(e.toString());
				System.out.println("\nSe ha creado un contacto con prefijo por defecto(+34)");
				return new Contact(name, surname, birthdate, phone, email);
			}
			
			return new Contact(name, surname, birthdate, pre, phone, email);
		}
		
	}
	
	
	/**
	 * Descripción: añade un contacto nuevo en la lista
	 * @param c
	 * @return: si se ha realizado la inserción con éxito: boolean
	 */
	public boolean addContact(Contact c) {
		
		int i = 0;
		for(i = 0; i < contactos.length; i++) {
			if(contactos[i] == null) {
				contactos[i] = c;
				return true;
			}
		}
		
		return false;
	}
	
	 
	 /**
	  * Descripción: realiza la búsqueda de un contacto según el parámetro pasado.
	  * @param telefono
	  * @return: el objeto si se ha encontrado y null en caso contrario.
	  */
	 public Contact getContact(String telefono, short prefijo) {
		 
		 for(Contact c: contactos) {
			 if(c.getPrefix() == 34)
				 if(c.comparePhone(telefono))
					 return c;
			 else
				 if(c.comparePhone(prefijo, telefono))
					 return c;
		 }
		 
		 return null;
	 }
	 
	 
	 /**
	  * Descripción: muestra los datos del contacto buscado si existe
	  * @param telefono
	  * @return: muestran los datos del contacto en caso de existir y un mensaje de advertencia si no existe
	  */
	 public void showContact(String telefono, short prefijo) {
		 
		 Contact buscado = getContact(telefono, prefijo);
		 
		 if(buscado == null)
			 System.out.println("\nNo existe el contacto buscado.");
		 else
			 System.out.println(buscado);
			 
	 }
	 
	 
	 /**
	  * Descripción: elimina el contacto seleccionado
	  * @param telefono
	  * @return: boolean que indica si se ha realizado correctamente el proceso
	  */
	 public boolean deleteContact(String telefono, short prefijo) {
		 Contact buscado = getContact(telefono, prefijo);
		 
		 if(buscado != null) {
			 buscado = null;
			 return true;
		 }
		
		 return false;
	 }
	 
	 /**
	  * Descripción: muestra el número de elementos almacenados
	  * @return: cantidad de contactos que hay
	  */
	 public int getNumberContacts() {
		 
		 int total = 0;
		 
		 for(Contact c: contactos) {
			 
			 if(c != null)
				 total += 1;
		 }
		 
		 return total;
	 }
	 
	 
	 /**
	  * Descripción: muestra de forma enumerada todos los contactos almacenados junto a su información
	  * @return void
	  */
	 public void showContacts() {
		 
		 int i = 1;
		 
		 for(Contact c: contactos) {
			 
			 if(c != null) {
				 System.out.println(i + ". " + c.toString());
				 i++;
			 }
		 } 
	 }
	 
}