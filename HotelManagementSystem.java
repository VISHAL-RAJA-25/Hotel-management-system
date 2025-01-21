package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

	JLabel titleLabel;

	HotelManagementSystem() {
		setBounds(300, 130, 900, 600);
		ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/first.jpg"));
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, 900, 600);
		add(backgroundLabel);
		titleLabel = new JLabel("Hotel Management System");
		titleLabel.setBounds(110, 20, 1000, 70);
		titleLabel.setFont(new Font("serif", Font.PLAIN, 60));
		titleLabel.setForeground(Color.red);
		backgroundLabel.add(titleLabel);
		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(Color.white);
		enterButton.setForeground(Color.black);
		enterButton.setBounds(360, 250, 180, 50);
		enterButton.addActionListener(this);
		backgroundLabel.add(enterButton);
		setLayout(null);
		setVisible(true);


	}

	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}
}
