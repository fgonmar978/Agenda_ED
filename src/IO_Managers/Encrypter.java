package IO_Managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Clase que se encarga de encriptar/desencriptar informacion para despues escribirla o leerla de un fichero binario
 * @author Francisco Manuel Gonzalez Martin
 * @since 25/5/2024
 * @version 1.1
 */
public class Encrypter
{
    /**Tipo de encriptacion por defecto */
    public static final EncryptionType DEFAULT_ENCRYPTION_TYPE = EncryptionType.XOR;

    /**Tipo de encriptacion seleccionada */
    public static EncryptionType selectedEncryptionType = DEFAULT_ENCRYPTION_TYPE;

    /**Clave usada para el cifrado XOR */
    private static final byte XOR_KEY = 74;

    /**Desplazamiento usado por el cifrado cesar */
    private static final int CESAR_SHIFT = 1;

    /**
     * Crea un fichero, encripta si es necesario los bytes de datos y lo guarda en disco
     * @param fileData Array de bytes que represnta los contactos sin encriptar
     */
    public static void encryptFile(byte[] fileData)
    {
        OutputStream writer;

        //Abrimos archivo
        try
        {
            writer = new FileOutputStream(FileManager.BINARY_FILE);
        } 
        catch (IOException e)
        {
            System.err.println("No se pudo crear/escribir el archivo binario");
            e.printStackTrace();
            return;
        }

        //Encriptamos datos
        switch (selectedEncryptionType)
        {
            case XOR:
                xorEncryption(fileData);
                break;

            case CESAR:
                cesarEncryption(fileData);
                break;

            case AMPLIACION_OPCIONAL:
                break;

            case PROPIO:
                break;

            default:
                break;
        }
        
        try
        {
            //Guardamos primero el int que representa el encriptado que hemos usado y despues los datos
            writer.write(EncryptionType.encryptionTypeToInt(selectedEncryptionType));
            writer.write(fileData);

            writer.close();
        } 
        catch (IOException e)
        {
            System.err.println("No se pudo guardar el archivo binario");
            e.printStackTrace();
        }

    }
    
    @SuppressWarnings("resource")
    /**
     * Lee y desencripta si es necesario los datos de un archivo binario
     * @param filePath Ruta al archivo binario
     * @return Array de bytes que representan los objetos desencriptados
     * @throws Exception El archivo no existe o no tenemos permiso de lectura
     */
    public static byte[] unEncryptFile(String filePath) throws Exception
    {
        InputStream input;

        //Abrimos archivo
        try
        {
            input = new FileInputStream(filePath);
        } 
        catch (Exception e)
        {
            throw e;
        }

        //El primer byte es el int que indica como se cifro el archivo
        selectedEncryptionType = EncryptionType.intToEncryptionType(input.read());

        //Leemos el resto de bytes y desencriptamos
        byte[] fileData = input.readAllBytes();

        switch (selectedEncryptionType)
        {
            case XOR:
                xorEncryption(fileData);
                break;

            case CESAR:
                cesarUnEncrypt(fileData);
                break;

            case AMPLIACION_OPCIONAL:
                break;

            case PROPIO:
                break;

            default:
                break;
        }

        //Cerramos archivo y devolvemos los datos
        input.close();
        return fileData;
    }
    
    /**
     * Encripta el array de bytes usando la operacion XOR
     * @param data array de bytes a encriptar
     */
    private static void xorEncryption(byte[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = (byte) (data[i] ^ XOR_KEY);
        }
    }

    /**
     * Encripta el array de bytes desplazando los bytes (debemos tener cuidado de no salirnos de la tabla ASCII)
     * @param data array de bytes a encriptar
     */
    private static void cesarEncryption(byte[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = (byte) ((int) data[i] + CESAR_SHIFT);
        }
    }
    
    /**
     * Deshace la encriptacion cesar
     * @param data array de bytes encriptados
     */
    private static void cesarUnEncrypt(byte[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = (byte) ((int) data[i] - CESAR_SHIFT);
        }
    }
}
