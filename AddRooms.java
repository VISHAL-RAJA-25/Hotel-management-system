package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener {

	JTextField roomNumberField, priceField;
	JComboBox<String> availabilityBox, cleaningStatusBox, bedTypeBox;
	JButton addButton, cancelButton;

	AddRooms() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel titleLabel = new JLabel("Add Rooms");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(150, 20, 200, 20);
		add(titleLabel);

		JLabel roomNumberLabel = new JLabel("Room Number:");
		roomNumberLabel.setBounds(50, 80, 100, 30);
		add(roomNumberLabel);

		roomNumberField = new JTextField();
		roomNumberField.setBounds(200, 80, 150, 30);
		add(roomNumberField);

		JLabel availabilityLabel = new JLabel("Availability:");
		availabilityLabel.setBounds(50, 130, 100, 30);
		add(availabilityLabel);

		availabilityBox = new JComboBox<>(new String[]{"Available", "Occupied"});
		availabilityBox.setBounds(200, 130, 150, 30);
		add(availabilityBox);

		JLabel cleaningStatusLabel = new JLabel("Cleaning Status:");
		cleaningStatusLabel.setBounds(50, 180, 100, 30);
		add(cleaningStatusLabel);

		cleaningStatusBox = new JComboBox<>(new String[]{"Clean", "Dirty"});
		cleaningStatusBox.setBounds(200, 180, 150, 30);
		add(cleaningStatusBox);

		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setBounds(50, 230, 100, 30);
		add(priceLabel);

		priceField = new JTextField();
		priceField.setBounds(200, 230, 150, 30);
		add(priceField);

		JLabel bedTypeLabel = new JLabel("Bed Type:");
		bedTypeLabel.setBounds(50, 280, 100, 30);
		add(bedTypeLabel);

		bedTypeBox = new JComboBox<>(new String[]{"Single", "Double"});
		bedTypeBox.setBounds(200, 280, 150, 30);
		add(bedTypeBox);

		addButton = new JButton("Add Room");
		addButton.setBounds(50, 350, 120, 30);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(this);
		add(addButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(200, 350, 120, 30);
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.addActionListener(this);
		add(cancelButton);

		setBounds(350, 200, 400, 450);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {
			String roomNumber = roomNumberField.getText();
			String availability = (String) availabilityBox.getSelectedItem();
			String cleaningStatus = (String) cleaningStatusBox.getSelectedItem();
			String price = priceField.getText();
			String bedType = (String) bedTypeBox.getSelectedItem();

			try {
				conn c = new conn();
				String str = "INSERT INTO rooms (room_number, availability, cleaning_status, price, bed_type) VALUES ('" + roomNumber + "', '" + availability + "', '" + cleaningStatus + "', '" + price + "', '" + bedType + "')";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Room Added Successfully");
				this.setVisible(false);
			} catch (SQLException e) {
				if (e.getErrorCode() == 1062) {
					JOptionPane.showMessageDialog(null, "Room Number already exists.");
				} else {
					e.printStackTrace();
				}
			}
		} else if (ae.getSource() == cancelButton) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddRooms();
	}
}
