package IO_Managers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import paquete.Contact;
import paquete.ContactList;

public class FileManager
{
	
    public static final String BINARY_FILE = "agenda.bin";
	public static final String TEXT_FILE = "agenda.txt";
	
	/**
	 * Descripción: convierte la lista de objetos a un array de bytes
	 * @param contactlist
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] saveToBinaryFile(ContactList contactlist) throws IOException {
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		
		os.writeObject(contactlist);
		os.flush();
		
		return bs.toByteArray();
	}
	
	
	/**
	 * Descripción: convierte el array de bytes al ContactList con objetos Contact
	 * @param fileData
	 * @return ContactList
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ContactList readFromBinaryFile(byte[] fileData) throws IOException, ClassNotFoundException {
		ContactList listaC;
						
		ByteArrayInputStream bs = new ByteArrayInputStream(fileData);
		ObjectInputStream is = new ObjectInputStream(bs);

		listaC = (ContactList) is.readObject();
		is.close();

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
