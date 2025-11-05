import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;

public class RadioButtonTest extends JFrame implements ActionListener {
    private JRadioButton rb1, rb2, rb3;
    private JButton kettei;

    public RadioButtonTest() {
        super("RadioButtonのテスト");
        
        // ラジオボタンとボタンの初期化
        this.rb1 = new JRadioButton("就職");
        this.rb2 = new JRadioButton("専攻科進学");
        this.rb3 = new JRadioButton("大学編入学", true);
        
        // ボタングループを生成してラジオボタンを登録
        ButtonGroup group = new ButtonGroup();
        group.add(this.rb1);
        group.add(this.rb2);
        group.add(this.rb3);
        
        this.kettei = new JButton("進路決定");
        
        // パネルの作成とレイアウト設定
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        // パネルに部品を追加（ButtonGroupへの追加とは別に必要）
        panel.add(this.rb1);
        panel.add(this.rb2);
        panel.add(this.rb3);
        panel.add(this.kettei);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel);
        
        // 進路決定ボタンにイベントリスナーを設定
        this.kettei.addActionListener(this);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(450, 150);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.kettei) {
            if (this.rb1.isSelected() == true) {
                System.out.println("実習系科目には特にしっかり取り組みましょう!");
            } else if (this.rb2.isSelected() == true) {
                System.out.println("専攻科では研究活動にも取り組めますよ!");
            } else if (this.rb3.isSelected() == true) {
                System.out.println("編入試験に向けて勉強を頑張りましょう!");
            }
        }
    }

    public static void main(String[] args) {
        new RadioButtonTest();
    }
}
