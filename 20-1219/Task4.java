import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task4 extends JFrame implements ActionListener {
    private MyPanel mp;
    private Timer timer;

    public Task4() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);

        Image background = tk.getImage("background.png");
        tracker.addImage(background, 0);

        Image[] chara_array = new Image[3];
        for (int i = 0; i < 3; i++) {
            String filename = "chara" + i + ".png";
            System.out.println("filename = " + filename);
            chara_array[i] = tk.getImage(filename);
            tracker.addImage(chara_array[i], i + 1);
        }

        try {
            tracker.waitForAll();
        } catch (Exception ex) {
            System.out.println("Image loading failed");
            System.exit(1);
        }

        this.mp = new MyPanel(background, chara_array);
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        super.getContentPane().add(panel1);

        super.setTitle("Task4: Animation with Timer");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);

        this.timer = new Timer(100, this);
        this.timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        this.mp.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args) {
        new Task4();
    }

    class MyPanel extends JPanel {
        private Image background;
        private Image[] chara_array;
        private int chara_i;
        private int chara_x;
        private int chara_y;
        private int direction;

        public MyPanel(Image background, Image[] chara_array) {
            this.background = background;
            this.chara_array = chara_array;
            this.chara_i = 0;
            this.chara_x = 100;
            this.chara_y = 320;
            this.direction = 1;
            
            super.setBackground(Color.white);
            super.setPreferredSize(new Dimension(640, 480));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            if (this.background != null) {
                g.drawImage(this.background, 0, 0, this);
            }
            
            g.drawImage(this.chara_array[this.chara_i], this.chara_x, this.chara_y, this);
            
            this.chara_i++;
            if (this.chara_i >= this.chara_array.length) {
                this.chara_i = 0;
            }
            
            this.chara_x += 3 * this.direction;
            
            if (this.chara_x > 550) {
                this.direction = -1;
            } else if (this.chara_x < 10) {
                this.direction = 1;
            }
        }
    }
}
