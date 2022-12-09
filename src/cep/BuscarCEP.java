package cep;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class BuscarCEP extends JFrame {

	private JPanel contentPane;
	private JTextField TxtCEP;
	private JTextField TxtEndereco;
	private JTextField TxtBairro;
	private JTextField TxtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCEP frame = new BuscarCEP();
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
	public BuscarCEP() {
		setTitle("Buscar Cep");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarCEP.class.getResource("/img/home.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(10, 35, 46, 14);
		contentPane.add(lblNewLabel);

		TxtCEP = new JTextField();
		TxtCEP.setBounds(66, 32, 151, 20);
		contentPane.add(TxtCEP);
		TxtCEP.setColumns(10);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(10, 68, 61, 14);
		contentPane.add(lblEndereo);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 93, 61, 14);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 122, 61, 14);
		contentPane.add(lblCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(187, 122, 61, 14);
		contentPane.add(lblUf);

		TxtEndereco = new JTextField();
		TxtEndereco.setColumns(10);
		TxtEndereco.setBounds(66, 65, 245, 20);
		contentPane.add(TxtEndereco);

		TxtBairro = new JTextField();
		TxtBairro.setColumns(10);
		TxtBairro.setBounds(66, 93, 245, 20);
		contentPane.add(TxtBairro);

		TxtCidade = new JTextField();
		TxtCidade.setColumns(10);
		TxtCidade.setBounds(66, 118, 80, 20);
		contentPane.add(TxtCidade);

		JComboBox CBUF = new JComboBox();
		CBUF.setModel(new DefaultComboBoxModel(new String[] { "", "", "    AC", "    AL", "    AP", "    AM", "    BA",
				"    CE", "    DF", "    ES", "    GO", "    MA", "    MT", "    MS", "    MG", "    PA", "    PB",
				"    PR", "    PE", "    PI", "    RJ", "    RN", "    RS", "    RO", "    RR", "    SC", "    SP",
				"    SE", "    TO" }));
		CBUF.setBounds(210, 118, 69, 22);
		contentPane.add(CBUF);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(270, 195, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(76, 195, 89, 23);
		contentPane.add(btnBuscar);

		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TxtCEP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					TxtCEP.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnBuscar_1.setBackground(new Color(240, 240, 240));
		btnBuscar_1.setBounds(230, 32, 89, 22);
		contentPane.add(btnBuscar_1);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setToolTipText("Sobre");
		btnNewButton_1.setIcon(new ImageIcon(BuscarCEP.class.getResource("/img/About.png")));
		btnNewButton_1.setBounds(335, 25, 69, 35);
		contentPane.add(btnNewButton_1);
		// uso da biblioteca Atx
		RestrictedTextField validar = new RestrictedTextField(TxtCEP);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	}// fim do contrutor

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = TxtCEP.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			 Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					TxtCidade.setText(element.getText());
                                }
					if (element.getQualifiedName().equals("bairro")) {
						TxtBairro.setText(element.getText());
					}
					//if (element.getQualifiedName().equals("uf")) {
						///CBUF.setSelectedItem(element.getText());
					//}
                                        if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipoLogradouro = element.getText();
					}
                                        if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
                                        }
                                        if (element.getQualifiedName().equals("resultado")) {
						resultado = element.getText();
                                                if(resultado.equals("1")){
                                                
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "CEP NÃO ENCONTRADO");
                                           
                                                }
                                                
                                        }
                                        

			}
			TxtEndereco.setText(tipoLogradouro+" "+logradouro);
			
			
			
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
