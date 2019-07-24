import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] argc) {
        int array1[] = {89, 22, 33, 16, 9, 99, 65, 28, 12, 55};
        arrprint(array1);
        //реверс элементов массива
        reverseArray(array1);
        arrprint(array1);
        extremInd(array1);
        //экстремальные значения
        System.out.println(Arrays.toString(extremInd(array1)));

        int array2[] = {1, 3, 6, 3, 9};
        //среднеарифметическое, среднегеометрическое
        System.out.println(Arrays.toString(midArifGeo(array2)));
        arrprint(array2);
        //проверка отсортированности массива
        checkArray(array2);
        arrprint(array2);
        System.out.println(checkArray(array2));
        //локальный минимум
        System.out.println(localExtremMin(array2));
        //binary search
        int array3[] = {1, 3, 4, 5, 9, 12, 16, 19, 28, 33};

        System.out.println(binarySearch(array3, 16));
        System.out.println(linearSearch(array3, 16));



    }

    //экстремальные значения
    //complexity of algorithm - O(N)
    public static int[] extremInd(int[] arr) {
        int maxValue = arr[0];
        int maxInd = -1;
        int minValue = arr[0];
        int minInd = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxInd = i;
            }
            if (arr[i] < minValue) {
                minValue = arr[i];
                minInd = i;
            }
        }
        int[] extrems = {maxInd, minInd};
        return extrems;

    }

    //среднеарифметическое, среднегеометрическое
    //complexity of algorithm - O(N)
    public static double[] midArifGeo(int[] arr) {

        double summ = 0;
        double mult = 1;
        for (int i = 0; i < arr.length; i++) {
            summ += arr[i];
            mult *= arr[i];
        }
        double midArif = summ / arr.length;
        double midGeo = Math.pow(mult, 1.0 / arr.length);
        double[] ariGeo = {midArif, midGeo};

        return ariGeo;
    }


      //реверс элементов массива
      //complexity of algorithm - O(N)
    public static int[] reverseArray(int[] arr) {
        int halfsize = arr.length/2;
        int size = arr.length-1;     // i[arr.lenght] - out of bounds exeption
        int temp = 0;
        for (int i = 0; i <= halfsize; i++){

            temp = arr[size];
            arr[size] = arr[i];
            arr[i] = temp;
            size--;
        }
        return arr;
    }
    //проверка отсортированности массива
    //complexity of algorithm - O(N)
    public static boolean checkArray(int[] arr) {
        boolean isSortedUp = true;

        for (int i = 1; i<arr.length; i++){
            if (arr[i-1]>arr[i]){//for checking decreasing sequence change to(arr[i-1]<arr[i])
                isSortedUp = false;
                break;
            }
        }
        return isSortedUp;
    }

    //локальный минимум/максимум
    public static int localExtremMin(int[] arr){
        int localmin = -1;
        for (int i = 1; i < arr.length-1; i++){
            if (arr[i-1]>arr[i]&& arr[i]< arr[i+1]){ // for local maximums change (arr[i-1]<arr[i]&& arr[i]> arr[i+1])
                localmin = i;
                break;
            }
        }
        return localmin;
    }

    //binary Search
    //complexity of algorithm - O= log N
    public static int binarySearch(int[] arr, int num1){
        int low = 0;
        int size = arr.length-1;
        int high = arr.length;

        while(low < high){
            int middle = (low+high)/2;
            if(num1==arr[middle]){
                return middle;

            }
            else if (num1<arr[middle]){
                high=middle-1;
            }
            else if (num1>arr[middle]){
                low=middle+1;
            }
        }
        return 0;
    }

    //linear search
    //complexity of algorithm - O(N)
    public static int linearSearch(int[] arr, int num1){

        for (int i = 0; i<arr.length; i++){
            if (arr[i] == num1){
                return i;
            }
        }
        return 0;
    }


        public static void arrprint ( int[] arr){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

            }
            System.out.println(" ");

        }

        public static void selectionSort ( int[] arr){

            for (int i = 0; i < arr.length; i++) {

                int min = arr[i];
                int minidex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                        minidex = j;
                    }
                }
                if (i != minidex) {
                    int buf = arr[i];
                    arr[i] = arr[minidex];

                    arr[minidex] = buf;
                }
            }

        }

        public static void bubbleSort ( int[] arr){
            int buf = 0;
            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] < arr[i + 1]) {
                        isSorted = false;
                        buf = arr[i];
                        arr[i] = arr[i + 1];

                        arr[i + 1] = buf;
                    }

                }
            }
        }

        public static void insertionSort ( int[] arr){
            for (int i = 1; i < arr.length; i++) {
                int firstElem = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > firstElem) {//sorted part of array;
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = firstElem;//shifting to the unsorted part
            }
        }

}
