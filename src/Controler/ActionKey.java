package Controler;

import Views.SudokuFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionKey implements KeyListener{
    private SudokuFrame sudokuFrame;

    public ActionKey(SudokuFrame sudokuFrame) {
        this.sudokuFrame = sudokuFrame;
    }  
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        sudokuFrame.txtKeyPressed(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
    
}
