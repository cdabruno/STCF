package ui.search_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AuctionUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuctionUI window = new AuctionUI(args[0], Float.parseFloat(args[1]));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuctionUI(String name, Float value) {
		initialize(name, value);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, Float value) {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayerName = new JLabel(name);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayerName.setBounds(27, 46, 224, 44);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblCurrentValue = new JLabel(value.toString());
		lblCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentValue.setBounds(27, 100, 122, 35);
		frame.getContentPane().add(lblCurrentValue);
		
		JButton btnNewBid = new JButton("Novo Lance");
		btnNewBid.setBounds(27, 278, 224, 44);
		frame.getContentPane().add(btnNewBid);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(27, 334, 224, 44);
		frame.getContentPane().add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(27, 229, 224, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewValue = new JLabel("Valor do lance:");
		lblNewValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewValue.setLabelFor(textField);
		lblNewValue.setBounds(27, 197, 169, 35);
		frame.getContentPane().add(lblNewValue);
	}

}
