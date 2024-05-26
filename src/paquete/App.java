package paquete;

import java.util.Scanner;

import IO_Managers.Encrypter;
import IO_Managers.FileManager;
import IO_Managers.InputManager;
import Menues.MainMenu;
import Menues.Menu;

public class App
{
    public static void main(String[] args)
    {
        //carga agenda
        ContactList contactList = loadAgenda();

        //Creacion menu principal y scanner
        MainMenu mainMenu = new MainMenu(Menu.mainOptions, "Menu principal", contactList);
        InputManager.scanner = new Scanner(System.in);

        //Bucle principal
        do
        {
            System.out.println(mainMenu);
        } while (mainMenu.selectOption(InputManager.askForInt("Introduce opcion: ")));

        //Cerramos escaner y guardamos agenda
        InputManager.scanner.close();
        saveAgenda(contactList);
    }
    
    /**
     * Metodo que carga los datos de la agenda desde el fichero binario
     * @return La lista de contactos
     */
    public static ContactList loadAgenda()
    {
        ContactList list;
        try
        {
            list = FileManager.readFromBinaryFile(Encrypter.unEncryptFile(FileManager.BINARY_FILE));
            System.out.println("Se han cargado los datos de su agenda");
            return list;
        } 
        catch (Exception e)
        {
            /*System.err.println("Error al cargar el archivo binaro o no existe");
            e.printStackTrace();*/
            return new ContactList();
        }
    }
    
    /**
     * Guarda los datos de la agenda a un archivo binario
     * @param contactList Los datos de los contactos
     */
    public static void saveAgenda(ContactList contactList)
    {
        try
        {
            Encrypter.encryptFile(FileManager.saveToBinaryFile(contactList));
        } 
        catch (Exception e)
        {
            System.err.println("Error al guardar archivo binario");
            e.printStackTrace();
        }
    }
}
