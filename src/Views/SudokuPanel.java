package Views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel {

    private int level;

    public SudokuPanel() {
        initComponents();
    }

    public SudokuPanel(int n) {
        initComponents();
        if (n == 9) {
            this.setSize(612, 612);
        } else {
            this.setSize(736, 736);
        }
        this.level = n;
    }

    private void initComponents() {
        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(810, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 810, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(1.0f, 1.0f, 1.0f));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(new Color(0.0f, 0.0f, 0.0f));
        int slotWight = this.getWidth() / level;
        int slotHeight = this.getHeight() / level;

        int n = 3;
        if (level == 16) {
            n = 4;
        }
        for (int i = 0; i <= this.getWidth(); i += slotWight) {

            if ((i / slotWight) % n == 0) {
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(i, 0, i, this.getHeight());

            } else {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(i, 0, i, this.getHeight());
            }
        }

        for (int i = 0; i <= this.getHeight(); i += slotHeight) {

            if ((i / slotHeight) % n == 0) {
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(0, i, this.getWidth(), i);

            } else {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(0, i, this.getWidth(), i);
            }
        }

    }

}
