package ui.player_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnPlayerUI {

	private JFrame frmDevolverJogador;
	private JList<String> list;
	private DefaultListModel<String> model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnPlayerUI window = new ReturnPlayerUI(args[0], args[1]);
					window.frmDevolverJogador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReturnPlayerUI(String name, String password) {
		initialize(name, password);
	}

	
	private void getBorrowedPlayers(String name) {
		ArrayList<Player> borrowed = TeamOperations.getBorrowedPlayers(name);
		model.removeAllElements();
		for ( int i = 0; i < borrowed.length; i++ ) {
			  model.addElement( borrowed[i].getName() );
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize(String name, String password) {
		frmDevolverJogador = new JFrame();
		frmDevolverJogador.setTitle("Devolver Jogador");
		frmDevolverJogador.setResizable(false);
		frmDevolverJogador.setBounds(100, 100, 315, 488);
		frmDevolverJogador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDevolverJogador.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 24, 233, 328);
		frmDevolverJogador.getContentPane().add(scrollPane);
		
		model = new DefaultListModel<>();
		list = new JList<>( model );

		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Nome"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		getBorrowedPlayers(name);
		JButton btnReturn = new JButton("Devolver");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = (String) list.getSelectedValue();
				TeamOperations.returnPlayer(name, playerName);
				JOptionPane.showMessageDialog(frmDevolverJogador, "Jogador devolvido com sucesso!");
				getBorrowedPlayers(name);
			}
		});
		btnReturn.setBounds(34, 375, 233, 39);
		frmDevolverJogador.getContentPane().add(btnReturn);
	}
}
