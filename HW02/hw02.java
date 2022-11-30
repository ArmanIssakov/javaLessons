package HW02;

public class hw02 {

    static int[] mergeSort(int[] array) {
        int arrLenght = array.length;
        if (arrLenght == 1) {
            return array;
        }
        int arrMid = array.length / 2;
        int[] arrL = new int[arrMid];
        int[] arrR = new int[arrLenght - arrMid];
        for (int i = 0; i < arrMid; i++) {
            arrL[i] = array[i];
        }
        for (int i = 0; i < arrLenght - arrMid; i++) {
            arrR[i] = array[i + arrMid];
        }
        mergeSort(arrL);
        mergeSort(arrR);
        return array = merge(array, arrL, arrR);
    }

    static int[] merge(int[] array, int[] arrL, int[] arrR) {
        int left = arrL.length;
        int right = arrR.length;
        int l = 0;
        int r = 0;
        int a = 0;
        while (l < left && r < right) {
            if (arrL[l] < arrR[r]) {
                array[a] = arrL[l];
                l++;
                a++;
            } else {
                array[a] = arrR[r];
                r++;
                a++;
            }
        }
        for (int l2 = l; l2 < left; l2++) {
            array[a++] = arrL[l2];
        }
        for (int r2 = r; r2 < right; r2++) {
            array[a++] = arrR[r2];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] { 5, 6, 4, 19, 8, 9, 65 };
        int[] result = mergeSort(testArr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
