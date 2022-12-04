package HW03;
import javax.swing.JOptionPane;

public class hw03 {
    static int[] inputText(){
        String inputText = JOptionPane.showInputDialog(null,
        "Введите числа a, b, c, d через \n запятую как показано на приметре:\n22,333,3,1",
        "Окно для ввода чисел", JOptionPane.QUESTION_MESSAGE);
        if(inputText == null){
            System.exit(0);
        }
        String[] digits = inputText.split(",");
        int a = Integer.parseInt(digits[0]);
        int b = Integer.parseInt(digits[1]);
        int c = Integer.parseInt(digits[2]);
        int d = Integer.parseInt(digits[3]);
        int[] aBCD = new int[]{a,b,c,d};
        return aBCD;
    }
    static String howWay(int[] array){
        long[] resultArray = new long[array[1]+1];
        resultArray[array[0]] = 1;
        int i = 0;
        while(i <= array[1]){
            if(i % array[2] == 0 && i / array[2] > 0){
                resultArray[i] += resultArray[i / array[2]];
            }
            if(i > array[0] && i - array[3] > 0){
                resultArray[i] += resultArray[i - array[3]];
            }
            i++;
        }
        String resultText = Long.toString(resultArray[array[1]]) ;
        return resultText;
    }
    static void showMe(String text){
        JOptionPane.showMessageDialog(null, text,
        "Количество программ",
        JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        String showMe = howWay(inputText());
        showMe(showMe);
    }

    
    
}
