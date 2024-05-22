package IO_Managers;

import java.util.Scanner;

/**
 * Clase que se encarga de manejar las entradas de teclado
 */
public class InputManager
{
    /** Scanner del programa */
    public static Scanner scanner;

    /**
     * Pregunta por una string puede permitir entradas vacias
     * @param message Mensaje a mostrar
     * @param allowEmpty True: permite entradas vacias
     * @return El input realizado (String)
     */
    public static String askForString(String message, boolean allowEmpty)
    {
        String string;

        System.out.print(message);

        do
        {
            string = scanner.nextLine().trim();
        } while (!allowEmpty && string.isBlank());

        return string;
    }

    /**
     * Pregunta por un int
     * @param message Mensaje a mostrar
     * @return El input realizado (int)
     */
    public static int askForInt(String message)
    {
        int number = 0;

        System.out.print(message);

        boolean error;

        do
        {
            error = false;

            try
            {
                number = scanner.nextInt();
            } 
            catch (Exception e)
            {
                System.err.println("Se debe introducir un numero");
                error = true;
            }

        } while (error);
        
        //Limpieza de buffer
        scanner.nextLine();

        return number;
    }

    /**
     * Realiza una pregunta de verdadero/falso o si/no
     * @param question Pregunta a realizar
     * @return True si se ha pulsado S, false si se ha pulsado cualquier otra tecla
     */
    public static boolean askTrueFalseQuestion(String question)
    {
        System.out.print(question);

        char charRead = 'c';
        
        boolean error;

        do
        {
            error = false;

            try
            {
                charRead = scanner.next().toLowerCase().charAt(0);
                if (charRead != 's' && charRead != 'n')
                    throw new Exception("Caracter no valido");
            } 
            catch (Exception e)
            {
                System.err.println(e.getMessage());
                error = true;
            }

        } while (error);
        
        return charRead == 's';
    }
}
