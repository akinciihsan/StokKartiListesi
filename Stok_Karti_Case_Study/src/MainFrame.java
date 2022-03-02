import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Stok_Karti StokKarti = new Stok_Karti();
	Stok_Karti_Liste StokKartListe = new Stok_Karti_Liste();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Stok Kartý Case Study");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 46, 1200, 500);
		contentPane.add(desktopPane);
		
		try {
			baglanti.main();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JButton btnStokKarti = new JButton("Stok Kartý");
		btnStokKarti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!StokKarti.isShowing()) {
					desktopPane.add(StokKarti).setVisible(true);
				}
				else {
					StokKarti.toFront();
				}
			}
		});
		btnStokKarti.setBounds(10, 11, 130, 23);
		contentPane.add(btnStokKarti);
		
		JButton btnStokListesi = new JButton("Stok Listesi");
		btnStokListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!StokKartListe.isShowing()) {
					desktopPane.add(StokKartListe).setVisible(true);
				}
				else {
					StokKartListe.toFront();
				}
			}
		});
		btnStokListesi.setBounds(150, 11, 130, 23);
		contentPane.add(btnStokListesi);
	}
}
