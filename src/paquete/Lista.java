package paquete;

public class Lista
{

	/**
	 * Atributo : array de contacto
	 */
	private Contacto contactos[];
	
	/**
	 * Constructor: crea el array contactos
	 */
	public Lista() {
		contactos = new Contacto[10];
	}
	
	/**
	 * Descripción: añade un contacto nuevo en la lista
	 */
	public boolean addContact(Contacto c) {
		
		int i = 0;
		for(i = 0; i < contactos.length; i++) {
			if(contactos[i] == null) {
				contactos[i] = c;
				return true;
			}
		}
		
		return false;
	}
	
}