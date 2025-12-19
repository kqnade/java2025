import javax.swing.*;
import java.awt.*;

public class Task2 extends JFrame {
    private MyPanel mp;

    public Task2() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);

        Image chara = tk.getImage("chara.png");
        tracker.addImage(chara, 0);

        try {
            tracker.waitForAll();
        } catch (Exception ex) {
            System.exit(1);
        }

        this.mp = new MyPanel(chara);
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        super.getContentPane().add(panel1);

        super.setTitle("Task2: Single Image Display");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }

    class MyPanel extends JPanel {
        private Image chara;

        public MyPanel(Image chara) {
            this.chara = chara;
            super.setBackground(Color.white);
            super.setPreferredSize(new Dimension(640, 480));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.black);
            g.drawString("Single image displayed at fixed position (200, 200)", 150, 100);
            
            g.drawImage(this.chara, 200, 200, this);
        }
    }
}
