import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderTextFieldLink extends JFrame implements ChangeListener {
    private JSlider slider;
    private JTextField textField;

    public SliderTextFieldLink() {
        super.setTitle("Slider and TextField Link");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JSlider
        slider = new JSlider(0, 100, 50); // min, max, initial
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this); // Add ChangeListener to itself

        // Create JTextField
        textField = new JTextField(5); // 5 columns wide
        textField.setEditable(false); // Make it read-only
        textField.setText(String.valueOf(slider.getValue())); // Set initial value

        // Layout components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(slider);
        panel.add(textField);

        super.getContentPane().add(panel, BorderLayout.CENTER);
        super.pack();
        super.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider) {
            textField.setText(String.valueOf(slider.getValue()));
        }
    }

    public static void main(String[] args) {
        new SliderTextFieldLink();
    }
}
