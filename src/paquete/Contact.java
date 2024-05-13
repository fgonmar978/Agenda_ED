package paquete;

import java.time.LocalDate;

public class Contact extends Persona
{	
	/**
	 * Atributo: prefijo
	 */
	private short prefijo;
	/**
	 * Atributo: telefono
	 */
	private String telefono;
	/**
	 * Atributo: correo
	 */
	private String correo;
	/**
	 * Constante: prefijo de serie
	 */
	 public static final short PREFIJO_DEFAULT = 34;
	 
	/**
	 * Constructor 1
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento y telefono
	 * @param nombre <i> Nombre del contacto </i>
	 * @param apellidos <i> Apellidos del contacto </i>
	 * @param fechaNac <i> Fecha de nacimiento del contacto<i>
	 * @param telefono <i> Telefono de la persona </i>
	 * */
	 
	public Contact(String nombre, String apellidos, LocalDate fechaNac, String telefono) {
		super(nombre, apellidos, fechaNac);
		this.telefono = telefono;
		prefijo = 34;
	}
	
	/**
	 * Constructor 2
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento, telefono y correo
	 * @param nombre <i> Nombre del contacto </i>
	 * @param apellidos <i> Apellidos del contacto </i>
	 * @param fechaNac <i> Fecha de nacimiento del contacto<i>
	 * @param telefono <i> Telefono de la persona </i>
	 *  @param correo <i> Correo de la persona </i>
	 * */
	
	public Contact(String nombre, String apellidos, LocalDate fechaNac, String correo, String telefono) {
		super(nombre, apellidos, fechaNac);
		this.telefono = telefono;
		this.correo = correo;
		prefijo = PREFIJO_DEFAULT;
	}
	
	/**
	 * Constructor 3
	 * <b>Descripcion</b>:Crea el objeto contacto con nombre, apellidos, fecha de nacimiento, telefono y correo
	 * @param nombre <i> Nombre del contacto </i>
	 * @param apellidos <i> Apellidos del contacto </i>
	 * @param fechaNac <i> Fecha de nacimiento del contacto<i>
	 * @param telefono <i> Telefono de la persona </i>
	 *  @param correo <i> Correo de la persona </i>
	 * */
	
	public Contact(String nombre, String apellidos, LocalDate fechaNac, String correo, String telefono, short prefijo) {
		super(nombre, apellidos, fechaNac);
		this.telefono = telefono;
		this.correo = correo;
		this.prefijo = prefijo;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el prefijo del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Short que representa el prefijo
	 *<b>Estado</b>: Funcional
	 * */
	
	public short getPrefijo() {
		return prefijo;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el prefijo del contacto
	 *<b>Parámetros</b>:Short
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	
	public void setPrefijo(short prefijo) {
		this.prefijo = prefijo;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el telefono del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa el telefono
	 *<b>Estado</b>: Funcional
	 * */
	
	public String getTel() {
		return telefono;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el telefono del contacto
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el correo del contacto
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa el correo
	 *<b>Estado</b>: Funcional
	 * */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 *<b>Descripcion</b>:Cambia el correo del contacto
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public boolean compararTelefono(short prefijo, String telefono) {
		if(this.telefono.equals(telefono)) return true;

		
		return false;
	}
	
	
}
