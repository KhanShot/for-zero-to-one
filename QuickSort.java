import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = (int)(Math.random()*50);
        }
        int lowIndex = 0;
        int HighIndex = nums.length-1;
        System.out.println("It is QUICK");
        System.out.println("Before: "+Arrays.toString(nums));
        quick(nums,lowIndex,HighIndex);
        System.out.println("After: "+ Arrays.toString(nums));
    }
    public static void quick(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        int middle = arr[0];
        int root = 4;


        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < root) {
                System.out.println(Arrays.toString(arr));
                i++;
            }
            while (arr[j] > root) {
                System.out.println(Arrays.toString(arr));
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quick(arr, low, j);

        if (high > i)
            quick(arr, i, high);
    }
}