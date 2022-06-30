package Controler;

import Views.SudokuFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimerListener {

    private int elapsedTime = 0;
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private String hours_string;
    private String minutes_string;
    private String seconds_string;
    private SudokuFrame sudoku;

    public TimerListener(SudokuFrame sudoku) {
        this.sudoku = sudoku;
    }

    Timer time = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;

            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            sudoku.getLbTime().setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

    public void start() {
        
        time.start();
        
    }

    
    
    public void reset() {
        time.restart();
        hours = 0;
        minutes = 0;
        seconds = 0;
        elapsedTime = 0;
    }

    public void close() {
        time.stop();
    }

    public void keeping() {
        time.restart();
    }

    public String getHours_string() {
        return hours_string;
    }

    public String getMinutes_string() {
        return minutes_string;
    }

    public String getSeconds_string() {
        return seconds_string;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public boolean running() {
        return time.isRunning();
    }
}
