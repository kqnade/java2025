import javax.swing.*;
public class AppTest2 extends JFrame {
	private JButton button;
	public AppTest2() {
		super();
		this.button = new JButton("wahaha");
		super.getContentPane().add(this.button);
	}
	public static void main(String[] args) {
		AppTest2 a = new AppTest2();
		a.setSize(1600,900);
		a.setLocation(0,0);
		a.setVisible(true);
	}
}
