import java.awt.event.*;
import javax.swing.*;

public class AppTest5 extends JFrame implements ActionListener {
    private JButton button;
    private JButton button2;
    private JLabel label;

    public AppTest5() {
        super();
        // super.getContentPane().add(this.button); // nullレイアウトでは不要

        super.getContentPane().setLayout(null);

        this.button = new JButton("押してね☆");
        this.button.setBounds(50, 50, 120, 40);
        super.getContentPane().add(this.button);
        this.button.addActionListener(this);

        this.button2 = new JButton("こっちも押して");
        this.button2.setBounds(200, 50, 150, 40);
        super.getContentPane().add(this.button2);
        this.button2.addActionListener(this);

        this.label = new JLabel("ラベルです");
        this.label.setBounds(120, 150, 120, 30);
        super.getContentPane().add(this.label);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            this.button.setText("押された！");
            this.label.setText("左ボタンが押されました");
        } else if (e.getSource() == this.button2) {
            this.button2.setText("押された！！");
            this.label.setText("右ボタンが押されました");
        }
    }

    public static void main(String[] args) {
        AppTest5 a = new AppTest5();
        a.setSize(400, 300);
        a.setLocation(100, 100);
        a.setVisible(true);
    }
}
