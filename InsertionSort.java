import java.util.Arrays;

public class InsertionSort {
    static int j;
    public static void main(String[] args) {
        int arr[] = new int[5
                ];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random()*50);
        System.out.println("It is INSERTION");

        System.out.println("Before: "+ Arrays.toString(arr));
        inserted(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    public static void inserted (int[] array){
        for (int i = 1; i <array.length ; i++) {
            int temp= array[i];

            for (j = i-1; j >=0 && temp < array[j] ; --j) {
                array[j + 1] = array[j];
                System.out.println(Arrays.toString(array));
            }
            array[j+1] = temp;
        }
    }
}
