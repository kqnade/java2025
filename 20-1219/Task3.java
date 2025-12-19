import javax.swing.*;
import java.awt.*;

public class Task3 extends JFrame {
    private MyPanel mp;

    public Task3() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);

        Image[] chara_array = new Image[3];
        for (int i = 0; i < 3; i++) {
            String filename = "chara" + i + ".png";
            System.out.println("filename = " + filename);
            chara_array[i] = tk.getImage(filename);
            tracker.addImage(chara_array[i], i);
        }

        try {
            tracker.waitForAll();
        } catch (Exception ex) {
            System.exit(1);
        }

        this.mp = new MyPanel(chara_array);
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        super.getContentPane().add(panel1);

        super.setTitle("Task3: Multiple Images Display");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Task3();
    }

    class MyPanel extends JPanel {
        private Image[] chara_array;

        public MyPanel(Image[] chara_array) {
            this.chara_array = chara_array;
            super.setBackground(Color.white);
            super.setPreferredSize(new Dimension(640, 480));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.black);
            g.drawString("Multiple images displayed at different positions", 180, 50);
            
            for (int i = 0; i < this.chara_array.length; i++) {
                int x = 150 + i * 150;
                int y = 200;
                g.drawImage(this.chara_array[i], x, y, this);
                g.drawString("Image " + i, x + 15, y + 80);
            }
        }
    }
}
