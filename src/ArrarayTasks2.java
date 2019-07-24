import java.util.Arrays;
public class ArrarayTasks2 {
    public static void main(String[] argc) {
        int array1[][] = {{89, 22, 33, 16, 9, 99, 65, 28, 12, 55}, {11, 122, 96, 87, 43, 76, 22, 66, 5, 38}};

        int array2[][] = {{0, 1, 3, 4}, {1, 0, 4, 5}, {3, 4, 0, 6}, {4, 5, 6, 0}};//square symmetrical by main diagonal
        int array3[][] = {{0, 3, 2, 1}, {4, 6, 1, 2}, {5, 1, 6, 3}, {1, 5, 4, 0}};//square symmetrical by side diagonal
        printArr(array1);
        minMaxValue(array1);
        midArifGeo(array1);
        System.out.println(simmetryCheckMain(array2));
        System.out.println(simmetryCheckSide(array3));
        //транспонирование матрицы
        arrTranspond(array3);
        int array4[][] = {{3, 3, 1, 3}, {3, 6, 1, 3}, {5, 3, 2, 3}, {1, 5, 4, 3}};
        System.out.println(localExtremMin(array4));

    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //экстремальные значения
    //complexity of algorithm - O(N^2)
    public static void minMaxValue(int arr[][]) {
        int min = arr[0][0];
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {

            for (int j = 1; j < arr[i].length; j++) {

                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        System.out.println("max value is " + max + " min value is" + min);
    }

    //среднеарифметическое среднегеометрическое
    //complexity of algorithm - O(N^2)
    public static void midArifGeo(int arr[][]) {
        int summ = 0;
        int mult = 1;
        int amount = 0;//for counting number of elements

        for (int i = 0; i < arr.length; i++) {


            for (int j = 1; j < arr[i].length; j++) {

                summ += arr[i][j];
                mult *= arr[i][j];
            }
            amount += arr[i].length;
        }
        double midArif = summ;
        double midGeo = Math.pow(mult, 1.0 / amount);
        System.out.println("arithmetical mean is " + midArif + " geometrical mean " + midGeo);
    }

    // симметричность матрицы относительно главной диагонали
    //complexity of algorithm - O(N^2)
    public static boolean simmetryCheckMain(int arr[][]) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i])
                    return false;
            }
        }
        return true;
    }

    //побочной
    public static boolean simmetryCheckSide(int arr[][]) {
        int n = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[n - j][n - i])
                    return false;
            }
        }
        return true;

    }


    //локальный минимум
    //complexity of algorithm - O(N^2)
    public static int localExtremMin(int arr[][]){
        int localmin = arr [0][0];
        for (int i = 1; i < arr.length-1; i++){
            for (int j = 1; i<arr[i].length-1; j++){

            if (arr[i][j] < arr[i+1][j] &&
                    arr[i][j] < arr[i-1][j] &&
                    arr[i][j] < arr[i][j+1] &&
                    arr[i][j] < arr[i][j-1])
                localmin = arr[i][j];
                return localmin;
                }
            }
        return localmin;
    }




    //транспонирование матрицы
    //complexity of algorithm - O(N^2)
    public static void arrTranspond(int arr[][]) {
        int n = arr.length - 1;

        printArr(arr);
        System.out.println(" ");
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int temp = arr[i][j];// for saving data without using additional array
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }

        }
        printArr(arr);
    }
}
