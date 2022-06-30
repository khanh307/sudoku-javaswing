package Views;

import Controler.ActionButton;
import Controler.ActionKey;
import Controler.ActionMouse;
import Controler.TimerListener;
import Controler.ActionWindow;
import Models.DataSudoku;
import Models.RandomSudoku;
import Models.SudokuSolver;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class SudokuFrame extends javax.swing.JFrame {

    private JButton btnCheck;
    private JButton btnNew;
    private JButton btnSolver;
    private JButton btnClear;
    private JButton btnPause;
    private JLabel lbText;
    private JLabel lbCheck;
    private JLabel lbRecord;
    private JLabel lbTime;
    private JPanel panelLeft;
    private JPanel panelRight;
    private SudokuPanel sPanel;
    private JButton[][] btn;
    private int I, J;
    private Main sudoku;
    private String txt = "";
    private int[][] board;
    private RandomSudoku random;
    private PanelPause pause;
    private ActionButton action;
    private ActionKey actionKey;
    private DataSudoku data;

    public SudokuFrame(Main sudoku) {
        initComponents();
        this.sudoku = sudoku;

    }

    //Khởi tạo Frame
    private void initComponents() {
        panelLeft = new JPanel();
        panelRight = new JPanel();
        btnCheck = new JButton();
        btnSolver = new JButton();
        btnNew = new JButton();
        btnClear = new JButton();
        btnPause = new JButton();
        lbCheck = new JLabel();
        lbText = new JLabel();
        lbRecord = new JLabel();
        lbTime = new JLabel();

        data = new DataSudoku();
        action = new ActionButton(sudoku, this);
        actionKey = new ActionKey(this);
        ActionWindow winAction = new ActionWindow(this);
        ActionMouse actionMouse = new ActionMouse(sudoku, this);

        this.addWindowListener(winAction);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SUDOKU");

        BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS);
        this.getContentPane().setLayout(layout);

        panelLeft.setPreferredSize(new java.awt.Dimension(650, 700));
        panelLeft.setLayout(null);
        panelLeft.setBackground(new Color(180, 225, 151));

        this.getContentPane().add(panelLeft);

        panelRight.setPreferredSize(new java.awt.Dimension(200, 700));
        panelRight.setLayout(null);
        panelRight.setBackground(new Color(180, 225, 151));

        lbRecord.setFont(new java.awt.Font("Tahoma", 1, 20));
        lbRecord.setText("Kỷ lục: 00:00:00");
        lbRecord.setHorizontalAlignment(SwingConstants.CENTER);
        lbRecord.setForeground(Color.white);
        panelRight.add(lbRecord);
        lbRecord.setBounds(0, 10, 200, 40);

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 25));
        lbTime.setText("00:00:00");
        lbTime.setHorizontalAlignment(SwingConstants.CENTER);
        lbTime.setForeground(Color.white);
        panelRight.add(lbTime);
        lbTime.setBounds(0, 50, 200, 40);

        lbText.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lbText.setText("Số lần kiểm tra: ");
        lbText.setForeground(Color.white);
        panelRight.add(lbText);
        lbText.setBounds(10, 90, 140, 40);

        lbCheck.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lbCheck.setText("10");
        lbCheck.setToolTipText("Số lần kiểm tra");
        lbCheck.setForeground(Color.white);
        //       lbCheck.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));
        panelRight.add(lbCheck);
        lbCheck.setBounds(145, 90, 50, 40);

        btnPause.setBackground(new java.awt.Color(255, 255, 255));
        btnPause.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Pause.png"))); // NOI18N
        btnPause.setText("Dừng");
        btnPause.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(btnPause);
        btnPause.setBounds(10, 140, 180, 60);
        btnPause.addActionListener(action);
        btnPause.addMouseListener(actionMouse);

        btnCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnCheck.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Check.png"))); // NOI18N
        btnCheck.setText("Kiểm tra");
        btnCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(btnCheck);
        btnCheck.setBounds(10, 220, 180, 60);
        btnCheck.addActionListener(action);
        btnCheck.addMouseListener(actionMouse);

        btnSolver.setBackground(new java.awt.Color(255, 255, 255));
        btnSolver.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Solver.png"))); // NOI18N
        btnSolver.setText("Giải");
        btnSolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(btnSolver);
        btnSolver.setBounds(10, 300, 180, 60);
        btnSolver.addActionListener(action);
        btnSolver.addMouseListener(actionMouse);

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Clear.png"))); // NOI18N
        btnClear.setText("Xóa");
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(btnClear);
        btnClear.setBounds(10, 380, 180, 60);
        btnClear.addActionListener(action);
        btnClear.addMouseListener(actionMouse);

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/NewGame.png"))); // NOI18N
        btnNew.setText("Ván mới");
        btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(btnNew);
        btnNew.setBounds(10, 500, 180, 60);
        btnNew.addActionListener(action);
        btnNew.addMouseListener(actionMouse);

        ImageIcon img = new ImageIcon(getClass().getResource("/Views/Image/icons8-sudoku-70.png"));
        this.setIconImage(img.getImage());

        this.getContentPane().add(panelRight);
        this.setSize(850, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    //Set panel cho chơi game Sudoku
    public void panelSudoku(int level) {
        if (btn == null || btn.length != level) {
            btn = new JButton[level][level];
        }
        sPanel = new SudokuPanel(level);
        //Set layout để add button
        sPanel.setLayout(new GridLayout(level, level));
        sPanel.setBounds(10, 10, sPanel.getWidth(), sPanel.getHeight());
        panelLeft.add(sPanel);

//        action = new ActionButton(sudoku, this);
        int width = sPanel.getWidth();
        int fontSize;
        if (level == 16) {
            fontSize = 1;
        } else {
            fontSize = 8;
        }
        //Mỗi ô số là 1 button
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                btn[i][j] = new JButton();
                btn[i][j].setBackground(Color.white);
                btn[i][j].setForeground(Color.black);
                btn[i][j].setFont(new Font("UTM Micra", 1, width / level / 3 + fontSize));
                btn[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                //   btn[i][j].setBorder(BorderFactory.createEmptyBorder());
                //set action khi click
                btn[i][j].addActionListener(action);
                //set action khi nhập số
                btn[i][j].addKeyListener(actionKey);

                btn[i][j].setActionCommand(i + " " + j);
                sPanel.add(btn[i][j]);
            }
        }

    }

    //Action click 
    public void btnActionPerformed(java.awt.event.ActionEvent e) {
        int level = (int) sudoku.getSudokuSolver().getLevel();
        //set lại tất cả 
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                btn[i][j].setBackground(Color.white);
                btn[i][j].setForeground(Color.black);
            }
        }
        //Lấy vị trí button trong mảng
        String s = e.getActionCommand();
        int k = s.indexOf(32);
        int i = Integer.parseInt(s.substring(0, k));
        int j = Integer.parseInt(s.substring(k + 1, s.length()));
        I = i;
        J = j;

        //Set hàng cột đã chọn thành màu khác
        for (int u = 0; u < level; u++) {
            btn[I][u].setBackground(new Color(192, 192, 192));
            btn[u][J].setBackground(new Color(192, 192, 192));
        }

        int sizeBox = (int) Math.sqrt(level);
        int boxRowStart = I - I % sizeBox;
        int boxColStart = J - J % sizeBox;

        for (int row = boxRowStart; row < boxRowStart + sizeBox; row++) {
            for (int col = boxColStart; col < boxColStart + sizeBox; col++) {
                btn[row][col].setBackground(new Color(192, 192, 192));
            }
        }

        int num = 0;
        if (!btn[I][J].getText().isEmpty()) {
            num = Integer.parseInt(btn[I][J].getText());
        }

        for (int r = 0; r < level; r++) {
            for (int c = 0; c < level; c++) {
                if (!btn[r][c].getText().isEmpty() && Integer.parseInt(btn[r][c].getText()) == num && (r != I || c != J)) {
                    btn[r][c].setBackground(new Color(131, 149, 167));
                }
            }
        }
        if (btn[I][J].getKeyListeners().length != 0) {
            //btn[I][J].setBackground(new Color(153, 204, 255));
            btn[I][J].setBackground(new Color(45, 152, 218));

        } else {
            btn[I][J].setBackground(new Color(153, 204, 255));
        }

    }

    //Nhấn phím
    public void txtKeyPressed(java.awt.event.KeyEvent e) {
        int level = (int) sudoku.getSudokuSolver().getLevel();

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                btn[i][j].setForeground(Color.black);
            }
        }
        //Lấy phím đã nhấn
        String r = "" + e.getKeyChar();

        txt += r;
        //if txt là bắt đầu bằng 0 thì set lại txt
        while (txt.startsWith("0")) {
            txt = "";
        }
        int a;
        try {
            a = Integer.parseInt(txt);
            //nếu txt > level thì chỉ lấy số phía sau ví dụ level 9 nhập 12 thì lấy 2 
            if (a > level) {
                txt = txt.substring(txt.length() - 1);

                if (txt.equals("0")) {
                    txt = "";
                }
                a = Integer.parseInt(txt);
            }
            //Nếu txt trong khoảng cho phép thì điền vào ô số
            if (a >= 1 && a <= level) {

                btn[I][J].setText("" + txt);

            }

        } catch (NumberFormatException ex) {

        }

        int sizeBox = (int) Math.sqrt(board.length);
        int boxRowStart = I - I % sizeBox;
        int boxColStart = J - J % sizeBox;
        //Cảnh báo trùng số trong khối
        for (int row = boxRowStart; row < boxRowStart + sizeBox; row++) {
            for (int col = boxColStart; col < boxColStart + sizeBox; col++) {
                if (btn[I][J].getText().equals(btn[row][col].getText()) && row != I && col != J) {
                    btn[I][J].setForeground(Color.red);
                    btn[row][col].setForeground(Color.red);
                }
            }
        }
        //Cảnh báo trùng số trong hàng, cột
        for (int i = 0; i < level; i++) {
            if (btn[I][J].getText().equals(btn[I][i].getText()) && i != J) {
                btn[I][J].setForeground(Color.red);
                btn[I][i].setForeground(Color.red);
            }
            if (btn[I][J].getText().equals(btn[i][J].getText()) && i != I) {
                btn[I][J].setForeground(Color.red);
                btn[i][J].setForeground(Color.red);
            }
        }

        //Kiểm tra hoàn thành đúng hết chưa
        boolean finish = true;
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                if (btn[i][j].getText().isEmpty()) {
                    finish = false;
                    break;
                }
                int temp = Integer.parseInt(btn[i][j].getText());
                if (temp != board[i][j]) {
                    finish = false;
                    break;
                }

            }
        }
        //Nếu hoàn thành đúng hết thì hiện thông báo
        if (finish == true) {
            sudoku.getTimer().close();
            int click = JOptionPane.showConfirmDialog(this, "Chúc mừng bạn đã hoàn thành, bạn có muốn chơi ván mới?", "Chúc mừng!", JOptionPane.OK_CANCEL_OPTION);

            String timeString = lbTime.getText();
            String timeCham = lbRecord.getText();
            if (timeCham.equals("Chưa có") || timeString.compareTo(timeCham) < 0) {
                if (sudoku.getSudokuSolver().getLevel() == (float) 9.1) {
                    sudoku.setChampion(0, 1, timeString);
                } else if (sudoku.getSudokuSolver().getLevel() == (float) 9.2) {
                    sudoku.setChampion(1, 1, timeString);
                } else if (sudoku.getSudokuSolver().getLevel() == (float) 9.3) {
                    sudoku.setChampion(2, 1, timeString);
                } else if (sudoku.getSudokuSolver().getLevel() == 16) {
                    sudoku.setChampion(3, 1, timeString);
                }

                data.writeGui(sudoku.getChampion());
            }
            if (click == JOptionPane.OK_OPTION) {
                I = 0;
                J = 0;
                this.dispose();
                this.sPanel = null;
                btn = null;
                board = null;
                this.panelLeft.removeAll();
                data.deleteFile();
                sudoku.getBtnContinue().setEnabled(false);
                panelLeft.removeAll();
                sudoku.setVisible(true);
                sudoku.getTimer().reset();

            } else {
                if (timeCham.equals("Chưa có") || timeString.compareTo(timeCham) < 0) {
                    lbRecord.setText("Kỷ lục: " + timeString);
                }
            }

        }
    }

    //set Text cho btn
    public void setTextBtn(int n) {
        int level = (int) sudoku.getSudokuSolver().getLevel();
        for (int i = 0; i < level; i++) {

            int num;
            int[] A;
            //Nếu level là 1
            if (n == 1) {
                num = random.randomNum(7, 4);
                A = new int[num];
                A = random.randomIndex(num, level);

                for (int j = 0; j < num; j++) {

                    btn[i][A[j]].setText("" + board[i][A[j]]);
                    btn[i][A[j]].removeKeyListener(actionKey);

                }
            } else if (n == 2) { //Nếu level là 2
                num = random.randomNum(5, 2);
                A = new int[num];
                A = random.randomIndex(num, level);
                for (int j = 0; j < num; j++) {
                    btn[i][A[j]].setText("" + board[i][A[j]]);
                    btn[i][A[j]].removeKeyListener(actionKey);
                }
            } else if (n == 3) { //Nếu level là 3
                num = random.randomNum(4, 1);
                A = new int[num];
                A = random.randomIndex(num, level);
                for (int j = 0; j < num; j++) {
                    btn[i][A[j]].setText("" + board[i][A[j]]);
                    btn[i][A[j]].removeKeyListener(actionKey);
                }
            } else if (n == 4) { //Nếu level là 4
                num = random.randomNum(10, 6);
                A = new int[num];
                A = random.randomIndex(num, level);

                for (int j = 0; j < num; j++) {
                    btn[i][A[j]].setText("" + board[i][A[j]]);
                    btn[i][A[j]].removeKeyListener(actionKey);
                }
            }

        }
    }

    public void actionBtnPause() {

        if (btnPause.getText().equals("Dừng")) {

            btnPause.setText("Tiếp tục");
            btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/icons8-sort-right-32.png")));
            sudoku.getTimer().close();
            this.sPanel.setVisible(false);
            if (pause == null) {
                pause = new PanelPause();
            }
            pause.getRecord().setIcon(new ImageIcon(getClass().getResource("/Views/Image/cup.png")));
            pause.getTimeVar().setText(lbTime.getText());
            pause.getCheckVar().setText(lbCheck.getText() + "/10");
            if (sudoku.getSudokuSolver().getLevel() == (float) 9.1) {
                pause.getLevelVar().setText("Dễ");
            }
            if (sudoku.getSudokuSolver().getLevel() == (float) 9.2) {
                pause.getLevelVar().setText("Trung bình");
            }
            if (sudoku.getSudokuSolver().getLevel() == (float) 9.3) {
                pause.getLevelVar().setText("Khó");
            }
            if (sudoku.getSudokuSolver().getLevel() == 16) {
                pause.getLevelVar().setText("Cực khó");
            }

            pause.getRecordVar().setText(lbRecord.getText());
            pause.setLocation((panelLeft.getWidth() - pause.getWidth()) / 2, (panelLeft.getHeight() - pause.getHeight()) / 2);
            this.panelLeft.add(pause);
            pause.setVisible(true);

            btnCheck.setEnabled(false);
            btnClear.setEnabled(false);
            btnNew.setEnabled(false);
            btnSolver.setEnabled(false);

            btnPause.setActionCommand("Dừng");

        } else {
            btnPause.setActionCommand("Dừng");
            btnPause.setText("Dừng");
            btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Image/Pause.png")));
            sudoku.getTimer().keeping();
            this.sPanel.setVisible(true);
            pause.setVisible(false);

            btnCheck.setEnabled(true);
            btnClear.setEnabled(true);
            btnNew.setEnabled(true);
            btnSolver.setEnabled(true);

        }

    }

    public void actionBtnNew() {
        saveGame();

        this.setVisible(false);
        this.sPanel = null;
        btn = null;
        board = null;
        this.panelLeft.removeAll();
        sudoku.getBtnContinue().setEnabled(false);
        sudoku.setVisible(true);
        this.dispose();
        I = 0;
        J = 0;
        txt = "";
        lbCheck.setText("10");

        sudoku.getTimer().reset();
        sudoku.loadGame();
    }

    public void actionBtnCheck() {
        int level = (int) sudoku.getSudokuSolver().getLevel();
        int test = Integer.parseInt(lbCheck.getText());
        if (test > 0) {
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < level; j++) {
                    if ((!btn[i][j].getText().isEmpty()) && (Integer.parseInt(btn[i][j].getText()) == board[i][j]) && (btn[i][j].getKeyListeners().length != 0)) {
                        btn[i][j].setForeground(Color.green);
                    } else if ((!btn[i][j].getText().isEmpty()) && (Integer.parseInt(btn[i][j].getText()) != board[i][j]) && (btn[i][j].getKeyListeners().length != 0)) {
                        btn[i][j].setForeground(Color.red);
                    }
                }
            }
            test--;
        } else {
            JOptionPane.showMessageDialog(this, "Số lần test của bạn đã hết");
        }

        lbCheck.setText("" + test);
    }

    public void actionBtnSolver() {
        int level = (int) sudoku.getSudokuSolver().getLevel();
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {

                if (btn[i][j].getText().isEmpty() || board[i][j] != Integer.parseInt(btn[i][j].getText())) {

                    btn[i][j].setText(Integer.toString(board[i][j]));

                    btn[i][j].setForeground(Color.red);
                } else if (board[i][j] == Integer.parseInt(btn[i][j].getText()) && btn[i][j].isEnabled()) {
                    btn[i][j].setForeground(Color.green);
                }

            }
        }
    }

    public void actionBtnClear() {
        int level = (int) sudoku.getSudokuSolver().getLevel();
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                if (btn[i][j].getKeyListeners().length != 0) {
                    btn[i][j].setText("");

                }
                btn[i][j].setForeground(Color.BLACK);
            }
        }
    }

    public float setFile() {

        String time = data.getTime();
        int house = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);
        sudoku.getTimer().start();
        sudoku.getTimer().setElapsedTime((house * 3600000) + (minutes % 60 * 60000) + (seconds % 60 * 1000));

        lbCheck.setText(data.getCheck());

        float level = checkFile();
        int[][] saveValue = new int[(int) level][(int) level];
        saveValue = data.getSaveValue();
        int[][] saveIndex = new int[(int) level][(int) level];
        saveIndex = data.getSaveIndex();
        board = new int[(int) level][(int) level];
        board = data.getBoard();

        panelSudoku((int) level);
        if ((int) level == 9) {
            this.setSize(850, 700);
        } else {
            this.setSize(1100, 810);
        }
        for (int i = 0; i < (int) level; i++) {
            for (int j = 0; j < (int) level; j++) {
                if (saveValue[i][j] != 0) {
                    btn[i][j].setText(saveValue[i][j] + "");
                }

            }
        }
        for (int i = 0; i < (int) level; i++) {
            for (int j = 0; j < (int) level; j++) {
                if (saveIndex[i][j] != 0) {
                    btn[i][j].removeKeyListener(actionKey);
                }

            }
        }
        return level;
    }

    public float checkFile() {
        float A;

        A = data.readFile();
        return A;
    }

    private void saveGame() {
        int level = (int) sudoku.getSudokuSolver().getLevel();

        int[][] saveValue;
        data.setLevel(sudoku.getSudokuSolver().getLevel());
        data.deleteFile();
//        sudoku.getTimer().close();

        String[][] str = sudoku.getChampion();
        data.writeGui(str);

        saveValue = new int[level][level];
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                if (btn[i][j].getText() == "") {
                    saveValue[i][j] = 0;
                } else {
                    saveValue[i][j] = Integer.parseInt(btn[i][j].getText());
                }
            }
        }
        data.writeStatus(lbTime.getText(), lbCheck.getText());
        data.writeFile(saveValue);

        data.writeFile(board);

        int[][] B = new int[level][level];
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level; j++) {
                if (btn[i][j].getKeyListeners().length != 0) {
                    B[i][j] = 0;
                } else {
                    B[i][j] = 1;
                }
            }
        }
        data.writeFile(B);
    }

    public void formWindowClosing() {

        sudoku.getTimer().close();

        if (btnPause.isVisible()) {
            int click = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại ván vừa chơi", "Lưu", JOptionPane.YES_NO_OPTION);
            if (click == JOptionPane.YES_OPTION) {
                saveGame();
                System.exit(0);

            } else {
                data.deleteFile();
                System.exit(0);
            }

        }

    }

    public JPanel getPanelLeft() {
        return panelLeft;
    }

    public JButton getBtnCheck() {
        return btnCheck;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public JButton getBtnSolver() {
        return btnSolver;
    }

    public JLabel getLbCheck() {
        return lbCheck;
    }

    public JLabel getLbRecord() {
        return lbRecord;
    }

    public JLabel getLbTime() {
        return lbTime;
    }

    public JButton[][] getBtn() {
        return btn;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setBtn(JButton[][] btn) {
        this.btn = btn;
    }

}
