package ui.player_management;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class AddToListUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToListUI window = new AddToListUI();
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
	public AddToListUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 315, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 24, 233, 328);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
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
		
		JButton btnAddToTransfer = new JButton("Adicionar na lista de transferência");
		btnAddToTransfer.setBounds(34, 402, 233, 39);
		frame.getContentPane().add(btnAddToTransfer);
		
		JLabel lblValue = new JLabel("Valor:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValue.setBounds(34, 362, 55, 30);
		frame.getContentPane().add(lblValue);
		
		
		
		NumberFormatter formatter = new NumberFormatter(java.text.NumberFormat.getCurrencyInstance());
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		formattedTextField.setBounds(74, 362, 193, 27);
		frame.getContentPane().add(formattedTextField);
	}
}

class ValueFormatter extends NumberFormatter {
	 ValueFormatter(NumberFormat nf) {
		 super(nf);
	 }
	@Override
	public Object stringToValue(String text) throws ParseException {
		// TODO Auto-generated method stub
		if(text.length() == 0) {
			return null;
		} else {
			return super.stringToValue(text);
		}
	}
}
