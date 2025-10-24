import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ComplexTest extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField text1;
    private JTextField text2;
    
    public ComplexTest(String title) {
        super(title);
        
        // 部品の初期化
        this.button1 = new JButton("新規");
        this.button2 = new JButton("開く");
        this.button3 = new JButton("保存");
        this.button4 = new JButton("実行");
        this.button5 = new JButton("1");
        this.button6 = new JButton("2");
        this.button7 = new JButton("3");
        this.button8 = new JButton("クリア");
        this.label1 = new JLabel("アプリケーションタイトル");
        this.label2 = new JLabel("ステータス: 準備完了");
        this.label3 = new JLabel("入力エリア:");
        this.text1 = new JTextField(10);
        this.text2 = new JTextField(10);
        
        // パネル4の作成(GridLayoutで数字ボタン)
        JPanel panel4 = new JPanel();
        GridLayout grid1 = new GridLayout(2, 2);
        panel4.setLayout(grid1);
        panel4.add(this.button5);
        panel4.add(this.button6);
        panel4.add(this.button7);
        panel4.add(this.button8);
        
        // パネル3の作成(FlowLayoutで入力フィールド)
        JPanel panel3 = new JPanel();
        FlowLayout flow2 = new FlowLayout();
        panel3.setLayout(flow2);
        panel3.add(this.label3);
        panel3.add(this.text1);
        panel3.add(this.text2);
        
        // パネル5の作成(BorderLayoutでパネル3とパネル4を組み合わせ)
        JPanel panel5 = new JPanel();
        BorderLayout border2 = new BorderLayout();
        panel5.setLayout(border2);
        panel5.add(panel3, BorderLayout.NORTH);
        panel5.add(panel4, BorderLayout.CENTER);
        
        // パネル2の作成(FlowLayoutでツールバーボタン横並び)
        JPanel panel2 = new JPanel();
        FlowLayout flow1 = new FlowLayout();
        panel2.setLayout(flow1);
        panel2.add(this.button1);
        panel2.add(this.button2);
        panel2.add(this.button3);
        
        // パネル1の作成(BorderLayoutで全体を配置)
        JPanel panel1 = new JPanel();
        BorderLayout border1 = new BorderLayout();
        panel1.setLayout(border1);
        panel1.add(this.label1, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(panel5, BorderLayout.CENTER);
        panel1.add(this.button4, BorderLayout.EAST);
        panel1.add(this.label2, BorderLayout.WEST);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel1);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600, 300);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ComplexTest("複雑な入れ子レイアウトテスト");
    }
}
