package OOPHW05;

import java.io.IOException;

import javax.swing.JOptionPane;

public class View extends JOptionPane {
    public void click() throws IOException{
        

        Model model = new Model();

        model.loadPhoneBook();
        
        int answer = Integer.parseInt(showInputDialog(null, "Выберите номер пункта:\n1.Найти контакт\n2.Добавить контакт"));
        if(answer == 1){
            model.findContactOfPhonebook();
        } else if(answer == 2){
            model.addContactOfPhonebook();
        } else{
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        View obj = new View();
        obj.click();
    }
}
