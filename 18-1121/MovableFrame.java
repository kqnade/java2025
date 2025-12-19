import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MovableFrame extends JFrame implements ChangeListener {
    private MovablePanel mp;
    private JSlider slider1;
    private JTextField textField;

    public MovableFrame() {
        this.mp = new MovablePanel();
        
        // スライダーを作成
        this.slider1 = new JSlider(10, 200, 50);
        this.slider1.setMajorTickSpacing(50);
        this.slider1.setMinorTickSpacing(10);
        this.slider1.setPaintTicks(true);
        this.slider1.setPaintLabels(true);
        this.slider1.addChangeListener(this);
        
        // テキストフィールドを作成
        this.textField = new JTextField(5);
        this.textField.setEditable(false);
        this.textField.setText("" + this.slider1.getValue());
        
        // 配置用のパネル
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Size:"));
        controlPanel.add(this.slider1);
        controlPanel.add(this.textField);
        
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        
        super.getContentPane().add(panel1, BorderLayout.CENTER);
        super.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        
        super.setTitle("Movable Graphics");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.slider1) {
            int val = this.slider1.getValue();
            this.textField.setText("" + val);
            this.mp.setSize(val);
            this.mp.repaint();
        }
    }

    public static void main(String[] args) {
        new MovableFrame();
    }
}
