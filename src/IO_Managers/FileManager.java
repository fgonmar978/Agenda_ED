package IO_Managers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import paquete.ContactList;

public class FileManager
{
	
    public static final String BINARY_FILE = "agenda.bin";

	static List<byte[]> listaContactos = new ArrayList<byte[]>();

	/**
	 * Descripción: convierte la lista de objetos a una list de array de bytes
	 * @param contactlist
	 * @return List<byte[]>
	 * @throws IOException
	 */
	public static List<byte[]> saveToBinaryFile(ContactList contactlist) throws IOException {
		
		int i = 0;
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		
		for(i = 0; i< ContactList.TAM; i++) {
			
			os.writeObject(contactlist.getContactos()[i]);
			os.flush();
			listaContactos.add(bs.toByteArray());
		}
		
		return FileManager.listaContactos;
	}
	
	public static ContactList readFromBinaryFile(List<byte[]> fileData) {
		ContactList listaC = new ContactList();
		
		
		
		return listaC;
		
	}


}
