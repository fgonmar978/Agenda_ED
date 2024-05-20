package Menues;

import IO_Managers.Encrypter;
import IO_Managers.EncryptionType;

public class EncryptMenu extends Menu
{
    public EncryptMenu(String[] options, String title)
    {
        super(options, title);
    }

    @Override
    public boolean selectOption(int option)
    {
        switch (option)
        {
            //Salir
            case 0:
                return false;

            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Encrypter.selectedEncryptionType = EncryptionType.intToEncryptionType(option - 1);
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }
        return true;
    }
}
