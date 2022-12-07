package views;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Relatorios extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Relatorios() {
		setTitle("Relat\u00F3rios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 602, 369);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Reposi\u00E7\u00E3o.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setToolTipText("Relat\u00F3rios de Reposi\u00E7\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reposicaoEstoque();
			}
		});
		btnNewButton.setBounds(10, 11, 128, 128);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/clientes.png")));
		btnNewButton_1.setToolTipText("Relat\u00F3rios de Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				impressaoClientes();
			}
		});
		btnNewButton_1.setBounds(286, 11, 128, 128);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(Relatorios.class.getResource("/img/supliers.png")));
		btnNewButton_2.setToolTipText("Relat\u00F3rios de Fornecedores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnNewButton_2.setBounds(148, 11, 128, 128);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setIcon(new ImageIcon(Relatorios.class.getResource("/img/products.png")));
		btnNewButton_3.setToolTipText("Relat\u00F3rios de Produtos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatoriosProdutos();
			}
		});
		btnNewButton_3.setBounds(447, 196, 128, 128);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setIcon(new ImageIcon(Relatorios.class.getResource("/img/users.png")));
		btnNewButton_4.setToolTipText("Relat\u00F3rio de Usuarios");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroUsuarios();
			}
		});
		btnNewButton_4.setBounds(294, 196, 128, 128);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Relatorios.class.getResource("/img/produtinhos vencidos.png")));
		btnNewButton_5.setToolTipText("Relat\u00F3rios de Produtos Vencidos");
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutosVencidos();
			}
		});
		btnNewButton_5.setBounds(447, 11, 128, 128);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setIcon(new ImageIcon(Relatorios.class.getResource("/img/pre\u00E7o.png")));
		btnNewButton_6.setToolTipText("Relat\u00F3rio de Calcular Pre\u00E7o");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularPreco();
			}
		});
		btnNewButton_6.setBounds(10, 196, 128, 128);
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Inventario de Estoque.png")));
		btnNewButton_7.setToolTipText("Relat\u00F3rio de Inventario De Estoque");
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			invEst();
			}
		});
		btnNewButton_7.setBounds(153, 196, 128, 128);
		getContentPane().add(btnNewButton_7);

	}//fim do construtor
	
	DAO dao = new DAO();
	
	
	
	private void invEst() {
		//System.out.println("teste");
		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("inventario.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			//document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Inventário de Estoque"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(1);//(5) = número de colunas
			//Cabeçalho da tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Total"));
			tabela.addCell(col1);
			// Acessar o banco de dados
			String relReposicao = "select sum(estoque * custo) from produtos;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();
				//Enquanto houver dados na tabela do banco (obter o valor)
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("inventario.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void precVend() {
		System.out.println("teste");
		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("lucro.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			//document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Lucro"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);//(5) = número de colunas
			//Cabeçalho da tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Custo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Lucro"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// Acessar o banco de dados
			String relReposicao = "select codigo,produto,custo,(custo  + (custo * lucro)/100) from produtos";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();
				//Enquanto houver dados na tabela do banco (obter o valor)
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("lucro.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void calcularPreco() {
		
		//criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("CalcularPreço.pdf"));
			document.open();
			//gerar o conteúdo do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Produtos Vencidos"));
			document.add(new Paragraph(" "));
			//... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Custo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Lucro"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relCalcularPreço = "select codigo, produto, custo,\r\n"
					+ "(custo + (custo * lucro) / 100)\r\n"
					+ "from produtos;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relCalcularPreço);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o código independente do resultado OK ou não
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("CalcularPreço.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void ProdutosVencidos() {
		//criar objeto para construir a página pdf
				Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
				//gerar o documento pdf
				try {
					//cria um documento pdf em branco de nome clientes.pdf
					PdfWriter.getInstance(document, new FileOutputStream("ProdutosVencidos.pdf"));
					document.open();
					//gerar o conteúdo do documento
					Date data = new Date();			
			        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					document.add(new Paragraph(new Paragraph(formatador.format(data))));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("Produtos Vencidos"));
					document.add(new Paragraph(" "));
					//... Demais conteúdos (imagem, tabela, gráfico, etc)
					PdfPTable tabela = new PdfPTable(5);
					PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
					PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
					PdfPCell col3 = new PdfPCell(new Paragraph("Localização"));
					PdfPCell col4 = new PdfPCell(new Paragraph("Data de Validade"));
					PdfPCell col5 = new PdfPCell(new Paragraph("Dias Vencidos"));
					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					tabela.addCell(col5);
					// Acessar o banco de dados
					String relUsuarios = "select codigo, produto, localizacao,\r\n"
							+ "date_format(dataval, '%d/%m/%Y'),\r\n"
							+ "datediff(dataval,curdate())  \r\n"
							+ "from produtos where datediff(dataval,curdate()) < 0";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(relUsuarios);
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							tabela.addCell(rs.getString(1));
							tabela.addCell(rs.getString(2));
							tabela.addCell(rs.getString(3));
							tabela.addCell(rs.getString(4));
						}				
						
					} catch (Exception e) {
						System.out.println(e);
					}
					//Adicionar a tabela ao documento pdf
					document.add(tabela);
				} catch (Exception e) {
					System.out.println(e);
				} finally { //executa o código independente do resultado OK ou não
					document.close();
				}
				
				//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
				try {
					Desktop.getDesktop().open(new File("ProdutosVencidos.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	
	
	private void cadastroUsuarios() {
		//criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("usuários.pdf"));
			document.open();
			//gerar o conteúdo do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Usuários cadastrados"));
			document.add(new Paragraph(" "));
			//... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
			PdfPCell col2 = new PdfPCell(new Paragraph("nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Login"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Senha"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relUsuarios = "select * from usuario;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relUsuarios);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o código independente do resultado OK ou não
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("usuários.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void relatoriosProdutos() {
		//criar objeto para construir a página pdf
				Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
				//gerar o documento pdf
				try {
					//cria um documento pdf em branco de nome clientes.pdf
					PdfWriter.getInstance(document, new FileOutputStream("produtos.pdf"));
					document.open();
					//gerar o conteúdo do documento
					Date data = new Date();			
			        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					document.add(new Paragraph(new Paragraph(formatador.format(data))));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("Produtos cadastrados"));
					document.add(new Paragraph(" "));
					//... Demais conteúdos (imagem, tabela, gráfico, etc)
					PdfPTable tabela = new PdfPTable(4);
					PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
					PdfPCell col2 = new PdfPCell(new Paragraph("Código De Barra"));
					PdfPCell col3 = new PdfPCell(new Paragraph("Produto"));
					PdfPCell col4 = new PdfPCell(new Paragraph("Descrição"));
					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					// Acessar o banco de dados
					String relProdutos = "select * from produtos inner join fornecedores\r\n"
							+ "on produtos.idFor = fornecedores.IdFor";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(relProdutos);
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							tabela.addCell(rs.getString(1));
							tabela.addCell(rs.getString(2));
							tabela.addCell(rs.getString(3));
							tabela.addCell(rs.getString(4));
						}				
						
					} catch (Exception e) {
						System.out.println(e);
					}
					//Adicionar a tabela ao documento pdf
					document.add(tabela);
				} catch (Exception e) {
					System.out.println(e);
				} finally { //executa o código independente do resultado OK ou não
					document.close();
				}
				
				//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
				try {
					Desktop.getDesktop().open(new File("produtos.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	
	
	private void relatorioFornecedores() {
		//criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("fornecedor.pdf"));
			document.open();
			//gerar o conteúdo do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Fornecedores cadastrados"));
			document.add(new Paragraph(" "));
			//... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Descrição"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relFornecedor = "select idFor as ID, fantasia as Fornecedor, Fone, nomecontato as contato from fornecedores where fantasia like ('k%');";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relFornecedor);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o código independente do resultado OK ou não
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("fornecedor.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void impressaoClientes() {
		//criar objeto para construir a página pdf
				Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
				//gerar o documento pdf
				try {
					//cria um documento pdf em branco de nome clientes.pdf
					PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
					document.open();
					//gerar o conteúdo do documento
					Date data = new Date();			
			        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					document.add(new Paragraph(new Paragraph(formatador.format(data))));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("Clientes cadastrados"));
					document.add(new Paragraph(" "));
					//... Demais conteúdos (imagem, tabela, gráfico, etc)
					PdfPTable tabela = new PdfPTable(4);
					PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
					PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
					PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
					PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
					tabela.addCell(col1);
					tabela.addCell(col2);
					tabela.addCell(col3);
					tabela.addCell(col4);
					// Acessar o banco de dados
					String relClientes = "select nomeCliente,fone1,cnpjcpf,email from clientes";
					try {
						Connection con = dao.conectar();
						PreparedStatement pst = con.prepareStatement(relClientes);
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							tabela.addCell(rs.getString(1));
							tabela.addCell(rs.getString(2));
							tabela.addCell(rs.getString(3));
							tabela.addCell(rs.getString(4));
						}				
						
					} catch (Exception e) {
						System.out.println(e);
					}
					//Adicionar a tabela ao documento pdf
					document.add(tabela);
				} catch (Exception e) {
					System.out.println(e);
				} finally { //executa o código independente do resultado OK ou não
					document.close();
				}
				
				//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
				try {
					Desktop.getDesktop().open(new File("clientes.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
	
	
	private void reposicaoEstoque () {
		//criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			//gerar o conteúdo do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
	        //document.add (adicionar paragrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Reposição de estoque"));
			document.add(new Paragraph(" "));
			
			//... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(5);//(5)colunas
			//cabeçalho da tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Estoque mínimo"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			// Acessar o banco de dados
			String relReposicao = "select codigo,produto,date_format(dataval,'%d/%m/%Y'), estoque, estoquemin from produtos where estoque < estoquemin";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();
				//enquanto houver dados na tabela do banco (obter o valor)
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o código independente do resultado OK ou não
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	}
//fim do Codigo
