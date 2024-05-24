package pruebas;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import paquete.Contact;
import paquete.ContactList;

public class ContactListTest {
   
    @Test
    void testAddContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
    
        try{
            clista.addContact(c);
        }catch(Exception e){
            fail("Falla al añadir contacto a la lista" + e.getMessage());
        }         
        
    }

    @Test
    void testCreateContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");

        try{
            Contact c1 = new Contact("Juan", "Gonzalez", LocalDate.now(), "667154565");
            clista.addContact(c1);
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto" + e.getMessage());
        }
        try{
            Contact c1 = new Contact();
            clista.addContact(c1);
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto con parametros vacios" + e.getMessage());
        }
        try{
            Contact c1 = new Contact("", "", LocalDate.now(), "667154565");
            clista.addContact(c1);
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto" + e.getMessage());
        }
    }

    @Test
    void testDeleteContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
    
        if(clista.getContact(c.getPhone(), c.getPrefix()) == c){
            clista.deleteContact(c.getPhone(), c.getPrefix());
            fail("No se ha podido borrar el contacto");
        }else{
            fail("Fallo no se ha podido encontrar el contacto");
        }
    }

    @Test
    void testGetContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        
        clista.addContact(c);
       
        if(clista.getContact(c.getPhone(),c.getPrefix()) != c){
            fail("No se ha podido encontrar el contacto");
        }
              
    }

    @Test
    void testGetContactos() {
        //es el getter
    }

    @Test
    void testGetNumberContacts() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        clista.addContact(c);

        if(clista.getNumberContacts() !=1){
            fail("Falla al devolver el tamaño de la lista");
        }
        clista.deleteContact(c.getPhone(), c.getPrefix());
        if(clista.getNumberContacts() !=0){
            fail("Falla al devolver el tamaño de la lista");
        }

    }

    @Test
    void testShowContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
    }

    @Test
    void testShowContacts() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        clista.addContact(c);
        clista.showContact(c.getPhone(), c.getPrefix());
    }
}
