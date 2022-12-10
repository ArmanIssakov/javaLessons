package HW05;
import javax.swing.JOptionPane;
public class hw05 {
    static int triangle(int n){
        n = ((n + 1)*n)/2;
        return n;
    }
    static void showTriangle(){
        String inputText = JOptionPane.showInputDialog(null,
        "Вычислить треугольное число\n для числа:",
        "Треуголное число", JOptionPane.QUESTION_MESSAGE);
        int num = Integer.parseInt(inputText);
        num = triangle(num);
        String answer = String.format("Треугольным числом, числа %s\nявляется число %s", inputText, num);
        JOptionPane.showMessageDialog(null,answer ,"Результат",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        showTriangle();
        System.exit(0);
    }
    
}
