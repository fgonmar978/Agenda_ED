package Menues;

import java.time.LocalDate;

import IO_Managers.InputManager;
import paquete.Contact;

/**
 * Menu que se encarga de editar los datos de un contacto
 * @author Francisco Manuel Gonzalez Martin
 * @version 1.0
 */
public class EditMenu extends Menu
{
    //Titulo base que se editara segun el contacto que se vaya modificando
    private String baseTitle;

    //Contacto a editar
    private Contact contact;

    public EditMenu(String[] options, String title)
    {
        super(options, title);
        baseTitle = title;
    }

    @Override
    public boolean selectOption(int option)
    {
        switch (option)
        {
            //Terminar edicion
            case 0:
                return false;
            
            //Editar nombre
            case 1:
                contact.setNombre(InputManager.askForString("Introduce el nuevo nombre: ", false));
                changeTitleContactName(contact.getNombre());
                break;
            
            //Editar apellidos
            case 2:
                contact.setApellidos(InputManager.askForString("Introduce el nuevo apellido: ", false));
                break;

            //Editar fecha nacimiento
            case 3:
                
                int day;
                int month;
                int year;
                
                day = InputManager.askForInt("Introduce el nuevo dia: ");
                month = InputManager.askForInt("Introduce el nuevo mes: ");
                year = InputManager.askForInt("Introduce el nuevo anio: ");

                contact.setFechaNac(LocalDate.of(year, month, day));

                break;

            //Editar prefijo
            case 4:
                String prefix = InputManager.askForString("Introduce el nuevo prefijo: ", true);

                if (prefix.length() == 0)
                    contact.setPrefix((short) 34);
                else
                    contact.setPrefix(Short.parseShort(prefix));
                
                break;

            //Editar telefono
            case 5:
                contact.setPhone(InputManager.askForString("Introduce el nuevo telefono: ", false));
                break;

            //Editar email
            case 6:
                contact.setEmail(InputManager.askForString("Introduce el nuevo correo: ", false));
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }
        
        return true;
    }

    /**
     * Establece el contacto a editar
     * @param contact contacto a editar
     */
    public void setContact(Contact contact)
    {
        changeTitleContactName(contact.getNombre());
        this.contact = contact;
    }

    /**
     * Cambia el nombre del contacto en el titulo del menu
     * @param name nuevo nombre del contacto
     */
    private void changeTitleContactName(String name)
    {
        title = baseTitle + ": " + name;
    }

}
