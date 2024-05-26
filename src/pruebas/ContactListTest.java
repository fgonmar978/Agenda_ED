package pruebas;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;

import paquete.Contact;
import paquete.ContactList;

public class ContactListTest {
   
    @Test
    void testAddContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        
        clista.addContact(c);
        if(clista.getContact(c.getPhone(),c.getPrefix()) != c) {
            fail("Fallo el contacto no se ha podido añadir a la lista");
        }
        
    }

    @Test
    void testCreateContact() {
        ContactList clista = new ContactList();
        
        try{
            Contact c = new Contact("Juan", "Gonzalez", LocalDate.now(), "667154565");
            clista.addContact(c);
            if (clista.getContact(c.getPhone(), c.getPrefix()) == c) {
                clista.createContact();
            }
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto" + e.getMessage());
            
        }
        try{
            Contact c2 = new Contact();
            clista.addContact(c2);
            if (clista.getContact(c2.getPhone(), c2.getPrefix()) != c2) {
                fail("Fallo no se ha creado el contacto");
            }
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto con parametros vacios" + e.getMessage());
        }
        try{
            Contact c3 = new Contact("", "", LocalDate.now(), "667154565");
            clista.addContact(c3);
            if (clista.getContact(c3.getPhone(), c3.getPrefix()) != c3) {
                fail("Fallo no se ha creado el contacto");
            }
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto" + e.getMessage());
        }
        try{
            Contact c4 = new Contact("Pepe", "Gonzlez", LocalDate.now(), "667154565","pepe@gmail.com");
            clista.addContact(c4);
            if (clista.getContact(c4.getPhone(), c4.getPrefix()) != c4) {
                fail("Fallo no se ha creado el contacto");
            }
        }catch(Exception e){
            fail("Fallo no se ha creado el contacto" + e.getMessage());
        }
        
    }

    @Test
    void testDeleteContact() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        
        clista.addContact(c);
        if(!clista.deleteContact(c.getPhone(),c.getPrefix())){
            fail("No se ha podido eliminar el contacto");
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
        clista.addContact(c);
        if(clista.getContact(c.getPhone(), c.getPrefix()) == c){
            clista.showContact(c.getPhone(), c.getPrefix());
        }else 
            fail("No se ha podido mostrar el contacto");

        clista.deleteContact(c.getPhone(),c.getPrefix());
        if (clista.getContact(c.getPhone(), c.getPrefix()) != c) {
            System.out.println("No se ha podido mostrar el contacto");
        } else {
            fail("El contacto todavía existe después de eliminarlo");
        }
    }
    
    @Test
    void testShowContacts() {
        ContactList clista = new ContactList();
        Contact c = new Contact("lucia", "miguel", LocalDate.now(), "696879131");
        clista.addContact(c);
        clista.showContacts();
    }
}
