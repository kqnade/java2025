import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;

public class CheckBoxTest extends JFrame implements ActionListener {
    private JCheckBox cb1, cb2;
    private JButton judge;

    public CheckBoxTest() {
        super("CheckBoxのテスト");
        
        // チェックボックスとボタンの初期化
        this.cb1 = new JCheckBox("数学が得意");
        this.cb2 = new JCheckBox("英語が得意", true);
        this.judge = new JButton("判定");
        
        // パネルの作成とレイアウト設定
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        // パネルに部品を追加
        panel.add(this.cb1);
        panel.add(this.cb2);
        panel.add(this.judge);
        
        // contentPaneにパネルを追加
        super.getContentPane().add(panel);
        
        // 判定ボタンにイベントリスナーを設定
        this.judge.addActionListener(this);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 150);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.judge) {
            if (this.cb1.isSelected() == true && this.cb2.isSelected() == false) {
                System.out.println("いいですね! でも英語も重要ですよ!");
            } else if (this.cb1.isSelected() == true && this.cb2.isSelected() == true) {
                System.out.println("両方得意なんて素晴らしいですね!");
            } else if (this.cb1.isSelected() == false && this.cb2.isSelected() == true) {
                System.out.println("英語が得意なのは良いことです! 数学も頑張りましょう!");
            } else {
                System.out.println("どちらも頑張りましょう!");
            }
        }
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
