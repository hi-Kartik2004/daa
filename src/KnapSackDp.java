import java.util.Scanner;

public class KnapSackDp {

    static int knapSack(int[] weights, int[] values, int capacity, int n){
        int[][] dp = new int[n+1][capacity+1];

        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= capacity; w++){
                if(i == 0 || w== 0){
                    dp[i][w] = 0;
                }else if(weights[i-1] <= w){
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w - weights[i-1]], dp[i-1][w]);
                }else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        for(int i = 0 ; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][capacity];

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of weights: ");
        int n = scanner.nextInt();

        System.out.println("Enter the capacity of the knapSack");
        int capacity = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i = 0; i < n; i++){
            weights[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            values[i] = scanner.nextInt();
        }

        int maxValue = knapSack(weights, values,  capacity,  n);
        System.out.println("The max values in the given knapsack is: " + maxValue);


    }
}
