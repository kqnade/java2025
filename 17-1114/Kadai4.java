import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Kadai4 extends JFrame implements ActionListener
{
    private JTextField tf1;
    private JButton btnOpen;
    private JButton btnSave;
    private JButton btnNew;
    private JButton btnSearch;
    private JTextArea ta1;
    private JLabel statusBar;
    private int charCount = 0;
    private int lineCount = 0;

    public Kadai4()
    {
        super("課題4: 高機能テキストエディタ");
        
        this.tf1 = new JTextField(25);
        this.btnOpen = new JButton("開く");
        this.btnOpen.addActionListener(this);
        this.btnSave = new JButton("保存");
        this.btnSave.addActionListener(this);
        this.btnNew = new JButton("新規作成");
        this.btnNew.addActionListener(this);
        this.btnSearch = new JButton("検索");
        this.btnSearch.addActionListener(this);
        
        this.ta1 = new JTextArea(25, 60);
        this.ta1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateStatus();
            }
        });
        
        this.statusBar = new JLabel("文字数: 0  行数: 0");
        this.statusBar.setBorder(BorderFactory.createEtchedBorder());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("ファイル名:"));
        topPanel.add(this.tf1);
        topPanel.add(this.btnOpen);
        topPanel.add(this.btnSave);
        topPanel.add(this.btnNew);
        topPanel.add(this.btnSearch);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(this.ta1), BorderLayout.CENTER);
        panel.add(this.statusBar, BorderLayout.SOUTH);
        
        super.getContentPane().add(panel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    private void updateStatus()
    {
        String text = this.ta1.getText();
        this.charCount = text.length();
        this.lineCount = text.isEmpty() ? 0 : text.split(System.getProperty("line.separator"), -1).length;
        this.statusBar.setText("文字数: " + this.charCount + "  行数: " + this.lineCount);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnOpen)
        {
            String filename = this.tf1.getText();
            if (filename.isEmpty())
            {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    filename = fileChooser.getSelectedFile().getAbsolutePath();
                    this.tf1.setText(filename);
                }
                else
                {
                    return;
                }
            }
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
                updateStatus();
                JOptionPane.showMessageDialog(this, "ファイルを開きました");
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(this, "ファイルの読み込みに失敗しました: " + ex.getMessage());
            }
        }
        else if (e.getSource() == this.btnSave)
        {
            String filename = this.tf1.getText();
            if (filename.isEmpty())
            {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    filename = fileChooser.getSelectedFile().getAbsolutePath();
                    this.tf1.setText(filename);
                }
                else
                {
                    return;
                }
            }
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
        else if (e.getSource() == this.btnNew)
        {
            this.ta1.setText("");
            this.tf1.setText("");
            updateStatus();
            JOptionPane.showMessageDialog(this, "新規ファイルを作成しました");
        }
        else if (e.getSource() == this.btnSearch)
        {
            String searchText = JOptionPane.showInputDialog(this, "検索する文字列を入力してください:");
            if (searchText != null && !searchText.isEmpty())
            {
                String content = this.ta1.getText();
                int index = content.indexOf(searchText);
                if (index != -1)
                {
                    this.ta1.setCaretPosition(index);
                    this.ta1.select(index, index + searchText.length());
                    JOptionPane.showMessageDialog(this, "文字列が見つかりました");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "文字列が見つかりませんでした");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Kadai4();
    }
}
