package paquete;

import java.util.Scanner;

import IO_Managers.InputManager;
import Menues.MainMenu;
import Menues.Menu;

public class App
{
    public static void main(String[] args)
    {
        ContactList contactList = new ContactList();
        MainMenu mainMenu = new MainMenu(Menu.mainOptions, "Menu principal", contactList);

        InputManager.scanner = new Scanner(System.in);
        do
        {
            System.out.println(mainMenu);
        }
        while (mainMenu.selectOption(InputManager.askForInt("Introduce opcion: ")));
    }
}
