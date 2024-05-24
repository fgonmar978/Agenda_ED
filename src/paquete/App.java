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
        ContactList contactList;

        try 
        {
            contactList = FileManager.readFromBinaryFile(Encrypter.unEncryptFile(FileManager.BINARY_FILE));
        } 
        catch (Exception e)
        {
            System.err.println("Error al cargar el archivo binaro o no existe");
            e.printStackTrace();
            contactList = new ContactList();
        }

        MainMenu mainMenu = new MainMenu(Menu.mainOptions, "Menu principal", contactList);

        InputManager.scanner = new Scanner(System.in);
        do
        {
            System.out.println(mainMenu);
        }
        while (mainMenu.selectOption(InputManager.askForInt("Introduce opcion: ")));

        InputManager.scanner.close();

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
