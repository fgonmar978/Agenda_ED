package IO_Managers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import paquete.Contact;
import paquete.ContactList;

public class FileManager
{
	
    public static final String BINARY_FILE = "agenda.bin";
    public static final String TEXT_FILE = "agenda.txt";

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
	
	
	/**
	 * Descripción: convierte la lista de bytes al ContactList con objetos Contact
	 * @param fileData
	 * @return ContactList
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ContactList readFromBinaryFile(List<byte[]> fileData) throws IOException, ClassNotFoundException {
		ContactList listaC = new ContactList();
				
		int i = 0;

		for(i = 0; i < fileData.size(); i++) {
			ByteArrayInputStream bs = new ByteArrayInputStream(fileData.get(i));
			ObjectInputStream is = new ObjectInputStream(bs);
			listaC.addContact((Contact) is.readObject());
			is.close();
		}
		
		return listaC;
	}
	
	public static boolean saveToTextFile(ContactList contactlist) throws IOException {
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter(TEXT_FILE));
			
			for(Contact c: contactlist.getContactos()) {
				pw.println("\nApellidos: " + c.getApellidos() + 
							"\nNombre: " + c.getNombre() +
							"\nFecha nacimiento: " + c.getFechaNac() +
							"\nPrefijo: " + c.getPrefix() +
							"\nTelefono: " + c.getPhone() +
							"\nEmail: " + c.getEmail());
			}
			
		}catch(Exception e) {
			return false;
		}finally {
			if(pw != null)
				pw.close();
		}
		
		return true;
	}


}
