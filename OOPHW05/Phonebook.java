package OOPHW05;

import java.util.ArrayList;
import OOPHW05.Contact;

public class Phonebook {
    private static ArrayList<Contact> phonebook = new ArrayList<>();
    
    public static ArrayList<Contact> getPhonebook(){
        return phonebook;
    }

    public static void addContacts(Contact contact){
        phonebook.add(contact);
    }
}
