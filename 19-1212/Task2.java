import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task2 extends JFrame {
    public static void main(String[] args) {
        new Task2();
    }

    public Task2() {
        this.setTitle("Task 2: Continuous Drawing");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        this.add(panel);
        
        this.setVisible(true);
    }

    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        private int prev_x, prev_y;

        public MyPanel() {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        public void mousePressed(MouseEvent e) {
            prev_x = e.getX();
            prev_y = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            Graphics g = this.getGraphics();
            g.drawLine(prev_x, prev_y, x, y);
            g.dispose();

            prev_x = x;
            prev_y = y;
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }
}
