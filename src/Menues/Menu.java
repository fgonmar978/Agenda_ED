package Menues;

/**
 * Clase abstracta que representa un menu
 * @author Francisco Manuel Gonzalez Martin
 * @version 1.0
 */
public abstract class Menu
{
    public static String[] mainOptions =
    {
        "Salir",
        "Nuevo contacto",
        "Editar contacto",
        "Consultar contacto",
        "Eliminar contacto",
        "Obtener numero de contactos",
        "Mostrar lista de contactos",
        "Guardar en fichero",
        "Configuracion cifrado"
    };

    public static String[] editOptions =
    {
        "Terminar edicion",
        "Editar nombre",
        "Editar apellidos",
        "Editar fecha de nacimiento",
        "Editar prefijo",
        "Editar telefono",
        "Editar correo"
    };

    public static String[] encryptOptions =
    {
        "Volver al menu principal",
        "Cambiar el tipo de encriptacion a XOR",
        "Cambiar el tipo de encriptacion a CESAR",
        "Cambiar el tipo de encriptacion a AMPLIACION OPCIONAL",
        "Cambiar el tipo de encriptacion a PROPIO",
        "No usar encriptacion"
    };

    /**Opciones del menu*/
    protected String[] options;
    protected String title;

    /**
     * Crea un nuevo menu
     * @param options Array con las opciones del menu
     * @param title Titulo del menu
     */
    public Menu(String[] options, String title)
    {
        this.options = options;
        this.title = title;
    }
    
    /**
     * Devuelve el texto de una opcion
     * @param option opcion a devolver
     * @return String con la opcion seleccionada o Error de indice
     */
    public String getOption(int option)
    {
        if (option < 0 || option > options.length)
            return "Error de indice";
        return options[option];
    }

    /**
     * Ejecuta el codigo de la opcion seleccionada
     * @param opcion opcion a ejecutar : int
     * @return True: debe seguir ejecutandose el menu, False: se ha pulsado el boton de salir
     */
    public abstract boolean selectOption(int option);


    /**
     * Devuelve el titulo del menu
     * @return titulo : String
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Introduce un nuevo titulo
     * @param title nuevo titulo : String
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Devuelve el string con las opciones del menu
     */
    @Override
    public String toString()
    {
        StringBuffer menuString = new StringBuffer("\n" + title + "\n");
        for (int i = 0; i < options.length; i++)
        {
            menuString.append(String.format("%d. %s\n", i, options[i]));
        }

        return menuString.toString();
    }
}
