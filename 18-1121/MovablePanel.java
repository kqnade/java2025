import javax.swing.*;
import java.awt.*;

public class MovablePanel extends JPanel {
    private int size; // 図形の大きさを保存するためのフィールド

    public MovablePanel() {
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(640, 240));
        this.size = 50; // 初期サイズ
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.cyan);
        // 楕円を描画（拡大縮小）
        // drawOval(x, y, width, height)
        // 中央に描画するため、座標を調整
        int x = 320 - this.size / 2;
        int y = 120 - this.size / 2;
        g.drawOval(x, y, this.size, this.size);
        
        g.setColor(Color.yellow);
        g.fillOval(x, y, this.size, this.size);
    }
}
