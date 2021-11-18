package ui.report_ui;

import database.*;
import database.player.Player;
import database.transaction.Transaction;
import database.user.team.Team;
import ui.account_ui.AccountUI;
import business.admin_operations.AdminOperations;
import business.search_operations.SearchPlayer;

import java.awt.Container;
import java.awt.EventQueue;
import java.io.BufferedWriter;
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
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Font;

public class ReportUI {

	private JFrame frame;
	private JTextField textBusca;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnGenerateCSV;
	private DefaultTableModel tableModel;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportUI window = new ReportUI();
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
	public ReportUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initSaveText() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv");
		fileChooser.setFileFilter(extFilter);
		fileChooser.setDialogTitle("Salvar");


		btnGenerateCSV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int userSelection = fileChooser.showSaveDialog(frame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					String text = AdminOperations.getPlayerTransactionsInformationCSV(AdminOperations.getPlayerTransactionInformationList());
					File file = fileChooser.getSelectedFile();
					if (!file.exists()) {
						String path = file.getAbsolutePath();
						int indexDot = path.indexOf('.');
						if (indexDot == -1) {
							path = path + ".csv";
							file = new File(path);
						} else if (path.length() - 1 == indexDot) {
							path = path.substring(0, path.lastIndexOf('.')) + ".csv";
							file = new File(path);
						}
						if (!file.exists()) {
							try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file.getAbsoluteFile(), false))) {
								bw.write(text);
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							int response = JOptionPane.showOptionDialog(new JFrame(), "Sobrescrever arquivo?",
									"Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
									new String[] { "Sim", "Não", }, null);
							if (response == 0) {
								try (BufferedWriter bw = new BufferedWriter(
										new FileWriter(file.getAbsoluteFile(), false))) {
									bw.write(text);
								} catch (IOException e2) {
									JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					} else {
						int response = JOptionPane.showOptionDialog(new JFrame(), "Sobrescrever arquivo?",
								"Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
								new String[] { "Sim", "N�o", }, null);
						if (response == 0) {
							try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(file.getAbsoluteFile(), false))) {
								bw.write(text);
							} catch (IOException e3) {
								JOptionPane.showMessageDialog(new JFrame(), "Erro ao escrever arquivo", "ERRO",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
	}
	
	
	private void fillTable() {
		//TODO preencher tabela com dados
		// receber lista de objetos de transa��o
		// jogador, time origem, time destino, tipo, valor
		ArrayList<Transaction> transactions = AdminOperations.getPlayerTransactionInformationList();
		for(Transaction transaction: transactions) {
			tableModel.addRow(new Object[]{transaction.getPlayer().getName(),
					transaction.getSourceTeam().getName(),
					transaction.getDestinationTeam().getName(),
					transaction.getType().toString(),
					transaction.getPrice()});
		}
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Relatório");
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 560, 337);
		table = new JTable();
		tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Time Origem", "Time Destino", "Tipo", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		
		fillTable();
		
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setVisible(true);
		frame.getContentPane().add(scrollPane);
		
		btnGenerateCSV = new JButton("Gerar CSV");
	
		btnGenerateCSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerateCSV.setBounds(222, 357, 135, 32);
		initSaveText();
		frame.getContentPane().add(btnGenerateCSV);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String tmp[] = {};
				AccountUI.main(tmp);
			}
		});
		btnLogout.setBounds(482, 365, 88, 21);
		frame.getContentPane().add(btnLogout);
	}
}
