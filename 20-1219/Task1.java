import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 extends JFrame implements ActionListener {
    private MyPanel mp;
    private Timer timer;

    public Task1() {
        this.mp = new MyPanel();
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        super.getContentPane().add(panel1);

        super.setTitle("Task1: Timer Test");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);

        this.timer = new Timer(1000, this);
        this.timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Timer: actionPerformed called");
        this.mp.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args) {
        new Task1();
    }

    class MyPanel extends JPanel {
        public MyPanel() {
            super.setBackground(Color.white);
            super.setPreferredSize(new Dimension(640, 480));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("paintComponent is called");
            
            g.setColor(Color.blue);
            g.drawString("Timer is running... (Check console)", 200, 240);
        }
    }
}
