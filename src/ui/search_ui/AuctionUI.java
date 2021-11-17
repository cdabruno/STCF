package ui.search_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import business.team_operations.TeamOperations;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class AuctionUI {

	private JFrame frame;
	private JTextField textValue;
	private Date currentDate;
	protected float bidValue;

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
		frame.setTitle("Leilão");
		
		bidValue = value;
		
		JLabel lblPlayerName = new JLabel(playerName);
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
					if(newValue < bidValue*1.05) {
						JOptionPane.showMessageDialog(frame, "Valor não é 5% maior que valor atual");
					} else {
						TeamOperations.newBid(name, playerName, newValue);
						lblCurrentValue.setText(Float.toString(newValue));
						currentDate = new Date();
						bidValue = newValue;
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
		
		currentDate = new Date();
		
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
				long ONE_MINUTE_IN_MILLIS=60000;
				long t= currentDate.getTime();
				Date endDate=new Date(t + (ONE_MINUTE_IN_MILLIS));
				while(new Date().before(endDate)) {
					lblPlayerName.setText(playerName +" "+ TimeUnit.MILLISECONDS.toSeconds(endDate.getTime() - new Date().getTime()) + "s");
					t= currentDate.getTime();
					endDate=new Date(t + (ONE_MINUTE_IN_MILLIS));
				}
				
				
				if(TeamOperations.getLastBidTeam(playerName).equals(name)) {
					JOptionPane.showMessageDialog(frame, "Você Venceu o leilão");
				} else {
					JOptionPane.showMessageDialog(frame, "Leilão acabou. Outro Time adquiriu o jogador.");
				}
				
				TeamOperations.endAuction(playerName);
				frame.dispose();

			    return null;
			}
		};
		
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	TeamOperations.cancelBids(name, playerName);
		    	worker.cancel(true);
				frame.dispose();
		    }
		};
		frame.addWindowListener(exitListener);
		
		
		worker.execute();
		
		TeamOperations.newBid(name, playerName, value);
	}

}
