import java.util.Scanner;

public class mergeSort2 {

    public static void conquer(int[] arr, int st, int mid, int end){
        int[] merged = new int[end - st + 1];
        int idx1 = st;
        int idx2 = mid+1;
        int idx = 0;

        while(idx1 <= mid && idx2 <= end){
            if(arr[idx1] < arr[idx2]){
                merged[idx++] = arr[idx1++];
            }else{
                merged[idx++] = arr[idx2++];
            }
        }

        while(idx1 <= mid){
            merged[idx++] = arr[idx1++];
        }

        while(idx2 <= end){
            merged[idx++] = arr[idx2++];
        }

        for(int ele : merged){
            arr[st++] = ele;
        }

    }
    public static void divide(int[] arr, int st, int end){

        if(st >= end) return;

        int mid = (st + end)/2; // st + (end-st)/2;
        divide(arr, st, mid);
        divide(arr, mid+1, end);

        conquer(arr,st,mid,end);

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];

        for(int i = 0; i < n; i++){
            input[i] = scanner.nextInt();
        }

        divide(input, 0, n-1);
        for(int ele : input){
            System.out.print(ele + " ");
        }
    }
}
