package OOPHW03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


// Описал абстрактный класс сотрудника Worker,
// который в дальнейшем может использоваться,
// как шаблон для создания специальностей сотрудников
abstract class Worker{
    int age;
    int salary;
    String name;

    public Worker(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

}

//Описал класс Разработчик на основе абстрактного
// класса
class Developer extends Worker{
    Developer(int age, int salary, String name){
        super(age, salary, name);
    }
}

//Описал класс сотрудник
class Employee{
    Worker worker;

// Метод с помощью которого я выбираю
// с какой должностью я работаю
    void setWorker(Worker worker){
        this.worker = worker;
    }

    Format format;

//Этот метод позволяет мне выбрать формат сохранения
    public void setFormat(Format format){
        this.format = format;
    }
//Этот метод является той самой кнопкой сохранения
    public void click(){
        format.saveAs(worker);
    }
}

// Описал интерфейс
interface Format{
    // Объявил метод
    void saveAs(Worker worker);
}

class Xml implements Format{
    //Переопределяю метод saveAs 
    @Override
    public void saveAs(Worker worker){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("text.html")))) {
            writer.write("<xml>\n<Worker>\n<age>"+worker.age+"</age>\n</xml>"); // Здесь я пытался сохранить как Xml.
            writer.close();
        } catch (IOException e){
            System.exit(0);
        }
    }
}

class Markdown implements Format{
    //Переопределяю метод saveAs
    @Override
    public void saveAs(Worker worker){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("text.md")))) {
            writer.write("#Woeker\n*age"+worker.age); // Здесь я пытался сохранить как Markdown. 
            writer.close();
        } catch (IOException e){
            System.exit(0);
        }
    }
}


/**
 * OopHw03
 */
public class OopHw03 {

    public static void main(String[] args) {
        Employee woman = new Employee();
        woman.setWorker(new Developer(26, 10000, "Don")); //Тут мы сотруднику даем должность
        woman.setFormat(new Markdown()); //Тут мы выбираем в каком формате его сохранять
        woman.click();//Тут происходит магия сохранения
    }
}