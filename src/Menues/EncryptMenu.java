package Menues;

import IO_Managers.Encrypter;
import IO_Managers.EncryptionType;

/**
 * Menu que se encarga de seleccionar que tipo de encriptacion se va a usar
 * @author Francisco Manuel Gonzalez Martin
 * @version 1.0
 */
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
    
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nTipo de encriptacion actual: %s\n", Encrypter.selectedEncryptionType);
    }
}
