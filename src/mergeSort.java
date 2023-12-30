import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class mergeSort {
    public static void conquer(int[] arr, int st, int mid, int end){
        int[] merged = new int[end - st + 1];
        int idx1 = st;
        int idx2 = mid+1;
        int i = 0;

        while(idx1 <= mid && idx2 <= end){
            if(arr[idx1] < arr[idx2]){
                merged[i++] = arr[idx1++];
            }
            else{
                merged[i++] = arr[idx2++];
            }
        }

        while(idx1 <= mid){
            merged[i++] = arr[idx1++];
        }

        while(idx2 <= end){
            merged[i++] = arr[idx2++];
        }

        for (int j : merged) {
            arr[st++] = j;
        }

    }
    public static void divide(int[] arr, int st, int end){
        if(st >= end) return;

        int mid = (st + end)/2;
        divide(arr, 0, mid);
        divide(arr, mid+1, end);
        conquer(arr, st, mid ,end);
    }

    public static long[] calculateRunTimeOnRandomArray(int n){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int startRange = 1;
        int endRange = 25;

//        int n = random.nextInt(endRange - startRange + 1 ) + startRange;
//        System.out.println("The random number is: " + n);

        int[] inputArr = new int[n];


        for(int i = 0; i < n; i++){
            inputArr[i] = random.nextInt(endRange - startRange + 1 ) + startRange;
        }

//        System.out.println("The random array is: ");
//        for(int item: inputArr){
//            System.out.print(item + " ");
//        }
//        System.out.println("\n");

        long startTime = System.nanoTime();

        divide(inputArr, 0, n-1);

        long endTime = System.nanoTime();

        System.out.println("The total time taken is: " +(endTime - startTime)/1_000);

//        System.out.println("The sorted array is: ");
//        for(int ele : inputArr){
//            System.out.print(ele + " ");
//        }
        return new long[]{(endTime - startTime)/2, n};
    }

    public static void main(String[] args) {
        Map<Long, Long> mp = new HashMap<>();
        int n = 10;

        for(int i = 1; i <= n; i++){
            long[] runtime = calculateRunTimeOnRandomArray(i);
            mp.put(runtime[1], runtime[0]);
        }

        for(Map.Entry<Long, Long> entry : mp.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}