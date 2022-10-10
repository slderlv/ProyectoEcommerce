package Logic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Color FFD4AB = new Color(255,212,171);
	Color FFAEA7 = new Color(255,174,167);
	Color E400B4 = new Color(228,0,180);

	public LoginFrame(){
		// -- Basic Configuration --
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Inicio de sesión");
		
		// -- Panel --
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(700,500));
		mainPanel.setLayout(null);
		mainPanel.setBackground(FFD4AB);
		
		// -- Label --
		JLabel label = new JLabel();
		label.setBackground(FFAEA7);
		label.setSize(500,300);
		label.setOpaque(true);
		label.setLocation(horizontalCenter(label,mainPanel),50);
		//label.setLocation(0,verticalCenter(label,mainPanel));
		mainPanel.add(label);
		
		// -- ImageIcon --
		// 1) Person icon
		ImageIcon personIcon = new ImageIcon("person.png");
		JLabel person = new JLabel(personIcon);
		person.setBounds(80, 80, 32, 32);
		person.setIcon(new ImageIcon(personIcon.getImage().getScaledInstance(person.getWidth(), 
				person.getHeight(), Image.SCALE_SMOOTH)));
		label.add(person);
		
		// 2) Lock icon
		ImageIcon lockIcon = new ImageIcon("password.png");
		JLabel lock = new JLabel(lockIcon);
		lock.setBounds(85, 150, 32, 32);
		lock.setIcon(new ImageIcon(lockIcon.getImage().getScaledInstance(lock.getWidth(), 
				lock.getHeight(), Image.SCALE_SMOOTH)));
		label.add(lock);
		
		// Add panel, pack & center frame on screen 
		this.add(mainPanel);
		this.pack(); 
		this.setLocationRelativeTo(null); 
	}
	public static int horizontalCenter(JLabel label, JPanel panel) {
		double x = (panel.getPreferredSize().getWidth()-label.getWidth())/2;
		return (int)Math.round(x);
	}
	public static int verticalCenter(JLabel label, JPanel panel) {
		double y = (panel.getPreferredSize().getHeight()-label.getHeight())/2;
		return (int)Math.round(y);
	}
}
