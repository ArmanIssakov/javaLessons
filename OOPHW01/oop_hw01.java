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
    static void addPerson() throws IOException{
        int id = PhoneBook.phoneBook.size() + 1;
        String name = showInputDialog(null, "Введите имя контакта","Создание контакта", QUESTION_MESSAGE);
        String lastName = showInputDialog(null, "Введите фамилию контакта","Создание контакта", QUESTION_MESSAGE);
        String phoneNumber = showInputDialog(null, "Введите номер контакта","Создание контакта", QUESTION_MESSAGE);
        PhoneBook.phoneBook.add(new Person(id,name,lastName,phoneNumber));
        saveChange();
    }
    static void saveChange() throws IOException{
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PHONEBOOK.txt")));
            for(Person k:PhoneBook.phoneBook){
             writer.write(k.id+" "+k.name+" "+k.lastname+" "+k.phoneNumber+"\n");
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
    static void findPerson(){
        String txt = "";
        String who = showInputDialog(null, "Введите номер, имя или фамилию: ", "Кого ищем?", QUESTION_MESSAGE);
        for(Person i : PhoneBook.phoneBook){
            if(who.equalsIgnoreCase(i.lastname) || who.equalsIgnoreCase(i.name) || who.equalsIgnoreCase(i.phoneNumber)){
                
                txt += i.id+" "+ i.lastname+" "+ i.name+ " "+i.phoneNumber+"\n";
            }
            if(txt == null){
                txt = "Я не смог найти";
            }

        }
        showMessageDialog(null, txt, "Жди меня", INFORMATION_MESSAGE);
    }
    static void delPerson() throws IOException{
        String txt = "";
        String who = showInputDialog(null, "Введите Имя или Фамилию", "Сообщение", QUESTION_MESSAGE);
        for(Person i : PhoneBook.phoneBook){
            if(who.equalsIgnoreCase(i.lastname) || who.equalsIgnoreCase(i.name)){
                txt += i.id+" "+ i.lastname+" "+ i.name+ " "+i.phoneNumber+"\n";
            }
            if(txt == null){
                txt = "Я не смог найти";
            }
        }
        
        String delpers = showInputDialog(null, "Введите ID контакта, которого хотите удалить \n или несколько ID через пробел \n чтобы удалить нескольких\n"+txt,
                        "Сообщение",QUESTION_MESSAGE);
        
        for(Person j : PhoneBook.phoneBook){
                if(Integer.parseInt(delpers) == j.id){
                    for(Person k : PhoneBook.phoneBook){
                        if(j.id < k.id){
                            k.id -=1;
                        }
                    }
                    PhoneBook.phoneBook.remove(j);

                }
            }
            saveChange();
            
        }
}
class PhoneBook{
    static ArrayList<Person> phoneBook = new ArrayList<>();
}
public class oop_hw01 extends Functions{
    public static void main(String[] args) throws IOException {

        loadPB();

        
        String input = showInputDialog(null, 
                              "Выберите Пункт: \n1. ДОБАВИТЬ КОНТАКТ\n2. НАЙТИ КОНТАКТ\n3.УДАЛИТЬ КОНТАКТ", 
                                "Меню команд", QUESTION_MESSAGE);
        if(input == null){
            System.exit(0);
        }
        else if (Integer.parseInt(input) == 1){
            addPerson();
        }
        else if(Integer.parseInt(input) == 2){
            findPerson();
        }
        else if (Integer.parseInt(input) == 3){
            delPerson();
        }
        else{
            System.exit(0);
        }
        
        
        



        
    }
    
}
