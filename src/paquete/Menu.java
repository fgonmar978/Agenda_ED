package paquete;

/**
 * Clase abstracta que representa un menu
 * @author Francisco Manuel Gonzalez Martin
 * @version 0.1
 * @since 25/4/2024
 */
public abstract class Menu
{
    /**Opciones del */
    protected String[] opciones;
    protected String titulo;

    protected int nOpciones;

    /**
     * Crea un nuevo menu
     * @param opciones Array con las opciones del menu
     * @param titulo Titulo del menu
     */
    public Menu(String[] opciones, String titulo)
    {
        this.opciones = opciones;
        this.titulo = titulo;
    }
    
    /**
     * Devuelve el texto de una opcion
     * @param opcion opcion a devolver
     * @return String con la opcion seleccionada o Error de indice
     */
    public String getOpcion(int opcion)
    {
        if (opcion < 0 || opcion > opciones.length)
            return "Error de indice";
        return opciones[opcion];
    }

    /**
     * Ejecuta el codigo de la opcion seleccionada
     * @param opcion opcion a ejecutar : int
     */
    public abstract void seleccionarOpcion(int opcion);


    /**
     * Devuelve el titulo del menu
     * @return titulo : String
     */
    public String getTitulo()
    {
        return titulo;
    }

    /**
     * Introduce un nuevo titulo
     * @param titulo nuevo titulo : String
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
}
