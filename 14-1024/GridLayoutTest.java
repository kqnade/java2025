import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class GridLayoutTest extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    
    public GridLayoutTest(String title) {
        super(title);
        
        // 部品の初期化
        this.button1 = new JButton("1");
        this.button2 = new JButton("2");
        this.button3 = new JButton("3");
        this.button4 = new JButton("4");
        this.button5 = new JButton("5");
        this.button6 = new JButton("6");
        
        // パネルとレイアウトマネージャの設定
        // GridLayout(行数, 列数)で格子状に配置
        JPanel panel1 = new JPanel();
        GridLayout grid1 = new GridLayout(2, 3);
        panel1.setLayout(grid1);
        
        // パネルに部品を追加(左から右、上から下の順)
        panel1.add(this.button1);
        panel1.add(this.button2);
        panel1.add(this.button3);
        panel1.add(this.button4);
        panel1.add(this.button5);
        panel1.add(this.button6);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel1);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 200);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new GridLayoutTest("GridLayoutテスト");
    }
}
