package OOPHW05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


interface FunctionOfPhonebook{

    void loadPhoneBook() throws IOException;

    void saveChangeOfPhonebook() throws IOException;

    void addContactOfPhonebook() throws IOException;

    void findContactOfPhonebook();
}

class Model extends JOptionPane implements FunctionOfPhonebook{

    public void loadPhoneBook() throws IOException{
        File file = new File("PHONEBOOK.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("PHONEBOOK.txt")));
            String contact;
            while((contact = reader.readLine()) != null){
                String [] contacts = contact.split(" ");
                Contact oldContact = new Contact.ContactBuilder()
                .firstName(contacts[0])
                .lastName(contacts[1])
                .phoneNumber(contacts[2])
                .description(contacts[3])
                .status(contacts[4])
                .build(); 

                Phonebook.getPhonebook().add(oldContact);
            }
            reader.close();

        }

    }

    public void addContactOfPhonebook() throws IOException{
        Contact contact = new Contact.ContactBuilder()
        .firstName(showInputDialog(null, "Введите имя Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .lastName(showInputDialog(null, "Введите фамилию Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .phoneNumber(showInputDialog(null, "Введите номер Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .description(showInputDialog(null, "Введите описание Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .status(showInputDialog(null, "Введите статус Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .build();

        Phonebook.addContacts(contact);
        saveChangeOfPhonebook();
    }

    public void saveChangeOfPhonebook() throws IOException{
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PHONEBOOK.txt")));
            for(Contact c : Phonebook.getPhonebook()){
                writer.write(c.getFirstName()+" "+c.getLastName()+" "+c.getPhonenumber()+" "+c.getDescription()+" "+c.getStatus()+"\n");
            }
            writer.close();
        } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Файл не найден", "Ошибка", ERROR_MESSAGE);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Файл не найден", "Ошибка", ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Изменения сохранены", "Сообщение", INFORMATION_MESSAGE);
        
    }

    public void findContactOfPhonebook(){
        String txt = "";
        String who = showInputDialog(null, "Введите имя контакта, которого ищете:", "Кого ищем", QUESTION_MESSAGE);
        for(Contact c : Phonebook.getPhonebook()){
            if(who.equalsIgnoreCase(c.getFirstName())){
                txt = c.getFirstName()+" "+c.getLastName()+" "+c.getPhonenumber()+" "+c.getDescription()+" "+c.getStatus()+"\n";
            } else {
                txt = "Не нашел";
            }
        }
        showMessageDialog(null, txt,"Результат поиска", INFORMATION_MESSAGE);
    }
    
}
