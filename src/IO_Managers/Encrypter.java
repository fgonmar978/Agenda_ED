package IO_Managers;

import java.io.File;

public class Encrypter
{
    public static final EncryptionType DEFAULT_ENCRYPTION_TYPE = EncryptionType.XOR;
    public static EncryptionType selectedEncryptionType = DEFAULT_ENCRYPTION_TYPE;

    public static void encryptFile(byte[] fileData)
    {

    }
    
    public static byte[] unEncryptFile(File file) throws Exception
    {
        throw new Exception("Error no implementado");
    }
}
