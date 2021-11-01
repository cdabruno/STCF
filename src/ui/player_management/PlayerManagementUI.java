package ui.player_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayerManagementUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerManagementUI window = new PlayerManagementUI();
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
	public PlayerManagementUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 275, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciamento de Jogadores");
		JButton btnAddPlayer = new JButton("Adicionar Jogador");
		btnAddPlayer.setBounds(26, 93, 170, 53);
		frame.getContentPane().add(btnAddPlayer);
		
		JButton btnReturnPlayer = new JButton("Devolver Jogador");
		btnReturnPlayer.setBounds(26, 156, 170, 53);
		frame.getContentPane().add(btnReturnPlayer);
		
		JButton btnAddToList = new JButton("Colocar para transferência");
		btnAddToList.setBounds(26, 219, 170, 53);
		frame.getContentPane().add(btnAddToList);
	}
}
