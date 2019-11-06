import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TelaPrincipal extends ManipularArquivo {

	private static final long serialVersionUID = 1L;

	private TelaSecundaria telaSecundaria;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPrincipal() {
		initialize();		
	}

	
	private void initialize() {
		setBounds(100, 100, 217, 147);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCalota = new JButton();
		  try {
		    Image iconeCalotaProvisorio = ImageIO.read(getClass().getResource("/imagens/iceberg-icone.jpg"));
		    Image iconeCalota = iconeCalotaProvisorio.getScaledInstance( 60, 50,  java.awt.Image.SCALE_SMOOTH );
		    btnCalota.setIcon(new ImageIcon(iconeCalota));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btnCalota.setMargin(new Insets(0,0,0,0));
		btnCalota.setBorder(null);
		btnCalota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaSecundaria = new TelaSecundaria(2);
				dispose();
				telaSecundaria.setVisible(true);
			}
		});
		btnCalota.setBounds(72, 2, 62, 43);
		getContentPane().add(btnCalota);
		
		JButton btnMar = new JButton();
		btnMar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaSecundaria(1);
				setVisible(false);
			}
		});
		try {
		    Image iconeMarProvisorio = ImageIO.read(getClass().getResource("/imagens/mar-icone.jpg"));
		    Image iconeMar = iconeMarProvisorio.getScaledInstance( 60, 50,  java.awt.Image.SCALE_SMOOTH );
		    btnMar.setIcon(new ImageIcon(iconeMar));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btnMar.setMargin(new Insets(0,0,0,0));
		btnMar.setBorder(null);
		btnMar.setBounds(0, 2, 62, 43);
		getContentPane().add(btnMar);
		
		
		JButton btnAnimal = new JButton();
		btnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaSecundaria(3);
				setVisible(false);
			}
		});
		try {
		    Image iconeAnimalProvisorio = ImageIO.read(getClass().getResource("/imagens/urso-icone.jpg"));
		    Image iconeAnimal = iconeAnimalProvisorio.getScaledInstance( 60, 50,  java.awt.Image.SCALE_SMOOTH );
		    btnAnimal.setIcon(new ImageIcon(iconeAnimal));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		btnAnimal.setMargin(new Insets(0,0,0,0));
		btnAnimal.setBorder(null);
		btnAnimal.setBounds(144, 2, 62, 43);
		getContentPane().add(btnAnimal);
	}
}
