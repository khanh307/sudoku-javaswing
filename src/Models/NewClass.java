/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Random;

/**
 *
 * @author Microsoft Windows
 */
public class NewClass {

    private static Random rand = new Random();

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

    public static int[][] arrayIndex(int max, int min) {
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            int num = randomNum(max, min);

            int[] A = new int[num];
            A = randomIndex(num, 9);
            for (int j = 0; j < num; j++) {
                board[i][A[j]] = 1;
            }
        }

        return board;
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9];
        NewClass rand = new NewClass();
        board = rand.arrayIndex(7, 5);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
