package views;

import java.util.Date;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	//os objetos abaixo ser�o manipulados pela classe Login
	JButton btnUsuarios;
	JButton btnRelatorios;
	JLabel lblData;
	JLabel lblUsuario;
	JPanel panelUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.LONG);
				lblData.setText(formatador.format(data));
			}
		});
		setTitle("Controle de estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setBorderPainted(false);
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setBounds(36, 36, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnFornecedor = new JButton("");
		btnFornecedor.setBorderPainted(false);
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.setContentAreaFilled(false);
		btnFornecedor.setIcon(new ImageIcon(Main.class.getResource("/img/supliers.png")));
		btnFornecedor.setToolTipText("Fornecedores");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedor.setBounds(225, 36, 128, 128);
		contentPane.add(btnFornecedor);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorderPainted(false);
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/products.png")));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setBounds(426, 36, 128, 128);
		contentPane.add(btnProdutos);
		
		JButton btnClientes = new JButton("");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/clientes.png")));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setBounds(58, 193, 128, 128);
		contentPane.add(btnClientes);
		
		btnRelatorios = new JButton("");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/report.png")));
		btnRelatorios.setToolTipText("Relat\u00F3rios");
		btnRelatorios.setEnabled(false);
		btnRelatorios.setBounds(244, 193, 128, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  Sobre sobre = new Sobre();
			  sobre.setVisible(true);
			}
		});
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorderPainted(false);
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/about.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(443, 193, 128, 128);
		contentPane.add(btnSobre);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.textHighlight);
		panelUsuario.setBounds(0, 332, 609, 71);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 73, 40);
		panelUsuario.add(lblNewLabel);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(104, 0, 190, 51);
		panelUsuario.add(lblUsuario);
		
		lblData = new JLabel("");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(350, 0, 256, 51);
		panelUsuario.add(lblData);
	}//fim do construtor
}//fim do c�digo
