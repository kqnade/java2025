import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        super.setBackground(Color.black); // 背景色を黒に設定
        super.setPreferredSize(new Dimension(640, 240)); // 大きさを640x240に設定
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // まずJPanelのデフォルトの描画処理(背景色でクリア)を行い、

        g.setColor(Color.green); // 前景色を緑に設定
        g.drawLine(50, 50, 100, 100); // 直線を描画
        g.drawOval(32, 16, 256, 128); // 楕円を描画
        g.drawRect(200, 80, 150, 75); // 長方形を描画
        g.drawString("Hello, Graphics!", 400, 120); // 文字列を描画
    }
}
