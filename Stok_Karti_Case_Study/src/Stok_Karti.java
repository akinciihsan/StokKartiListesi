import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;



public class Stok_Karti extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfStokKodu;
	private JTextField tfStokAdi;
	private JTextField tfBarkodu;
	
	public static String StokKodu,StokAdi,Birimi,Barkodu,aciklama;
	public static int StokTipi;
	public static double KdvTipi;
	public static Date olusturmaTarihi;

	public static Stok_Karti frame = new Stok_Karti();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Stok_Karti() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		
		
		
		setTitle("Stok Kartý");
		setBounds(100, 100, 670, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLocation(443, 91);
		addPopup(contentPane, popupMenu);
		JMenuItem StokKopyala = new JMenuItem("Stok Kartý Kopyala");
		popupMenu.add(StokKopyala);
		
		JLabel lblStokAdi = new JLabel("Stok Adý :");
		lblStokAdi.setBounds(24, 37, 119, 14);
		contentPane.add(lblStokAdi);
		
		JLabel lblStokKod = new JLabel("Stok Kodu :");
		lblStokKod.setBounds(24, 11, 119, 14);
		contentPane.add(lblStokKod);
		
		JLabel lblStokTipi = new JLabel("Stok Tipi :");
		lblStokTipi.setBounds(24, 63, 119, 14);
		contentPane.add(lblStokTipi);
		
		JLabel lblBirimi = new JLabel("Birimi :");
		lblBirimi.setBounds(24, 91, 119, 14);
		contentPane.add(lblBirimi);
		
		JLabel lblKdvTipi = new JLabel("KDV Tipi :");
		lblKdvTipi.setBounds(24, 142, 119, 14);
		contentPane.add(lblKdvTipi);
		
		JLabel lblAklama = new JLabel("Açýklama :");
		lblAklama.setBounds(24, 170, 119, 43);
		contentPane.add(lblAklama);
		
		JLabel lblOluturmaTarihi = new JLabel("Oluþturma Tarihi :");
		lblOluturmaTarihi.setBounds(24, 286, 119, 14);
		contentPane.add(lblOluturmaTarihi);
		
		tfStokKodu = new JTextField();
		tfStokKodu.setBounds(129, 11, 178, 20);
		contentPane.add(tfStokKodu);
		tfStokKodu.setColumns(10);
		
		tfStokAdi = new JTextField();
		tfStokAdi.setColumns(10);
		tfStokAdi.setBounds(129, 37, 178, 20);
		contentPane.add(tfStokAdi);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField ftfOlusturmaTarihi = new JFormattedTextField(format);
		ftfOlusturmaTarihi.setBackground(Color.PINK);
		ftfOlusturmaTarihi.setEditable(false);
		ftfOlusturmaTarihi.setBounds(129, 283, 178, 23);
		contentPane.add(ftfOlusturmaTarihi);
		
		JComboBox cbStokTipi = new JComboBox();
		cbStokTipi.setModel(new DefaultComboBoxModel(new String[] {"Lütfen Seçiniz","11", "12", "13", "14", "15", "16", "17", "18"}));
		cbStokTipi.setBounds(129, 60, 178, 20);
		contentPane.add(cbStokTipi);
		
		JComboBox cbBirimi = new JComboBox();
		cbBirimi.setModel(new DefaultComboBoxModel(new String[] {"Lütfen Seçiniz", "Birim 1", "Birim 2", "Birim 3", "Birim 4", "Birim 5", "Birim 6", "Birim 7", "Birim 8"}));
		cbBirimi.setBounds(129, 88, 178, 20);
		contentPane.add(cbBirimi);
		
		JLabel lblBarkodu = new JLabel("Barkodu :");
		lblBarkodu.setBounds(24, 116, 119, 14);
		contentPane.add(lblBarkodu);
		
		tfBarkodu = new JTextField();
		tfBarkodu.setColumns(10);
		tfBarkodu.setBounds(129, 116, 178, 20);
		contentPane.add(tfBarkodu);
		
		JComboBox cbKdvTipi = new JComboBox();
		cbKdvTipi.setModel(new DefaultComboBoxModel(new Double[] {0.0, 11.1, 12.1, 13.1, 14.1, 15.1, 16.1, 17.1, 18.1}));
		cbKdvTipi.setBounds(129, 139, 178, 20);
		contentPane.add(cbKdvTipi);
		
		JTextArea taAciklama = new JTextArea();
		taAciklama.setBackground(Color.WHITE);
		taAciklama.setBounds(153, 170, 178, 43);
		Border border = BorderFactory.createLineBorder(Color.gray);
	    taAciklama.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		contentPane.add(taAciklama);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setEnabled(false);
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (!tfStokKodu.getText().equals("")) {
					Stok_Karti.StokKodu = tfStokKodu.getText().toUpperCase();}
				else { Stok_Karti.StokKodu="";}
				
				baglanti.queryString = "Select * from stok_karti where STOK_KODU = '" + Stok_Karti.StokKodu + "'" ;
				try {
					
					baglanti.rs =baglanti.st.executeQuery(baglanti.queryString);
					
					if (baglanti.rs.next()) {
						Stok_Karti.StokKodu = baglanti.rs.getString("STOK_KODU");
				        tfStokKodu.setText(Stok_Karti.StokKodu.toUpperCase());
				        
				        Stok_Karti.StokAdi = baglanti.rs.getString("STOK_ADI");
				        tfStokAdi.setText(Stok_Karti.StokAdi);
				        
				        Stok_Karti.StokTipi = baglanti.rs.getInt("STOK_TIPI");
				        cbStokTipi.setSelectedItem(baglanti.rs.getString("STOK_TIPI"));
				        
				        Stok_Karti.Birimi = baglanti.rs.getString("BIRIMI");
				        cbBirimi.setSelectedItem(Stok_Karti.Birimi);
				        
				        Stok_Karti.Barkodu = baglanti.rs.getString("BARKODU");
				        tfBarkodu.setText(Stok_Karti.Barkodu);
				        
				        Stok_Karti.KdvTipi = baglanti.rs.getDouble("KDV_TIPI");
				        cbKdvTipi.setSelectedItem(Stok_Karti.KdvTipi);
				        
				        Stok_Karti.aciklama = baglanti.rs.getString("ACIKLAMA");
				        taAciklama.setText(Stok_Karti.aciklama);
				        
				        Stok_Karti.olusturmaTarihi = baglanti.rs.getDate("OLUSTURMA_TARIHI");
				        ftfOlusturmaTarihi.setText(Stok_Karti.olusturmaTarihi.toString());
				        btnSil.setEnabled(true);
					} 
					else {
						JOptionPane.showMessageDialog(null, "Ýlgili koda ait bilgi bulunamadý.");
						tfStokKodu.setText("");
						tfStokAdi.setText("");
						cbStokTipi.setSelectedIndex(0);
						cbBirimi.setSelectedIndex(0);
						tfBarkodu.setText("");
						cbKdvTipi.setSelectedIndex(0);
						taAciklama.setText("");
						ftfOlusturmaTarihi.setText("");
						btnSil.setEnabled(false);
					}
//					if (say == 0) {
//						JOptionPane.showMessageDialog(null, "Ýlgili koda ait bilgi bulunamadý.");
//						tfStokKodu.setText("");
//						tfStokAdi.setText("");
//						cbStokTipi.setSelectedIndex(0);
//						cbBirimi.setSelectedIndex(0);
//						tfBarkodu.setText("");
//						cbKdvTipi.setSelectedIndex(0);
//						taAciklama.setText("");
//						ftfOlusturmaTarihi.setText("");
//						btnSil.setEnabled(false);
//					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAra.setBounds(357, 7, 89, 23);
		contentPane.add(btnAra);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!tfStokKodu.getText().equals("")) {
					Stok_Karti.StokKodu = tfStokKodu.getText().toUpperCase();}
				else { Stok_Karti.StokKodu="";}
				
				if (!tfStokAdi.getText().equals("")) {
					Stok_Karti.StokAdi = tfStokAdi.getText(); }
				else { Stok_Karti.StokAdi=""; }
				
				if (cbStokTipi.getSelectedIndex() != 0) {
					Stok_Karti.StokTipi = Integer.parseInt(cbStokTipi.getSelectedItem().toString()); }
				else { Stok_Karti.StokTipi= 0; }
				
				if (cbBirimi.getSelectedIndex() != 0) {
					Stok_Karti.Birimi = cbBirimi.getSelectedItem().toString(); }
				else { Stok_Karti.Birimi=""; }
				
				if (!tfBarkodu.getText().equals("")) {
					Stok_Karti.Barkodu = tfBarkodu.getText(); }
				else { Stok_Karti.Barkodu=""; }
				
				if (cbKdvTipi.getSelectedIndex() != 0) {
					Stok_Karti.KdvTipi = Double.parseDouble(cbKdvTipi.getSelectedItem().toString()); }
				else { Stok_Karti.KdvTipi=0; }
				
				if (!taAciklama.getText().equals("")) {
					Stok_Karti.aciklama = taAciklama.getText(); }
				else { Stok_Karti.aciklama=""; }
				
				if (StokKodu == "" || StokTipi == 0) {
					JOptionPane.showMessageDialog(null, "Lütfen Stok Kodu ve Stok Tipi alanlarýný doldurun.");
				}
				else {
				baglanti.queryString ="select * from stok_karti where STOK_KODU ='"+StokKodu+"'";
				try {
					baglanti.rs =baglanti.st.executeQuery(baglanti.queryString);
					int say = 0;
					while (baglanti.rs.next())
				      {
						say++;
				      }
					if (say > 0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null,StokKodu + " numaralý Stok Kodu sistemde mevcut, deðikiþlik yapmayý onaylýyor musunuz ?\nYeni bir Stok Kodu kayýt etmek için 'Hayýr' butonunu kullanýn ve farklý bir Stok Kodu girin.","STOK KODU MEVCUT",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION){
							baglanti.queryString = "UPDATE `localdb`.`stok_karti` SET `STOK_ADI`='"+StokAdi+"', `STOK_TIPI`='"+StokTipi+"', `BIRIMI`='"+Birimi+"', `BARKODU`='"+Barkodu+"', `KDV_TIPI`='"+KdvTipi+"', `ACIKLAMA`='"+aciklama+"' WHERE `STOK_KODU`='"+StokKodu+"';";
							try {
								baglanti.st.executeUpdate(baglanti.queryString);
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, StokKodu + " numaralý Stok Kodu baþarýlý bir þekilde revize edilmiþtir.");
							btnSil.setEnabled(true);
							
						}
					}
					else {						
						baglanti.queryString = "INSERT INTO `localdb`.`stok_karti` (`STOK_KODU`, `STOK_ADI`, `STOK_TIPI`, `BIRIMI`, `BARKODU`, `KDV_TIPI`, `ACIKLAMA`) VALUES ('"+StokKodu+"', '"+StokAdi+"', '"+StokTipi+"', '"+Birimi+"', '"+Barkodu+"', '"+KdvTipi+"', '"+aciklama+"');";
						try {
							baglanti.st.executeUpdate(baglanti.queryString);
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, StokKodu + " numaralý Stok Kodu sisteme baþarýlý bir þekilde kayýt edilmiþtir.");
						btnSil.setEnabled(true);
						baglanti.queryString = "Select * from stok_karti where STOK_KODU = '" + Stok_Karti.StokKodu + "'" ;
						try {
							baglanti.rs =baglanti.st.executeQuery(baglanti.queryString);
							while (baglanti.rs.next())
						      {
								Stok_Karti.StokKodu = baglanti.rs.getString("STOK_KODU");
								tfStokKodu.setText(Stok_Karti.StokKodu);
								
								Stok_Karti.olusturmaTarihi = baglanti.rs.getDate("OLUSTURMA_TARIHI");
						        ftfOlusturmaTarihi.setText(Stok_Karti.olusturmaTarihi.toString());
						      }
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
		btnKaydet.setBounds(456, 7, 89, 23);
		contentPane.add(btnKaydet);
		
		
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfStokKodu.getText().equals("")) {
					Stok_Karti.StokKodu = tfStokKodu.getText();
				}
				else { Stok_Karti.StokKodu=""; }
				try {
					baglanti.queryString = "DELETE FROM `localdb`.`stok_karti` WHERE `STOK_KODU`='"+StokKodu+"';";
					baglanti.st.executeUpdate(baglanti.queryString);
					JOptionPane.showMessageDialog(null,StokKodu + " numaralý Stok Kodu baþarýyla silindi.");
					btnSil.setEnabled(false);
					tfStokKodu.setText("");
					tfStokAdi.setText("");
					cbStokTipi.setSelectedIndex(0);
					cbBirimi.setSelectedIndex(0);
					tfBarkodu.setText("");
					cbKdvTipi.setSelectedIndex(0);
					taAciklama.setText("");
					ftfOlusturmaTarihi.setText("");
					btnSil.setEnabled(false);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSil.setBounds(555, 7, 89, 23);
		contentPane.add(btnSil);
		
		JScrollPane scrollPane = new JScrollPane(taAciklama);
		scrollPane.setBounds(129, 182, 178, 90);
		contentPane.add(scrollPane);
		
		StokKopyala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baglanti.queryString = "Select * from stok_karti where STOK_KODU = '" + Stok_Karti.StokKodu + "'" ;
				try {
					baglanti.rs =baglanti.st.executeQuery(baglanti.queryString);
					int say = 0;
					while (baglanti.rs.next())
				      {
				        say++;
				      }
					if (say == 0) {
						JOptionPane.showMessageDialog(null, "Lütfen geçerli bir Stok Kodu görüntüleyin.");
					}
					else {
						tfStokKodu.setText("");
						JOptionPane.showMessageDialog(null, "Stok Kartý baþarýyla kopyalandý.\nYeni bir Stok Kodu girerek kayýt iþlemini tamamlayabilirsiniz.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
