import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {
    private int xPos;
    private int yPos;
    private int size;
    private boolean drawCircle;
    private boolean drawSquare;
    private boolean drawTriangle;
    private Color shapeColor;

    public GraphicsPanel() {
        super.setBackground(Color.white);
        super.setPreferredSize(new Dimension(640, 480));
        this.xPos = 320;
        this.yPos = 240;
        this.size = 50;
        this.drawCircle = true;
        this.drawSquare = false;
        this.drawTriangle = false;
        this.shapeColor = Color.blue;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDrawCircle(boolean drawCircle) {
        this.drawCircle = drawCircle;
    }

    public void setDrawSquare(boolean drawSquare) {
        this.drawSquare = drawSquare;
    }

    public void setDrawTriangle(boolean drawTriangle) {
        this.drawTriangle = drawTriangle;
    }

    public void setShapeColor(Color color) {
        this.shapeColor = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(this.shapeColor);
        
        // 円を描画
        if (this.drawCircle) {
            g.fillOval(this.xPos - this.size / 2, this.yPos - this.size / 2, this.size, this.size);
        }
        
        // 四角形を描画
        if (this.drawSquare) {
            g.fillRect(this.xPos - this.size / 2, this.yPos - this.size / 2, this.size, this.size);
        }
        
        // 三角形を描画
        if (this.drawTriangle) {
            int[] xPoints = {
                this.xPos,
                this.xPos - this.size / 2,
                this.xPos + this.size / 2
            };
            int[] yPoints = {
                this.yPos - this.size / 2,
                this.yPos + this.size / 2,
                this.yPos + this.size / 2
            };
            g.fillPolygon(xPoints, yPoints, 3);
        }
        
        // 座標情報を表示
        g.setColor(Color.black);
        g.drawString("Position: (" + this.xPos + ", " + this.yPos + ")", 10, 20);
        g.drawString("Size: " + this.size, 10, 40);
    }
}
