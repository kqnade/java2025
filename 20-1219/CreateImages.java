import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateImages {
    public static void main(String[] args) throws Exception {
        // Create chara.png - a simple circle character
        BufferedImage img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0, 0, 0, 0)); // Transparent background
        g.fillRect(0, 0, 64, 64);
        g.setColor(Color.BLUE);
        g.fillOval(10, 10, 44, 44);
        g.setColor(Color.WHITE);
        g.fillOval(20, 20, 8, 8);
        g.fillOval(36, 20, 8, 8);
        g.setColor(Color.RED);
        g.fillArc(20, 30, 24, 16, 0, -180);
        g.dispose();
        ImageIO.write(img, "PNG", new File("chara.png"));
        System.out.println("Created chara.png");

        // Create chara0.png - face looking left
        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, 64, 64);
        g.setColor(new Color(255, 200, 0));
        g.fillOval(8, 8, 48, 48);
        g.setColor(Color.BLACK);
        g.fillOval(20, 22, 6, 6);
        g.fillOval(38, 22, 6, 6);
        g.fillArc(22, 32, 20, 12, 0, -180);
        g.dispose();
        ImageIO.write(img, "PNG", new File("chara0.png"));
        System.out.println("Created chara0.png");

        // Create chara1.png - face neutral
        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, 64, 64);
        g.setColor(new Color(255, 200, 0));
        g.fillOval(8, 8, 48, 48);
        g.setColor(Color.BLACK);
        g.fillOval(18, 20, 8, 8);
        g.fillOval(38, 20, 8, 8);
        g.drawLine(24, 36, 40, 36);
        g.dispose();
        ImageIO.write(img, "PNG", new File("chara1.png"));
        System.out.println("Created chara1.png");

        // Create chara2.png - face looking right
        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, 64, 64);
        g.setColor(new Color(255, 200, 0));
        g.fillOval(8, 8, 48, 48);
        g.setColor(Color.BLACK);
        g.fillOval(20, 22, 6, 6);
        g.fillOval(38, 22, 6, 6);
        g.fillArc(22, 32, 20, 12, 0, 180);
        g.dispose();
        ImageIO.write(img, "PNG", new File("chara2.png"));
        System.out.println("Created chara2.png");

        // Create background.png - a simple background
        img = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        g = img.createGraphics();
        GradientPaint gradient = new GradientPaint(0, 0, new Color(135, 206, 235), 
                                                     0, 480, new Color(100, 149, 237));
        g.setPaint(gradient);
        g.fillRect(0, 0, 640, 480);
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 400, 640, 80);
        g.setColor(Color.YELLOW);
        g.fillOval(480, 40, 80, 80);
        g.dispose();
        ImageIO.write(img, "PNG", new File("background.png"));
        System.out.println("Created background.png");
    }
}
