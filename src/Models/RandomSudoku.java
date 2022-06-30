package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomSudoku {

    private static Random rand;

    public RandomSudoku() {
        rand = new Random();
    }
    //random 1 hàng
    public static int[][] randomOneRow(int n) {
        int[][] board = new int[n][n];
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (Integer i = 1; i < n + 1; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int j = 0; j < n; j++) {
            board[0][j] = numbers.get(j);

        }
        return board;
    }
    //random 1 số
    public static int randomNum(int max, int min) {
        int num = rand.nextInt((max - min) + 1) + min;
        return num;
    }
    
    //Random vị trí xuất hiện của ô số
    public static int[] randomIndex(int num, int length) {
        
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {

            int row = rand.nextInt(length);
            if (!checkArray(A, i, row)) {
                A[i] = row;
            } else {
                i--;
            }

        }
        return A;
    }

    
    private static boolean checkArray(int A[], int n, int row) {
        for (int i = 0; i < n; i++) {
            if (A[i] == row) {
                return true;
            }

        }
        return false;
    }
    
  
 

}
