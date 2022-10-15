package JFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	Color FFD4AB = new Color(255,212,171);
	Color FFAEA7 = new Color(255,174,167);
	Color E400B4 = new Color(228,0,180);
	JPanel adminMenu = new AdminMenu();
	JPanel userMenu = new UserMenu();

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
		lock.setBounds(83, 190, 32, 32);
		lock.setIcon(new ImageIcon(lockIcon.getImage().getScaledInstance(lock.getWidth(), 
				lock.getHeight(), Image.SCALE_SMOOTH)));
		label.add(lock);
		
		// -- Text & TextFields --
		JLabel userLabel = new JLabel("Ingrese su nombre de usuario");
		userLabel.setBounds(130, 60, 210, 20);
		userLabel.setFont(new Font("Inter",0,16));
		userLabel.setForeground(Color.black);
		label.add(userLabel);
		
		JTextField userTextField = new JTextField();
		userTextField.setBounds(130, 85, 260, 25);
		userTextField.setFont(new Font("Inter",0,14));
		userTextField.setForeground(Color.black);
		label.add(userTextField);
		
		JLabel passwordLabel = new JLabel("Ingrese su contraseña");
		passwordLabel.setBounds(130,170,160,20);
		passwordLabel.setFont(new Font("Inter",0,16));
		passwordLabel.setForeground(Color.black);
		label.add(passwordLabel);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(130, 200, 260, 25);
		passwordField.setFont(new Font("Inter",0,14));
		passwordField.setForeground(Color.black);
		label.add(passwordField);
		
		// -- Button --
		JButton button = new JButton("Iniciar sesión");
		button.setSize(170, 40);
		button.setLocation(horizontalCenter(button,mainPanel),400);
		button.setFont(new Font("Inter",0,16));
		button.setForeground(Color.black);
		
		// -- Action Listener --
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = userTextField.getText();
				System.out.println(username);
				if(username.equals("admin")) {
					getContentPane().removeAll();
					setContentPane(adminMenu);
					setTitle("Menú de Administrador");
				} else if(username.equals("user")) {
					getContentPane().removeAll();
					setContentPane(userMenu);
					setTitle("Menú de usuario");
				}
				repaint();
				revalidate();
			}
		});
		mainPanel.add(button);
		
		// -- Hyperlink --
		JLabel hyperlink = new JLabel("¡Registrate aquí!");
		hyperlink.setSize(108,22);
		hyperlink.setLocation(horizontalCenter(hyperlink,mainPanel),440);
		hyperlink.setFont(new Font("Inter",0,14));
		hyperlink.setForeground(Color.blue);
		hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// > Mouse Listener
		MouseListener mouse = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				setContentPane(userMenu);
				setTitle("Registro de usuario");
				revalidate();
				repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		};
		hyperlink.addMouseListener(mouse);
		mainPanel.add(hyperlink);
		
		
		
		
		// Add panel, pack & center frame on screen 
		this.add(mainPanel);
		this.pack(); 
		this.setLocationRelativeTo(null); 
	}
	public static int horizontalCenter(JComponent inside, JComponent outside) {
		double x = (outside.getPreferredSize().getWidth()-inside.getWidth())/2;
		return (int)Math.round(x);
	}
	public static int verticalCenter(JComponent inside, JComponent outside) {
		double y = (outside.getPreferredSize().getHeight()-inside.getHeight())/2;
		return (int)Math.round(y);
	}
}
