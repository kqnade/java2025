import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Task3 extends JFrame {
    public static void main(String[] args) {
        new Task3();
    }

    public Task3() {
        this.setTitle("Task 3: Double Buffering");
        this.setSize(600, 600); // Set a fixed size to match buffer
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        this.add(panel);
        
        this.setVisible(true);
    }

    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        private BufferedImage bi;
        private int prev_x, prev_y;
        private final int WIDTH = 600;
        private final int HEIGHT = 600;

        public MyPanel() {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            
            // Initialize Double Buffer
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.getGraphics();
            g.setColor(Color.white); // Background color
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.dispose();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bi, 0, 0, this);
        }

        public void mousePressed(MouseEvent e) {
            prev_x = e.getX();
            prev_y = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            Graphics g = bi.getGraphics();
            g.setColor(Color.black); // Pen color
            g.drawLine(prev_x, prev_y, x, y);
            g.dispose();

            this.repaint(); // Request screen update

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
