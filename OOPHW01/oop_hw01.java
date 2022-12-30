package OOPHW01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

class Person{
    int id = 0 ;
    String name;
    String lastname;
    String phoneNumber;
    Person(int id,String name, String lastname, String phoneNumber){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber =phoneNumber;
    }
    Person(){
        this.id = 0;
        this.name = null;
        this.lastname = null;
        this.phoneNumber = null;
    }
}

class Functions extends JOptionPane{
    static void addPerson(){
        int id = 777;
        String name = showInputDialog(null, "Введите имя контакта","Создание контакта", QUESTION_MESSAGE);
        String lastName = showInputDialog(null, "Введите фамилию контакта","Создание контакта", QUESTION_MESSAGE);
        String phoneNumber = showInputDialog(null, "Введите номер контакта","Создание контакта", QUESTION_MESSAGE);
        PhoneBook.phoneBook.add(new Person(id,name,lastName,phoneNumber));
    }
    static void save() throws IOException{
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PHONEBOOK.txt")));
            for(Person k:PhoneBook.phoneBook){
             writer.write(k.id+" "+k.lastname+" "+k.name+" "+k.phoneNumber);
            }
            writer.close();
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "file is not find", "error", ERROR_MESSAGE);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "file is not find", "error", ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Изменения созранены", "Message", INFORMATION_MESSAGE);
    }
    static void loadPB() throws IOException{
        File file = new File("PHONEBOOK.txt");
        if(file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("PHONEBOOK.txt")));
            String person;
            while((person = reader.readLine()) != null){
                String [] contact = person.split(" ");
                PhoneBook.phoneBook.add(new Person(Integer.parseInt(contact[0]), contact[1], contact[2], contact[3]));
            }
            reader.close();
        }
    }

}
class PhoneBook{
    static ArrayList<Person> phoneBook = new ArrayList<>();
}
public class oop_hw01 extends Functions{
    public static void main(String[] args) throws IOException {
        // addPerson();
        // save();
        loadPB();
        System.out.println(PhoneBook.phoneBook.size());
    }
    
}
