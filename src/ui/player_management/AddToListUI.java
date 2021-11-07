package ui.player_management;

import java.awt.EventQueue;
import java.awt.Font;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;

import business.team_operations.TeamOperations;
import java.util.ArrayList;
import database.player.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddToListUI {

	private JFrame frame;
	private JTextField textValue;
	private JList<String> list;
	private DefaultListModel<String> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToListUI window = new AddToListUI(args[0], args[1]);
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
	public AddToListUI(String name, String password) {
		initialize(name, password);
	}

	private void getPlayersNotOnList(String name) {
		ArrayList<Player> notListed = TeamOperations.getPlayersNotOnList(name);
		model.removeAllElements();
		for ( int i = 0; i < notListed.size(); i++ ) {
			  model.addElement( notListed.get(i).getName() );
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String password) {
		frame = new JFrame();
		frame.setBounds(100, 100, 315, 488);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Colocar na Lista");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 24, 233, 328);
		frame.getContentPane().add(scrollPane);
		
		model = new DefaultListModel<>();
		list = new JList<>( model );

		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		/*
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"DALESON"};
			public int getSize() {
				return values.size;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnAddToTransfer = new JButton("Adicionar na lista de transferência");
		btnAddToTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Float value = Float.parseFloat(textValue.getText());
					String playerName = (String) list.getSelectedValue();
					TeamOperations.putOnList(name, playerName, value);
					JOptionPane.showMessageDialog(frame, "Jogador adicionado à lista de transferência com sucesso!");
					getPlayersNotOnList(name);
				} catch(NumberFormatException exc){
					JOptionPane.showMessageDialog(frame, "Deve ser um valor numérico");
				}
			}
		});
		btnAddToTransfer.setBounds(34, 402, 233, 39);
		frame.getContentPane().add(btnAddToTransfer);
		
		JLabel lblValue = new JLabel("Valor:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValue.setBounds(34, 362, 55, 30);
		frame.getContentPane().add(lblValue);
		
		textValue = new JTextField();
		textValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textValue.setBounds(81, 362, 186, 30);
		frame.getContentPane().add(textValue);
		textValue.setColumns(10);
		
		getPlayersNotOnList(name);
		
		
	}
}
