import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class BorderTest extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    
    public BorderTest(String title) {
        super(title);
        
        // 部品の初期化
        this.button1 = new JButton("左ボタン");
        this.button2 = new JButton("右ボタン");
        this.button3 = new JButton("上ボタン");
        this.label1 = new JLabel("BorderLayoutのテスト");
        
        // パネルとレイアウトマネージャの設定
        JPanel panel1 = new JPanel();
        BorderLayout border1 = new BorderLayout();
        panel1.setLayout(border1);
        
        // パネルに部品を追加
        panel1.add(this.button1, BorderLayout.WEST);
        panel1.add(this.button2, BorderLayout.EAST);
        panel1.add(this.button3, BorderLayout.NORTH);
        panel1.add(this.label1, BorderLayout.SOUTH);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel1);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 200);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new BorderTest("BorderLayoutテスト");
    }
}
