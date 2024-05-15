package paquete;

import java.time.LocalDate;

public class Contact extends Persona
{	
	/**
	 * Atributo: prefijo
	 */
	private short prefix;
	/**
	 * Atributo: telefono
	 */
	private String phone;
	/**
	 * Atributo: correo
	 */
	private String email;
	/**
	 * Constante: prefijo de serie
	 */
	 public static final short PREFIX_DEFAULT = 34;
	 
	/**
	 * Constructor 1
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento y telefono
	 * @param name <i> Nombre del contacto </i>
	 * @param surname <i> Apellidos del contacto </i>
	 * @param birthdate <i> Fecha de nacimiento del contacto<i>
	 * @param phone <i> Telefono de la persona </i>
	 * */
	 
	public Contact(String name, String surname, LocalDate birthdate, String phone) {
		super(name, surname, birthdate);
		this.phone = phone;
		prefix = 34;
	}
	
	/**
	 * Constructor 2
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento, telefono y correo
	 * @param name <i> Nombre del contacto </i>
	 * @param surname <i> Apellidos del contacto </i>
	 * @param birthdate <i> Fecha de nacimiento del contacto<i>
	 * @param phone <i> Telefono de la persona </i>
	 *  @param email <i> Correo de la persona </i>
	 * */
	
	public Contact(String name, String surname, LocalDate birthdate, String email, String phone) {
		super(name, surname, birthdate);
		this.phone = phone;
		this.email = email;
		prefix = PREFIX_DEFAULT;
	}
	
	/**
	 * Constructor 3
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento, telefono y correo
	 * @param name <i> Nombre del contacto </i>
	 * @param surname <i> Apellidos del contacto </i>
	 * @param birthdate <i> Fecha de nacimiento del contacto<i>
	 * @param phone <i> Telefono de la persona </i>
	 *  @param email <i> Correo de la persona </i>
	 * */
	
	public Contact(String name, String surname, LocalDate birthdate, short prefix, String phone, String email ) {
		super(name, surname, birthdate);
		this.phone = phone;
		this.email = email;
		this.prefix = prefix;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el prefijo del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Short que representa el prefijo
	 *<b>Estado</b>: Funcional
	 * */
	
	public short getPrefix() {
		return prefix;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el prefijo del contacto
	 *<b>Parámetros</b>:Short
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	
	public void setPrefix(short prefix) {
		this.prefix = prefix;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el telefono del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa el telefono
	 *<b>Estado</b>: Funcional
	 * */
	
	public String getPhone() {
		return phone;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el telefono del contacto
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el correo del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa el correo
	 *<b>Estado</b>: Funcional
	 * */
	public String getEmail() {
		return email;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el correo del contacto
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * <b>Descripcion</b>: Compara el telefono y prefijo de este de un contacto
	 * <b>Parámetros</b>: Short, cadena de caracteres
	 * <b>Valor retornado</b>: Verdadero si se cumple la condicion, falso en caso contrario
	 * <b>Estado</b>:Funcional 
	 * */
	
	public boolean comparePhone(short prefix, String phone) {
		if(this.phone.equals(phone) && this.prefix == prefix) return true;
		
		return false;
	}
	/**
	 * <b>Descripcion</b>: Compara el telefono de un contacto
	 * <b>Parámetros</b>: Cadena de caracteres
	 * <b>Valor retornado</b>: Verdadero si se cumple la condicion, falso en caso contrario
	 * <b>Estado</b>:Funcional 
	 * */
	public boolean comparePhone(String phone) {
		if(this.phone.equals(phone)) return true;
		
		return false;
	}

	@Override
	public String toString() {
		return "Contact:\n prefix:" + prefix + "\n phone:" + phone + "\n email:" + email;
	}
	
	
	/* 
	@Override
	public boolean equals(Object contact) {
		if(this.phone.equals(phone) && this.prefix == prefix) return true;
		
		return false;
	}
	*/
}
