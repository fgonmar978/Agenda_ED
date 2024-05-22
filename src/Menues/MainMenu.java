package Menues;

import IO_Managers.InputManager;
import paquete.Contact;
import paquete.ContactList;

/**
 * Clase que representa el menu principal
 * @author Francisco Manuel Gonzalez Martin
 * @version 0.1
 * @since 25/4/2024
 */
public class MainMenu extends Menu
{
    private ContactList contactList;
    private EditMenu editMenu;
    private EncryptMenu encryptMenu;

    /**
     * Crea un nuevo menu principal
     * @param options Array con las opciones del menu
     * @param title Titulo del menu
     * @param contactList Lista de contactos con la que trabajar
     * @param scanner scanner que usaremos para la entrada por teclado
     */
    public MainMenu(String[] options, String title, ContactList contactList)
    {
        super(options, title);
        this.contactList = contactList;
        editMenu = new EditMenu(Menu.editOptions, "Editando contacto");
        encryptMenu = new EncryptMenu(Menu.encryptOptions, "Seleccion de encriptacion");
    }

    @Override
    public boolean selectOption(int option)
    {
        int nContacts;
        Contact contact;
        String prefix;
        String phone;

        switch (option)
        {
            //Salir
            case 0:
                return false;

            //Crear contacto
            case 1:
                if (contactList.addContact(contactList.createContact()))
                {
                    System.out.println("Contacto creado");
                } else
                {
                    System.out.println("No se ha podido crear el contacto");
                }
                break;

            //Editar contacto
            case 2:            
                prefix = InputManager.askForString("Introduzca el prefijo de telefono: ", true);
                phone = InputManager.askForString("Introduzca el numero de telefono: ", false);

                if (prefix.isBlank())
                    editingContact(contactList.getContact(phone, Contact.PREFIX_DEFAULT));
                else
                    try
                    {
                        editingContact(contactList.getContact(phone, Short.parseShort(prefix)));
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Error al leer el prefijo de numero");
                    }
                    
                break;

            //Consultar contacto
            case 3:
                prefix = InputManager.askForString("Introduzca el prefijo de telefono: ", true);
                phone = InputManager.askForString("Introduzca el numero de telefono: ", false);
                
                if (prefix.isBlank())
                    contactList.showContact(phone, Contact.PREFIX_DEFAULT);
                else
                    try
                    {
                        contactList.showContact(phone, Short.parseShort(prefix));
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Error al leer el prefijo de numero");
                    }

                break;

            //Eliminar contacto
            case 4:
                prefix = InputManager.askForString("Introduzca el prefijo de telefono: ", true);
                phone = InputManager.askForString("Introduzca el numero de telefono: ", false);
                
                if (prefix.isBlank())
                    if (!contactList.deleteContact(phone, Contact.PREFIX_DEFAULT))
                        System.err.println("No se ha encontrado el contacto");
                    else
                        System.err.println("Se ha eliminado el contacto");
                else
                    try
                    {
                        if (!contactList.deleteContact(phone, Short.parseShort(prefix)))
                            System.err.println("No se ha encontrado el contacto");
                        else
                            System.err.println("Se ha eliminado el contacto");
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Error al leer el prefijo de numero");
                    }
                    
                break;

            //Numero de contactos
            case 5:
                nContacts = contactList.getNumberContacts();
                if (nContacts <= 0)
                {

                    System.out.println("NO hay contactos en la agenda.");
                    /*pide confirmación para añadir un nuevo contacto*/

                    if (InputManager.askTrueFalseQuestion("¿Desea añadir un contacto?(S/N): "))
                    {
                        contact = contactList.createContact();

                        if (contactList.addContact(contact))
                            System.out.println("\nSe ha creado el contacto.");
                        else
                            System.out.println("\nError. NO se ha podido crear el contacto");
                    } else
                        System.out.println("\n. Ha elegido no crear contactos.");
                }
                else
                    System.out.println("Numero de contactos: " + nContacts);
                break;

            //Mostrar todos los contactos
            case 6:
                nContacts = contactList.getNumberContacts();

                if (nContacts <= 0)
                {
                    System.out.println("No hay contactos en la agenda");
                    break;
                }

                contactList.showContacts();

                break;

            //Listar en fichero de texto
            case 7:
                break;

            //Configuracion encriptacion
            case 8:
                editingEncryption();
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }

        return true;
    }
    
    /**
     * Controlador del menu de edicion de contactos
     * @param contact contacto a editar
     */
    private void editingContact(Contact contact)
    {
        int option;
        editMenu.setContact(contact);

        do
        {
            System.out.println(editMenu);
            option = InputManager.askForInt("Selecciona una opcion: ");
        } while (editMenu.selectOption(option));
    }

    /**
     * Controlador del menu de configuracion de encriptacion
     * @param contact contacto a editar
     */
    private void editingEncryption()
    {
        int option;

        do
        {
            System.out.println(encryptMenu);
            option = InputManager.askForInt("Selecciona una opcion: ");
        } while (encryptMenu.selectOption(option));
    }

    @Override
    public String toString()
    {
        StringBuffer menuString = new StringBuffer();
        menuString.append(title);
        menuString.append("\n-----------------\n");

        for (int i = 0; i < editOptions.length; i++)
        {
            menuString.append(String.format("%d: %s\n", i, options[i]));
        }

        return menuString.toString();
    }
}
