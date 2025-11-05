import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SurveyApp extends JFrame implements ActionListener {
    // チェックボックス（複数選択可能な趣味）
    private JCheckBox hobby1, hobby2, hobby3, hobby4;
    // ラジオボタン（一つだけ選択可能な学年）
    private JRadioButton grade1, grade2, grade3, grade4, grade5;
    // ボタン
    private JButton submit, reset;
    // ラベル
    private JLabel hobbyLabel, gradeLabel, resultLabel;

    public SurveyApp() {
        super("趣味・学年アンケート");
        
        // ラベルの初期化
        this.hobbyLabel = new JLabel("【趣味】（複数選択可）");
        this.gradeLabel = new JLabel("【学年】（一つ選択）");
        this.resultLabel = new JLabel("結果がここに表示されます");
        
        // チェックボックスの初期化
        this.hobby1 = new JCheckBox("読書");
        this.hobby2 = new JCheckBox("スポーツ");
        this.hobby3 = new JCheckBox("音楽");
        this.hobby4 = new JCheckBox("ゲーム");
        
        // ラジオボタンの初期化
        this.grade1 = new JRadioButton("1年生", true);
        this.grade2 = new JRadioButton("2年生");
        this.grade3 = new JRadioButton("3年生");
        this.grade4 = new JRadioButton("4年生");
        this.grade5 = new JRadioButton("5年生");
        
        // ボタングループの作成
        ButtonGroup gradeGroup = new ButtonGroup();
        gradeGroup.add(this.grade1);
        gradeGroup.add(this.grade2);
        gradeGroup.add(this.grade3);
        gradeGroup.add(this.grade4);
        gradeGroup.add(this.grade5);
        
        // ボタンの初期化
        this.submit = new JButton("送信");
        this.reset = new JButton("リセット");
        
        // メインパネルの作成
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        // 趣味パネル
        JPanel hobbyPanel = new JPanel();
        hobbyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        hobbyPanel.add(this.hobbyLabel);
        hobbyPanel.add(this.hobby1);
        hobbyPanel.add(this.hobby2);
        hobbyPanel.add(this.hobby3);
        hobbyPanel.add(this.hobby4);
        
        // 学年パネル
        JPanel gradePanel = new JPanel();
        gradePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        gradePanel.add(this.gradeLabel);
        gradePanel.add(this.grade1);
        gradePanel.add(this.grade2);
        gradePanel.add(this.grade3);
        gradePanel.add(this.grade4);
        gradePanel.add(this.grade5);
        
        // ボタンパネル
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(this.submit);
        buttonPanel.add(this.reset);
        
        // 結果パネル
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(this.resultLabel);
        
        // メインパネルに各パネルを追加
        mainPanel.add(hobbyPanel);
        mainPanel.add(gradePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        
        // contentPaneにメインパネルを追加
        super.getContentPane().add(mainPanel);
        
        // イベントリスナーの設定
        this.submit.addActionListener(this);
        this.reset.addActionListener(this);
        
        // ウィンドウの設定
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600, 250);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.submit) {
            // 選択された趣味を集計
            String hobbies = "";
            int hobbyCount = 0;
            
            if (this.hobby1.isSelected()) {
                hobbies += "読書 ";
                hobbyCount++;
            }
            if (this.hobby2.isSelected()) {
                hobbies += "スポーツ ";
                hobbyCount++;
            }
            if (this.hobby3.isSelected()) {
                hobbies += "音楽 ";
                hobbyCount++;
            }
            if (this.hobby4.isSelected()) {
                hobbies += "ゲーム ";
                hobbyCount++;
            }
            
            if (hobbyCount == 0) {
                hobbies = "なし";
            }
            
            // 選択された学年を取得
            String grade = "";
            if (this.grade1.isSelected()) grade = "1年生";
            else if (this.grade2.isSelected()) grade = "2年生";
            else if (this.grade3.isSelected()) grade = "3年生";
            else if (this.grade4.isSelected()) grade = "4年生";
            else if (this.grade5.isSelected()) grade = "5年生";
            
            // 結果を表示
            String result = grade + "の趣味: " + hobbies + "(" + hobbyCount + "個)";
            this.resultLabel.setText(result);
            System.out.println("=== アンケート結果 ===");
            System.out.println("学年: " + grade);
            System.out.println("趣味: " + hobbies);
            System.out.println("趣味の数: " + hobbyCount + "個");
            
            // 学年に応じたメッセージ
            if (this.grade1.isSelected() || this.grade2.isSelected()) {
                System.out.println("低学年ですね! 基礎をしっかり学びましょう!");
            } else if (this.grade3.isSelected()) {
                System.out.println("中学年ですね! 専門科目が増えてきますよ!");
            } else {
                System.out.println("高学年ですね! 進路についても考える時期ですね!");
            }
            
        } else if (e.getSource() == this.reset) {
            // 全てのチェックボックスを未選択に
            this.hobby1.setSelected(false);
            this.hobby2.setSelected(false);
            this.hobby3.setSelected(false);
            this.hobby4.setSelected(false);
            
            // 1年生を選択状態に
            this.grade1.setSelected(true);
            
            // 結果ラベルをリセット
            this.resultLabel.setText("結果がここに表示されます");
            System.out.println("リセットしました");
        }
    }

    public static void main(String[] args) {
        new SurveyApp();
    }
}
