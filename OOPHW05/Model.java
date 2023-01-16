package OOPHW05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

interface FunctionOfPhonebook{

    void loadPhoneBook();

    void saveChangeOfPhonebook() throws IOException;

    void addContactOfPhonebook();

    void deleteContactOfPhonebook();
}
class Model extends JOptionPane implements FunctionOfPhonebook{

    public void loadPhoneBook(){

    }

    public void addContactOfPhonebook(){
        Contact contact = new Contact.ContactBuilder()
        .firstName(showInputDialog(null, "Введите имя Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .lastName(showInputDialog(null, "Введите фамилию Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .phoneNumber(showInputDialog(null, "Введите номер Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .description(showInputDialog(null, "Введите описание Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .status(showInputDialog(null, "Введите статус Контакта: ", "Окно ввода",QUESTION_MESSAGE))
        .build();

        Phonebook.addContacts(contact);
        
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

    public void deleteContactOfPhonebook(){

    }

    public static void main(String[] args) throws IOException {
        Model obj = new Model();
        obj.addContactOfPhonebook();
        obj.addContactOfPhonebook();
        obj.addContactOfPhonebook();
        // System.out.println(Phonebook.getPhonebook().get(2));
        obj.saveChangeOfPhonebook();
    }
    
}
