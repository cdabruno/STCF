package ui.player_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import business.team_operations.TeamOperations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import business.team_operations.*;

public class AddPlayerUI {

	private JFrame frmAdicionarJogador;
	private JTextField textPlayerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlayerUI window = new AddPlayerUI(args[0], args[1]);
					window.frmAdicionarJogador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPlayerUI(String name, String password) {
		initialize(name, password);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String password) {
		frmAdicionarJogador = new JFrame();
		frmAdicionarJogador.setTitle("Adicionar Jogador");
		frmAdicionarJogador.setResizable(false);
		frmAdicionarJogador.setBounds(100, 100, 343, 253);
		frmAdicionarJogador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdicionarJogador.getContentPane().setLayout(null);
		
		textPlayerName = new JTextField();
		textPlayerName.setBounds(22, 65, 281, 48);
		frmAdicionarJogador.getContentPane().add(textPlayerName);
		textPlayerName.setColumns(10);
		
		JLabel lblblName = new JLabel("Nome:");
		lblblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblblName.setBounds(10, 10, 100, 45);
		frmAdicionarJogador.getContentPane().add(lblblName);
		
		JButton btnAddPlayer = new JButton("Adicionar\r\n");
		btnAddPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = textPlayerName.getText();
				if(TeamOperations.playerExists(name, playerName)) {
					JOptionPane.showMessageDialog(frmAdicionarJogador, "Já existe jogador com esse nome!");
				} else {
					TeamOperations.addPlayer(name, playerName);
					JOptionPane.showMessageDialog(frmAdicionarJogador, "Jogador adicionado com sucesso!");
					textPlayerName.setText("");
				}
			
			}
			
		});
		btnAddPlayer.setBounds(22, 142, 283, 45);
		frmAdicionarJogador.getContentPane().add(btnAddPlayer);
	}
}
