package cep;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		getContentPane().setBackground(new Color(240, 240, 240));
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WebService:");
		lblNewLabel.setBounds(22, 67, 67, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblwalan = new JLabel("@walan");
		lblwalan.setBounds(22, 42, 67, 14);
		getContentPane().add(lblwalan);
		
		JButton btnGit = new JButton("");
		btnGit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/walan-christian128");
			}
		});
		btnGit.setBorder(null);
		btnGit.setBackground(new Color(240, 240, 240));
		btnGit.setIcon(new ImageIcon(Sobre.class.getResource("/img/GitHub.png")));
		btnGit.setBounds(33, 172, 67, 48);
		getContentPane().add(btnGit);
		
		JButton Youtube = new JButton("");
		Youtube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.youtube.com/");
			}
		});
		Youtube.setBorder(null);
		Youtube.setIcon(new ImageIcon(Sobre.class.getResource("/img/YouTube.png")));
		Youtube.setBounds(157, 172, 89, 48);
		getContentPane().add(Youtube);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar 1.0");
		lblNewLabel_1.setBounds(22, 11, 67, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblService9 = new JLabel("www.republicavirtual.com.br");
		lblService9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://mail.yahoo.com/d/folders/1/messages/30106?.lang=pt-BR&guce_referrer=aHR0cHM6Ly9sb2dpbi55YWhvby5jb20v&guce_referrer_sig=AQAAABENvB-i1lTTI-8kvVWTHIkPDajw_JrvdXyZ3G50y720EC-eIUagsL1OG9eq96n_imDDWHGGC9_QEwdFLHk5QKSQ_6sieB5CeqAp2Ia7mJ2qzECZcVSLv2loJJdaupT5lBwsPPa-HtH0pMOZFT06rKxzyEm2FeJYs3g5tcqfbdvG");
				
			}
		});
		lblService9.setBounds(119, 67, 155, 14);
		getContentPane().add(lblService9);

	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI (site);
			desktop.browse(uri);
		}catch(Exception e ) {
			
			
		}
		
		
		
	}

}
