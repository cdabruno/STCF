package ui.search_ui;

import database.*;
import database.player.Player;
import database.user.team.Team;
import business.search_operations.SearchPlayer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchUI {

	private JFrame frmBusca;
	private JTextField textBusca;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUI window = new SearchUI();
					window.frmBusca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void search() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Map<Player, Team> resultMap = SearchPlayer.search(textBusca.getText());
		if (resultMap.size() == 0) {
			scrollPane.setVisible(false);
		} else {
			for (Player p : resultMap.keySet()) {
				model.addRow(new Object[] { p.getName(), resultMap.get(p).getName(), p.getCurrentValue() });
			}

			scrollPane.setVisible(true);
		}
	}

	private void initialize() {
		frmBusca = new JFrame();
		frmBusca.setTitle("Busca");
		frmBusca.setBounds(100, 100, 545, 472);
		frmBusca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusca.getContentPane().setLayout(null);

		textBusca = new JTextField();
		textBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					search();
				}
			}
		});
		textBusca.setBounds(139, 24, 344, 24);
		frmBusca.getContentPane().add(textBusca);
		textBusca.setColumns(10);

		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();

			}
		});
		btnSearch.setBounds(20, 25, 95, 21);
		frmBusca.getContentPane().add(btnSearch);

		JButton btnBuy = new JButton("Comprar");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] teste = {"gladson", "123"};
				AuctionUI.main(teste);
			}
		});
		btnBuy.setBounds(42, 390, 85, 21);
		frmBusca.getContentPane().add(btnBuy);

		JButton btnLoan = new JButton("Pedir Empr\u00E9stimo");
		btnLoan.setBounds(286, 390, 180, 21);
		frmBusca.getContentPane().add(btnLoan);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 463, 295);
		frmBusca.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Time", "Valor" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setVisible(false);
		
	}
}
