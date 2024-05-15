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
        //TODO: Entrada de datos sin controlar
        String string;

        System.out.print(message);

        string = scanner.nextLine();

        return string;
    }

    /**
     * Pregunta por un int
     * @param message Mensaje a mostrar
     * @return El input realizado (int)
     */
    public static int askForInt(String message)
    {
        //TODO: Entrada de datos sin controlar
        int number;

        System.out.print(message);

        number = scanner.nextInt();

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
        //TODO: Entrada de datos sin controlar
        System.out.print(question);
        char charRead = scanner.next().toLowerCase().charAt(0);
        
        return charRead == 's';
    }
}
