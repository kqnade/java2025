import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class FlowTest extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    
    public FlowTest(String title) {
        super(title);
        
        // 部品の初期化
        this.button1 = new JButton("ボタン1");
        this.button2 = new JButton("ボタン2");
        this.button3 = new JButton("ボタン3");
        this.label1 = new JLabel("FlowLayoutのテスト");
        
        // パネルとレイアウトマネージャの設定
        JPanel panel1 = new JPanel();
        FlowLayout flow1 = new FlowLayout();
        panel1.setLayout(flow1);
        
        // パネルに部品を追加
        panel1.add(this.label1);
        panel1.add(this.button1);
        panel1.add(this.button2);
        panel1.add(this.button3);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel1);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 150);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlowTest("FlowLayoutテスト");
    }
}
