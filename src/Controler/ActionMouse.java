package Controler;

import Views.Main;
import Views.SudokuFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionMouse implements MouseListener {

    private Main sudoku;
    private SudokuFrame sudokuFrame;

    public ActionMouse(Main sudoku, SudokuFrame sudokuFrame) {
        this.sudoku = sudoku;
        this.sudokuFrame = sudokuFrame;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        me.getComponent().setBackground(new Color(153, 204, 255));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        me.getComponent().setBackground(Color.white);
    }

}
