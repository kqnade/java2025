import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Kadai3 extends JFrame implements ActionListener
{
    private JTextField tf1;
    private JButton btnOpen;
    private JButton btnSave;
    private JTextArea ta1;

    public Kadai3()
    {
        super("課題3: テキストエディタ(保存機能付き)");
        
        this.tf1 = new JTextField(30);
        this.btnOpen = new JButton("ファイルを開く");
        this.btnOpen.addActionListener(this);
        this.btnSave = new JButton("保存");
        this.btnSave.addActionListener(this);
        
        this.ta1 = new JTextArea(20, 50);
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("ファイル名:"));
        topPanel.add(this.tf1);
        topPanel.add(this.btnOpen);
        topPanel.add(this.btnSave);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(this.ta1), BorderLayout.CENTER);
        
        super.getContentPane().add(panel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnOpen)
        {
            String filename = this.tf1.getText();
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null)
                {
                    sb.append(line);
                    sb.append(System.getProperty("line.separator"));
                }
                br.close();
                this.ta1.setText(sb.toString());
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(this, "ファイルの読み込みに失敗しました: " + ex.getMessage());
            }
        }
        else if (e.getSource() == this.btnSave)
        {
            String filename = this.tf1.getText();
            String content = this.ta1.getText();
            try
            {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
                bw.write(content);
                bw.close();
                JOptionPane.showMessageDialog(this, "ファイルを保存しました");
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(this, "ファイルの保存に失敗しました: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        new Kadai3();
    }
}
