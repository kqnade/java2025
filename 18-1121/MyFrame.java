import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private MyPanel mp; // MyFrame HAS-A MyPanel の関係を構築

    public MyFrame() {
        this.mp = new MyPanel(); // 描画用のパネル
        JPanel panel1 = new JPanel(); // 配置用のパネル
        panel1.add(this.mp); // 配置用のパネルに、描画用のパネルを入れる
        super.getContentPane().add(panel1);

        super.setTitle("Graphics Drawing Example");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
