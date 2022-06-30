package Views;

import Controler.ActionButton;
import Controler.ActionMouse;
import Controler.TimerListener;
import Models.DataSudoku;
import Models.SudokuSolver;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    private JButton btnContinue;
    private JButton btnEasy;
    private JButton btnHard;
    private JButton btnMedium;
    private JButton btnSHard;
    private JLabel lbBackground;
    private JPanel panel;
    private SudokuFrame sudokuFrame;
    private SudokuSolver sudokuSolver;
    private TimerListener timer;
    private String[][] champion = new String[4][2];

    public Main() {
        initComponents();
    }

    private void initComponents() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        panel = new javax.swing.JPanel();
        btnContinue = new javax.swing.JButton();
        btnEasy = new javax.swing.JButton();
        btnHard = new javax.swing.JButton();
        btnMedium = new javax.swing.JButton();
        btnSHard = new javax.swing.JButton();
        lbBackground = new javax.swing.JLabel();
        sudokuFrame = new SudokuFrame(this);
        sudokuSolver = new SudokuSolver(9);

        ActionButton action = new ActionButton(this, sudokuFrame);
        ActionMouse actionMouse = new ActionMouse(this, sudokuFrame);
        timer = new TimerListener(sudokuFrame);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SUDOKU");
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);

        panel.setBackground(new java.awt.Color(153, 255, 255));
        panel.setLayout(null);

        btnContinue.setBackground(new java.awt.Color(255, 255, 255));
        btnContinue.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnContinue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/icons8-continue-54.png")));
        btnContinue.setText("Tiếp tục");
        btnContinue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContinue.setPreferredSize(new java.awt.Dimension(300, 100));
        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnContinue);
        btnContinue.setBounds(300, 210, 200, 60);
        btnContinue.addActionListener(action);
        btnContinue.addMouseListener(actionMouse);

        btnEasy.setBackground(new java.awt.Color(255, 255, 255));
        btnEasy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEasy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Easy.png"))); // NOI18N
        btnEasy.setText("Dễ");
        btnEasy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEasy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEasy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnEasy);
        btnEasy.setBounds(300, 290, 200, 60);
        btnEasy.addActionListener(action);
        btnEasy.addMouseListener(actionMouse);

        btnHard.setBackground(new java.awt.Color(255, 255, 255));
        btnHard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Hard.png"))); // NOI18N
        btnHard.setText("Khó");
        btnHard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnHard);
        btnHard.setBounds(300, 450, 200, 60);
        btnHard.addActionListener(action);
        btnHard.addMouseListener(actionMouse);

        btnMedium.setBackground(new java.awt.Color(255, 255, 255));
        btnMedium.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMedium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Medium.png"))); // NOI18N
        btnMedium.setText("Trung bình");
        btnMedium.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMedium.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnMedium);
        btnMedium.setBounds(300, 370, 200, 60);
        btnMedium.addActionListener(action);
        btnMedium.addMouseListener(actionMouse);

        btnSHard.setBackground(new java.awt.Color(255, 255, 255));
        btnSHard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSHard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/SHard.png"))); // NOI18N
        btnSHard.setText("Cực khó");
        btnSHard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnSHard);
        btnSHard.setBounds(300, 530, 200, 60);
        btnSHard.addActionListener(action);
        btnSHard.addMouseListener(actionMouse);

        lbBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/background_1.png"))); // NOI18N
        panel.add(lbBackground);
        lbBackground.setBounds(0, 0, 800, 700);
        this.setResizable(false);
        this.getContentPane().add(panel);
        panel.setBounds(0, 0, 800, 700);

        ImageIcon img = new ImageIcon(getClass().getResource("/Views/Image/icons8-sudoku-70.png"));
        this.setIconImage(img.getImage());

        loadGame();

    }

    public void loadGame() {
        DataSudoku data = new DataSudoku();

        if (data.readGui()) {
            champion[0][0] = data.getEasy().split(",")[0];
            champion[0][1] = data.getEasy().split(",")[1];
            champion[1][0] = data.getMedium().split(",")[0];
            champion[1][1] = data.getMedium().split(",")[1];
            champion[2][0] = data.getDiff().split(",")[0];
            champion[2][1] = data.getDiff().split(",")[1];
            champion[3][0] = data.getSDiff().split(",")[0];
            champion[3][1] = data.getSDiff().split(",")[1];
        } else {
            champion[0][0] = "Dễ";
            champion[0][1] = "Chưa có";
            champion[1][0] = "Trung bình";
            champion[1][1] = "Chưa có";
            champion[2][0] = "Khó";
            champion[2][1] = "Chưa có";
            champion[3][0] = "Cực khó";
            champion[3][1] = "Chưa có";
        }

        float temp = sudokuFrame.checkFile();
        if (temp == 0) {
            btnContinue.setEnabled(false);
        } else {
            btnContinue.setEnabled(true);
            if (temp == (float) 9.1) {
                sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[0][1]);
            } else if (temp == (float) 9.2) {
                sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[1][1]);
            } else if (temp == (float) 9.3) {
                sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[2][1]);
            } else if (temp == 16) {
                sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[3][1]);
            }
        }
    }

    public void actionBtnContinue() {
        float level = sudokuFrame.setFile();
        sudokuSolver.setLevel(level);
        this.setVisible(false);
        sudokuFrame.setVisible(true);

        DataSudoku data = new DataSudoku();
        data.deleteFile();
    }

    public void actionBtnEasy() {
        this.setVisible(false);
        sudokuFrame.setVisible(true);
        sudokuFrame.setSize(850, 700);
        float level = (float) 9.1;
        sudokuFrame.panelSudoku((int) level);

        sudokuSolver.setLevel(level);
        sudokuSolver.setBoard(new int[9][9]);
        sudokuSolver.solverSudoku((int) level);

        sudokuFrame.setBoard(sudokuSolver.getBoard());
        sudokuFrame.setTextBtn(1);
        sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[0][1]);
        timer.start();

    }

    public void actionBtnMedium() {
        this.setVisible(false);
        sudokuFrame.setVisible(true);
        sudokuFrame.setSize(850, 700);
        float level = (float) 9.2;
        sudokuFrame.panelSudoku((int) level);

        sudokuSolver.setLevel(level);
        sudokuSolver.setBoard(new int[9][9]);
        sudokuSolver.solverSudoku((int) level);
        sudokuSolver.solverSudoku((int) level);

        sudokuFrame.setBoard(sudokuSolver.getBoard());
        sudokuFrame.setTextBtn(2);
        timer.start();
        sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[1][1]);
    }

    public void actionBtnHard() {
        this.setVisible(false);
        sudokuFrame.setVisible(true);
        sudokuFrame.setSize(850, 700);
        float level = (float) 9.3;
        sudokuFrame.panelSudoku((int) level);

        sudokuSolver.setLevel(level);
        sudokuSolver.setBoard(new int[9][9]);
        sudokuSolver.solverSudoku((int) level);
        sudokuFrame.setBoard(sudokuSolver.getBoard());
        sudokuFrame.setTextBtn(3);
        timer.start();
        sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[2][1]);
    }

    public void actionBtnSHard() {
        this.setVisible(false);
        sudokuFrame.setVisible(true);
        sudokuFrame.setSize(1100, 810);
        float level = 16;
        sudokuFrame.panelSudoku((int) level);

        sudokuSolver.setLevel(level);
        sudokuSolver.setBoard(new int[16][16]);
        sudokuSolver.solverSudoku((int) level);
        sudokuSolver.solverSudoku((int) level);
        sudokuFrame.setBoard(sudokuSolver.getBoard());
        sudokuFrame.setTextBtn(4);
        timer.start();
        sudokuFrame.getLbRecord().setText("Kỷ lục: " + champion[3][1]);
    }

    public JButton getBtnContinue() {
        return btnContinue;
    }

    public TimerListener getTimer() {
        return timer;
    }

    public SudokuSolver getSudokuSolver() {
        return sudokuSolver;
    }

    public String[][] getChampion() {
        return champion;
    }

    public void setChampion(int i, int j, String str) {
        this.champion[i][j] = str;
    }

    public boolean isSafe(int row, int col, int num) {
        return sudokuSolver.isSafe(row, col, num);
    }

    public static void main(String[] args) {

        Main sudoku = new Main();
        sudoku.setVisible(true);
    }

}
