/*+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. 
Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000 */

package HW01;

import java.io.*;

class LibraryHW1 {
    static String str, ares, bres;
    static String res = "";

    static String returnStr(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((str = br.readLine()) != null) {
            res = res + str;
        }
        res = res.replace(" ", "");
        return res;
    }

    static String powAB(int a, int b) {
        String answer;
        if (b < 0) {

            answer = String.format("%s в степени %s = %.2f", a, b, Math.pow(a, b));

        } 
        else if((b == 0)&(a == 0)){
            answer = String.format("%s в степени %s = не определено", a, b);
        }
        else {
            int result = (int) Math.pow(a, b);
            answer = String.format("%s в степени %s = %s", a, b, result);
        }
        return answer;
    }
    static void outputData(String data, String path) {
        try (FileWriter fw = new FileWriter(path, false)) {
            fw.write(data);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
}

public class hw01 {
    public static void main(String[] args) throws IOException {
        String res = LibraryHW1.returnStr("input.txt");
        int start = res.indexOf("b");
        int end = res.indexOf("a");
        int lenghtRes = res.length();
        String bres = res.substring((start + 1), end);
        String ares = res.substring((end + 1), lenghtRes);
        int numA = Integer.parseInt(ares);
        int numB = Integer.parseInt(bres);
        // int result = (int) Math.pow(numA,numB);
        String result = LibraryHW1.powAB(numA, numB);
        LibraryHW1.outputData(result, "output.txt");

        System.out.println(result);

    }

}