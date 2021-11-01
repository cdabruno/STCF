package ui.player_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AddPlayerUI {

	private JFrame frame;
	private JTextField textPlayerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlayerUI window = new AddPlayerUI();
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
	public AddPlayerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textPlayerName = new JTextField();
		textPlayerName.setBounds(22, 65, 281, 48);
		frame.getContentPane().add(textPlayerName);
		textPlayerName.setColumns(10);
		
		JLabel lblblName = new JLabel("Nome:");
		lblblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblblName.setBounds(10, 10, 100, 45);
		frame.getContentPane().add(lblblName);
		
		JButton btnAddPlayer = new JButton("Adicionar\r\n");
		btnAddPlayer.setBounds(22, 142, 283, 45);
		frame.getContentPane().add(btnAddPlayer);
	}
}
