package ui.player_management;

import ui.account_ui.*;
import ui.search_ui.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerManagementUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerManagementUI window = new PlayerManagementUI(args[0], args[1]);
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
	public PlayerManagementUI(String name, String password) {
		initialize(name, password);
	}


	private void openAddPlayerUI(String[] args) {
		AddPlayerUI.main(args);
	}

	private void openReturnPlayerUI(String[] args) {
		ReturnPlayerUI.main(args);
	}

	private void openAddToListUI(String[] args) {
		AddToListUI.main(args);
	}

	private void logout(String[] args) {
		AccountUI.main(args);
		frame.dispose();
	}

	private void openSearchUI(String[] args) {
		SearchUI.main(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String password) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 241, 538);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciamento de Jogadores");
		JButton btnAddPlayer = new JButton("Adicionar Jogador");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {name, password};
				openAddPlayerUI(args);
	
			}
		});
		btnAddPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddPlayer.setBounds(26, 93, 170, 53);
		frame.getContentPane().add(btnAddPlayer);
		
		JButton btnReturnPlayer = new JButton("Devolver Jogador");
		btnReturnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {name, password};
				openReturnPlayerUI(args);
			}
		});
		btnReturnPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReturnPlayer.setBounds(26, 156, 170, 53);
		frame.getContentPane().add(btnReturnPlayer);
		
		JButton btnAddToList = new JButton("Colocar para transferência");
		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {name, password};
				openAddToListUI(args);
			}
		});
		btnAddToList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddToList.setBounds(26, 219, 170, 53);
		frame.getContentPane().add(btnAddToList);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				logout(args);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(26, 400, 170, 45);
		frame.getContentPane().add(btnLogout);
		
		JButton btnSearch = new JButton("Buscar Jogadores");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {name, password};
				openSearchUI(args);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(26, 282, 170, 43);
		frame.getContentPane().add(btnSearch);
	}
}
