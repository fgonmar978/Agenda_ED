package paquete;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ContactList
{

	Scanner sc = new Scanner(System.in);
	
	/**
	 * Atributo : array de contacto
	 */
	private Contact contactos[];
	
	/**
	 * Constructor: crea el array contactos
	 */
	public ContactList() {
		contactos = new Contact[10];
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
		String phone;
		String email;
		
		System.out.println("\nIntroduzca nombre del contacto: ");
		name = sc.nextLine();
		
		System.out.println("\nIntroduzca apellido del contacto: ");
		surname = sc.nextLine();
		
		System.out.println("\nIntroduzca su anio de nacimiento: ");
		anio = sc.nextInt();
		do {
			System.out.println("\nIntroduzca el mes:");
			mes = sc.nextInt();
		}while(mes < 1 || mes > 12);
		
		do {
			System.out.println("Introduzca el dia");
			dia = sc.nextInt();
		}while(dia < 1 && dia > 31);
		/* Creamos la instancia de birthdate */
		birthdate = LocalDate.of(anio, mes, dia);
		
		/*
		 * TODO
		 * Controlar que el usuario no introduzca una letra en vez de números.
		 */
		System.out.println("Introduzca el prefijo telefonico (34 por defecto): ");
		prefix = sc.nextLine();
		
		System.out.println("\nIntroduzca su numero de telefono: ");
		phone = sc.nextLine();
		
		System.out.println("\nIntroduzca su correo electronico: ");
		email = sc.nextLine();
		
				 
		if(prefix.length() == 0) {
			return new Contact(name, surname, birthdate, phone, email);
		}else {
			return new Contact(name, surname, birthdate, Short.parseShort(prefix), phone, email);
		}
	}
	
	
	/**
	 * Descripción: añade un contacto nuevo en la lista
	 * Parámetros: Contacto c
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
	 private Contact getContact(String telefono) {
		 
		 for(Contact c: contactos) {
			 if(c.getTel() == telefono)
				 return c;
		 }
		 
		 return null;
	 }
	 
	 
	 /**
	  * Descripción: muestra los datos del contacto buscado si existe
	  * Parámetros: telefono: String
	  * @return: muestran los datos del contacto en caso de existir y un mensaje de advertencia si no existe
	  */
	 public void showContact(String telefono) {
		 
		 Contact buscado = getContact(telefono);
		 
		 if(buscado == null)
			 System.out.println("\nNo existe el contacto buscado.");
		 else
			 System.out.println(buscado);
			 
	 }
	 
	 
	 /**
	  * Descripción: elimina el contacto seleccionado
	  * Parámetros: telefono: String
	  * @return: boolean que indica si se ha realizado correctamente el proceso
	  */
	 public boolean deleteContact(String telefono) {
		 Contact buscado = getContact(telefono);
		 
		 if(buscado != null) {
			 buscado = null;
			 return true;
		 }
		
		 return false;
	 }
	 
	 /**
	  * Descripción: muestra el número de elementos almacenados y ofrece la opción de crear un contacto en caso de que esté vacía
	  * @return: cantidad de contactos que hay
	  */
	 public int getNumberContacts() {
		 
		 int total = 0;
		 char add = ' ';
		 Contact c;
		 
		 for(Contact c: contactos) {
			 
			 if(c != null)
				 total += 1;
		 }
		 
		 if(total > 0)
			 return total;
		 else {
			 System.out.println("NO hay contactos en la agenda.");
			 /*pide confirmación para añadir un nuevo contacto*/
			 System.out.println("¿Desea añadir un contacto?(S/N)");
			 add = sc.next().charAt(0);
			 if(add == 'S' || add == 's') {
				 c = createContact();
				 if(addContact(c))
					 System.out.println("\nSe ha creado el contacto.");
				 else
					 System.out.println("\nError. NO se ha podido crear el contacto");
			 }else if(add == 'N' || add == 'n')
				 System.out.println("\n. Ha elegido no crear contactos.");
		 }
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
	 
	 
	 /**
	  * Descripción: genera un listado en fichero
	  * 
	  */
	 /*public boolean saveToFile()*/
		
	
}