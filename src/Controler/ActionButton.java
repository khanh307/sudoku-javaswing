
package Controler;

import Views.Main;
import Views.SudokuFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionButton implements ActionListener {

    private Main sudoku;
    private SudokuFrame sudokuFrame;

    public ActionButton(Main sudoku, SudokuFrame sudokuFrame) {
        this.sudoku = sudoku;
        this.sudokuFrame = sudokuFrame;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        if (action.equals("Dễ")) {
            sudoku.actionBtnEasy();
        } else if (action.equals("Trung bình")) {
            sudoku.actionBtnMedium();
        } else if (action.equals("Khó")) {
            sudoku.actionBtnHard();
        } else if (action.equals("Cực khó")) {
            sudoku.actionBtnSHard();
        } else if (action.equals("Ván mới")) {
            sudokuFrame.actionBtnNew();
        } else if (action.equals("Tiếp tục")) {
            sudoku.actionBtnContinue();
        } else if (action.equals("Dừng")) {
            sudokuFrame.actionBtnPause();
        } else if (action.equals("Kiểm tra")) {
            sudokuFrame.actionBtnCheck();
        } else if (action.equals("Giải")) {
            sudokuFrame.actionBtnSolver();
        } else if (action.equals("Xóa")) {
            sudokuFrame.actionBtnClear();
        } else {
            sudokuFrame.btnActionPerformed(ae);
        }

    }

}
