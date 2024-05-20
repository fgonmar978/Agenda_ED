package IO_Managers;

public enum EncryptionType
{
    XOR,
    CESAR,
    AMPLIACION_OPCIONAL,
    PROPIO,
    NONE;

    /**
     * Convierte un int en un tipo de encriptacion
     * @param eType int que representa un tipo de encriptacion
     * @return tipo de encriptacion seleccionado
     */
    public static EncryptionType intToEncryptionType(int eType)
    {
        switch (eType)
        {
            case 0:
                return XOR;
            
            case 1:
                return CESAR;

            case 2:
                return AMPLIACION_OPCIONAL;

            case 3:
                return PROPIO;
        
            default:
                return NONE;
        }
    }
}
