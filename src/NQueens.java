import java.util.ArrayList;
import java.util.Scanner;

public class NQueens {
    public static boolean isSafe(char[][] board, int row, int col, int n){
        // rows
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // cols
        for(int c = 0; c < n; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        // upper left c-1 r-1
        int r = row;
        for(int c = col; c >= 0 && r >= 0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right r-1 c+1
        r = row;
        for(int c = col; c < n && r >= 0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left r+1 c-1
        r = row;
        for(int c = col; c >= 0 && r < n; c--, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower right r+1 c+1
        r = row;
        for(int c = col; c < n && r < n; c++, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static char[][] cloneBoard(char[][] board){
        char[][] copy = new char[board.length][board.length];

        for(int i =0 ; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                copy[i][j] = board[i][j];
            }
        }

        return copy;
    }
    public static void nQueens(int n, char[][] board, ArrayList<char[][]> boards, int col ){
            if(col == n){
                boards.add(cloneBoard(board));
                return;
            }

        for(int row = 0; row < n; row++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q'; // place the queen at row, col
                nQueens(n, board, boards, col+1); // next col
                // backtrack
                board[row][col] = '.';
            }
        }



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int n = scanner.nextInt(); // size of the board
        ArrayList<char[][]> boards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(n, board, boards, 0);

        for(char[][] b : boards){
            for(int i =0 ; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("------");
        }
    }
}
