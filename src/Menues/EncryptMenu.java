package Menues;

public class EncryptMenu extends Menu
{
    public EncryptMenu(String[] options, String title)
    {
        super(options, title);
    }

    @Override
    public boolean selectOption(int option)
    {
        if (option < 0 || option > options.length)
            throw new IllegalArgumentException("Opcion no valida");
        return true;
    }
}
