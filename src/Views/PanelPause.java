package Views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelPause extends JPanel {

    private JLabel title;
    private JLabel time;
    private JLabel check;
    private JLabel timeVar;
    private JLabel level;
    private JLabel checkVar;
    private JLabel levelVar;
    private JLabel record;
    private JLabel recordVar;

    public PanelPause() {
        initComponents();

    }

    private void initComponents() {
        time = new JLabel("Thời gian");
        check = new JLabel("Kiểm tra");
        timeVar = new JLabel();
        level = new JLabel("Cấp độ");
        checkVar = new JLabel();
        levelVar = new JLabel();
        record = new JLabel();
        recordVar = new JLabel();
        title = new JLabel("Tạm dừng");
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setSize(400, 300);

        this.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange));

        title.setFont(new java.awt.Font("Tahoma", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
        title.setBounds(0, 10, 400, 50);

        time.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        time.setForeground(Color.gray);
        time.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(time);
        time.setBounds(10, 50, 100, 50);

        timeVar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        timeVar.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(timeVar);
        timeVar.setBounds(10, 80, 100, 50);

        check.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        check.setForeground(Color.gray);
        check.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(check);
        check.setBounds(100, 50, 200, 50);

        checkVar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        checkVar.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(checkVar);
        checkVar.setBounds(100, 80, 200, 50);

        level.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        level.setForeground(Color.gray);
        level.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(level);
        level.setBounds(290, 50, 100, 50);

        levelVar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        levelVar.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(levelVar);
        levelVar.setBounds(290, 80, 100, 50);

        this.add(record);
        record.setBounds(80, 150, 100, 100);

        recordVar.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        recordVar.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(recordVar);
        recordVar.setBounds(150, 170, 200, 50);
    }

    public JLabel getTimeVar() {
        return timeVar;
    }

    public JLabel getCheckVar() {
        return checkVar;
    }

    public JLabel getLevelVar() {
        return levelVar;
    }

    public JLabel getRecordVar() {
        return recordVar;
    }

    public JLabel getRecord() {
        return record;
    }

}
