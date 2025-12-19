import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsFrame extends JFrame implements ChangeListener, ActionListener {
    private GraphicsPanel gp;
    private JSlider xSlider;
    private JSlider ySlider;
    private JSlider sizeSlider;
    private JTextField xField;
    private JTextField yField;
    private JTextField sizeField;
    private JCheckBox circleCheck;
    private JCheckBox squareCheck;
    private JCheckBox triangleCheck;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;

    public GraphicsFrame() {
        this.gp = new GraphicsPanel();
        
        // X座標用スライダーとテキストフィールド
        this.xSlider = new JSlider(0, 640, 320);
        this.xSlider.addChangeListener(this);
        this.xField = new JTextField(5);
        this.xField.setEditable(false);
        this.xField.setText("" + this.xSlider.getValue());
        
        // Y座標用スライダーとテキストフィールド
        this.ySlider = new JSlider(0, 480, 240);
        this.ySlider.addChangeListener(this);
        this.yField = new JTextField(5);
        this.yField.setEditable(false);
        this.yField.setText("" + this.ySlider.getValue());
        
        // サイズ用スライダーとテキストフィールド
        this.sizeSlider = new JSlider(10, 200, 50);
        this.sizeSlider.addChangeListener(this);
        this.sizeField = new JTextField(5);
        this.sizeField.setEditable(false);
        this.sizeField.setText("" + this.sizeSlider.getValue());
        
        // チェックボックス
        this.circleCheck = new JCheckBox("Circle", true);
        this.circleCheck.addActionListener(this);
        this.squareCheck = new JCheckBox("Square", false);
        this.squareCheck.addActionListener(this);
        this.triangleCheck = new JCheckBox("Triangle", false);
        this.triangleCheck.addActionListener(this);
        
        // 色変更ボタン
        this.redButton = new JButton("Red");
        this.redButton.addActionListener(this);
        this.greenButton = new JButton("Green");
        this.greenButton.addActionListener(this);
        this.blueButton = new JButton("Blue");
        this.blueButton.addActionListener(this);
        
        // レイアウト
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        
        JPanel xPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        xPanel.add(new JLabel("X:"));
        xPanel.add(this.xSlider);
        xPanel.add(this.xField);
        
        JPanel yPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yPanel.add(new JLabel("Y:"));
        yPanel.add(this.ySlider);
        yPanel.add(this.yField);
        
        JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sizePanel.add(new JLabel("Size:"));
        sizePanel.add(this.sizeSlider);
        sizePanel.add(this.sizeField);
        
        JPanel shapePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        shapePanel.add(new JLabel("Shape:"));
        shapePanel.add(this.circleCheck);
        shapePanel.add(this.squareCheck);
        shapePanel.add(this.triangleCheck);
        
        JPanel colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(this.redButton);
        colorPanel.add(this.greenButton);
        colorPanel.add(this.blueButton);
        
        controlPanel.add(xPanel);
        controlPanel.add(yPanel);
        controlPanel.add(sizePanel);
        controlPanel.add(shapePanel);
        controlPanel.add(colorPanel);
        
        JPanel drawPanel = new JPanel();
        drawPanel.add(this.gp);
        
        super.getContentPane().add(drawPanel, BorderLayout.CENTER);
        super.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        
        super.setTitle("Interactive Graphics");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.xSlider) {
            int val = this.xSlider.getValue();
            this.xField.setText("" + val);
            this.gp.setXPos(val);
            this.gp.repaint();
        } else if (e.getSource() == this.ySlider) {
            int val = this.ySlider.getValue();
            this.yField.setText("" + val);
            this.gp.setYPos(val);
            this.gp.repaint();
        } else if (e.getSource() == this.sizeSlider) {
            int val = this.sizeSlider.getValue();
            this.sizeField.setText("" + val);
            this.gp.setSize(val);
            this.gp.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.circleCheck) {
            this.gp.setDrawCircle(this.circleCheck.isSelected());
            this.gp.repaint();
        } else if (e.getSource() == this.squareCheck) {
            this.gp.setDrawSquare(this.squareCheck.isSelected());
            this.gp.repaint();
        } else if (e.getSource() == this.triangleCheck) {
            this.gp.setDrawTriangle(this.triangleCheck.isSelected());
            this.gp.repaint();
        } else if (e.getSource() == this.redButton) {
            this.gp.setShapeColor(Color.red);
            this.gp.repaint();
        } else if (e.getSource() == this.greenButton) {
            this.gp.setShapeColor(Color.green);
            this.gp.repaint();
        } else if (e.getSource() == this.blueButton) {
            this.gp.setShapeColor(Color.blue);
            this.gp.repaint();
        }
    }

    public static void main(String[] args) {
        new GraphicsFrame();
    }
}
