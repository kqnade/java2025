import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kadai1 extends JFrame implements ActionListener
{
    private JTextField tf1;
    private JTextArea ta1;

    public Kadai1()
    {
        super("課題1: テキスト追加プログラム");
        
        this.tf1 = new JTextField(30);
        this.tf1.addActionListener(this);
        
        this.ta1 = new JTextArea(20, 40);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(this.tf1, BorderLayout.NORTH);
        panel.add(new JScrollPane(this.ta1), BorderLayout.CENTER);
        
        super.getContentPane().add(panel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.tf1)
        {
            String s = this.tf1.getText();
            this.ta1.append(s);
            this.ta1.append(System.getProperty("line.separator"));
            this.tf1.setText("");
        }
    }

    public static void main(String[] args)
    {
        new Kadai1();
    }
}
