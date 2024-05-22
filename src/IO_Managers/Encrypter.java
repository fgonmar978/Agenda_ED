package IO_Managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

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
     * @param fileData Lista de bytes que cada array de byte represnta un objeto sin encriptar
     */
    public static void encryptFile(List<byte[]> fileData)
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

        //Encriptamos cada objeto
        for (byte[] bytes : fileData)
        {
            switch (selectedEncryptionType) 
            {
                case XOR:
                    xorEncryption(bytes);
                    break;

                case CESAR:
                    cesarEncryption(bytes);
                    break;

                case AMPLIACION_OPCIONAL:
                    break;

                case PROPIO:
                    break;
                
                default:
                    break;
            }
        }

        try
        {
            //Guardamos primero el int que representa el encriptado que hemos usado y despues los datos
            writer.write(EncryptionType.encryptionTypeToInt(selectedEncryptionType));

            //Guardo el tamaño de los objetos para poder leerlos luego
            writer.write(fileData.get(0).length);

            for (byte[] bytes : fileData)
            {
                writer.write(bytes);
            }

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
     * @return Lista con array de bytes que representan los objetos desencriptados
     * @throws Exception El archivo no existe o no tenemos permiso de lectura
     */
    public static List<byte[]> unEncryptFile(String filePath) throws Exception
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

        int objectSize = input.read();

        List<byte[]> bytes = new LinkedList<byte[]>();

        byte[] data;

        do
        {
            data = input.readNBytes(objectSize);

            if (data == null)
                break;

            switch (selectedEncryptionType)
            {
                case XOR:
                    xorEncryption(data);
                    break;
    
                case CESAR:
                    cesarUnEncrypt(data);
                    break;
    
                case AMPLIACION_OPCIONAL:
                    break;
    
                case PROPIO:
                    break;
    
                default:
                    break;
            }
            
            bytes.add(data);

        } while (true);

        input.close();

        return bytes;
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
