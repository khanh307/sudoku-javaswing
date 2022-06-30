package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SudokuSolver {

    private int[][] board;
    private RandomSudoku random;
    private float level;

    public SudokuSolver(int n) {
        board = new int[n][n];
        random = new RandomSudoku();
        board = random.randomOneRow(n);
    }

    //Kiểm tra hợp lệ trả về true, ko trả vê false
    public boolean isSafe(int row, int col, int num) {
        //Kiểm tra hàng
        for (int d = 0; d < board.length; d++) {
            //if trong hàng tồn tại num return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        //Kiểm tra cột
        for (int r = 0; r < board.length; r++) {
            //if trong cột tồn tại num trả về false
            if (board[r][col] == num) {
                return false;
            }
        }

        //Kiểm tra khối
        int sizeBox = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sizeBox;
        int boxColStart = col - col % sizeBox;
        //Duyệt qua khối
        for (int h = boxRowStart; h < boxRowStart + sizeBox; h++) {
            for (int c = boxColStart; c < boxColStart + sizeBox; c++) {
                if (board[h][c] == num) {
                    return false;
                }
            }
        }

        //if num không tồn tại trong board trả về true
        return true;
    }

    //Giải sudoku
    public boolean solverSudoku(int length) {
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        //duyệt qua mảng board
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //if [i,j] chưa có số
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    //đánh dấu có ô trống và break
                    isEmpty = true;
                    break;
                }
            }
            //Nếu có ô trống thoát ra 
            if (isEmpty) {
                break;
            }
        }

        //nếu ko có ô trống thoát - đã điền hết
        if (!isEmpty) {
            return true;
        }

        //Ngược lại duyệt qua từ 1 đến số lớn nhất được điền vào 
        for (int num = 1; num <= length; num++) {
            //Nếu num hợp lệ
            //Đưa num vào board và đệ quy
            if (isSafe(row, col, num)) {
                board[row][col] = num;
                boolean check = solverSudoku(length);
                //Nếu tìm được trả về true;
                //Ngược lại nến điền num mà các ô số sau ko điền được thì gán lại 
                if (check) {
                    return true;
                } else {
                    board[row][col] = 0; // replace it
                }
            }
        }
        return false;
    }

    public void setLevel(float level) {
        this.level = level;
    }
    
    public void setBoard(int[][] board) {
        this.board = board;
        this.board = random.randomOneRow(board.length);
    }

    public void testBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public float getLevel() {
        return level;
    }

}
