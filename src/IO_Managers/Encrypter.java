package IO_Managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Clase que se encarga de encriptar/desencriptar informacion para despues escribirla o leerla de un fichero binario
 * @author Francisco Manuel Gonzalez Martin
 * @since 22/5/2024
 * @version 1.0
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
     * @param fileData bytes de datos a escribir sin encriptar
     */
    public static void encryptFile(byte[] fileData)
    {
        OutputStream  writer;

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
     * @return El array de bytes con los datos desencriptados
     * @throws Exception El archivo no existe o no tenemos permiso de lectura
     */
    public static byte[] unEncryptFile(String filePath) throws Exception
    {
        InputStream input;

        try
        {
            input = new FileInputStream(filePath);
        } catch (Exception e)
        {
            throw e;
        }

        //El primer byte es el int que indica como se cifro el archivo
        EncryptionType selectedEncryptionType = EncryptionType.intToEncryptionType(input.read());

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

        input.close();

        return fileData;
    }

    /**
     * Encripta el array de bytes usando la operacion XOR
     * @param fileData array de bytes a encriptar
     */
    private static void xorEncryption(byte[] fileData)
    {
        for (int i = 0; i < fileData.length; i++)
        {
            fileData[i] = (byte) (fileData[i] ^ XOR_KEY);
        }
    }

    /**
     * Encripta el array de bytes desplazando los bytes (debemos tener cuidado de no salirnos de la tabla ASCII)
     * @param fileData array de bytes a encriptar
     */
    private static void cesarEncryption(byte[] fileData)
    {
        for (int i = 0; i < fileData.length; i++)
        {
            fileData[i] = (byte) ((int) fileData[i] + CESAR_SHIFT);
        }
    }
    
    /**
     * Deshace la encriptacion cesar
     * @param fileData array de bytes encriptados
     */
    private static void cesarUnEncrypt(byte[] fileData)
    {
        for (int i = 0; i < fileData.length; i++)
        {
            fileData[i] = (byte) ((int)fileData[i] - CESAR_SHIFT); 
        }
    }
}
