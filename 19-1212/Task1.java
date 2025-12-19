import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 extends JFrame {
    public static void main(String[] args) {
        new Task1();
    }

    public Task1() {
        this.setTitle("Task 1: Mouse Click Stamp");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        this.add(panel);
        
        this.setVisible(true);
    }

    class MyPanel extends JPanel implements MouseListener {
        public MyPanel() {
            this.addMouseListener(this);
        }

        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            System.out.println("Pressed at: " + x + ", " + y);

            Graphics g = this.getGraphics();
            g.drawLine(x - 10, y - 10, x + 10, y + 10);
            g.drawLine(x + 10, y - 10, x - 10, y + 10);
            g.dispose();
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
}
