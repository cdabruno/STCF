package ui.search_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AuctionUI {

	private JFrame frame;
	private JTextField textValue;
	private Date currentDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuctionUI window = new AuctionUI(args[0], args[1], Float.parseFloat(args[2]));
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
	public AuctionUI(String name, String playerName, Float value) {
		initialize(name, playerName, value);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String playerName, Float value) {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnNewBid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float newValue = Float.parseFloat(textValue.getText());
					if(newValue < value*1.05) {
						JOptionPane.showMessageDialog(frame, "Valor não é 5% maior que valor atual");
					} else {
						TeamOperations.newBid(name, playerName, newValue);
						lblCurrentValue.setText(Float.toString(newValue));
						currentDate = new Date();
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(frame, "Valor não é um número");
				}
				
			}
		});
		btnNewBid.setBounds(27, 278, 224, 44);
		frame.getContentPane().add(btnNewBid);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamOperations.cancelBids(name, playerName);
				frame.dispose();
			}
		});
		btnCancel.setBounds(27, 334, 224, 44);
		frame.getContentPane().add(btnCancel);
		
		textValue = new JTextField();
		textValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textValue.setBounds(27, 229, 224, 40);
		frame.getContentPane().add(textValue);
		textValue.setColumns(10);
		
		JLabel lblNewValue = new JLabel("Valor do lance:");
		lblNewValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewValue.setLabelFor(textValue);
		lblNewValue.setBounds(27, 197, 169, 35);
		frame.getContentPane().add(lblNewValue);
	}

}
