import java.util.Scanner;

public class HeapSort {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int cur, int n) {
        int idxOfLargest = cur;
        int l = 2 * idxOfLargest + 1;
        int r = 2 * idxOfLargest + 2;

        if (l < n && arr[idxOfLargest] < arr[l]) {
            idxOfLargest = l;
        }

        if (r < n && arr[idxOfLargest] < arr[r]) {
            idxOfLargest = r;
        }

        if (idxOfLargest != cur) {
            swap(arr, cur, idxOfLargest);
            heapify(arr, idxOfLargest, n);
        }
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public static void heapSort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        buildHeap(arr, n);
        heapSort(arr, n);

        // print
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
