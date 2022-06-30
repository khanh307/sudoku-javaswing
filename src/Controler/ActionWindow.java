package Controler;

import Views.SudokuFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionWindow implements WindowListener{
    private SudokuFrame sudokuFrame;

    public ActionWindow(SudokuFrame sudokuFrame) {
        this.sudokuFrame = sudokuFrame;
    }    
    
    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
        this.sudokuFrame.formWindowClosing();
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
      
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
       
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
    
}
