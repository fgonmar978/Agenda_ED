
/**
 * <h2>Clase persona</h2>
 * Representa una persona
 * @version 0.01
 * @author lmiggon294@g.educaand.es
 * @since 04/2024
 */

package paquete;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable{

	/**
	 * Atributo: nombre
	 */
	protected String nombre;
	
	/**
	 * Atributo apellido
	 */
	protected String apellidos;
	
	/**
	 * Atributo fecha de nacimiento
	 */
	protected LocalDate fechaNac;
	
	public Persona()
	{

	}

	/**
	 * Constructor único
	 * <b>Descripcion</b>:Crea el objeto persona con nombre, apellidos y fecha de nacimiento
	 * @param nombre <i> Nombre de la persona </i>
	 * @param apellidos <i> Apellido de la persona </i>
	 * @param fechaNac <i> Fecha de nacimiento de la persona<i>
	 * */
	
	public Persona(String nombre, String apellidos, LocalDate fechaNac) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna el nombre de la persona
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa el nombre
	 *<b>Estado</b>: Funcional
	 * */
	public String getNombre() {
		return nombre;
	}
	/**
	 *<b>Descripcion</b>:Cambia el nombre de la persona
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna los apellidos de la persona
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Cadena de caracteres que representa los apellidos
	 *<b>Estado</b>: Funcional
	 * */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 *<b>Descripcion</b>:Cambia los apellidos de la persona
	 *<b>Parámetros</b>:Cadena de caracteres
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 *<b>Descripcion</b>:Retorna la fecha de nacimiento de la persona
	 *<b>Parámetros</b>
	 *<b>Valor retornado</b>:Fecha que representa la fecha de nacimiento
	 *<b>Estado</b>: Funcional
	 * */
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	/**
	 *<b>Descripcion</b>:Cambia el nombre de la persona
	 *<b>Parámetros</b>:LocalDate
	 *<b>Valor retornado</b>
	 *<b>Estado</b>: Funcional
	 * */
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	@Override
	public String toString()
	{
		return String.format("Nombre: %s, Apellidos: %s\nFecha de nacimiento %s", nombre, apellidos, fechaNac);
	}
	
	
}
