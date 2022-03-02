import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Stok_Karti_Liste extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Stok_Karti_Liste frame = new Stok_Karti_Liste();
	public static Stok_Karti stok_karti_frame = new Stok_Karti();
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	Object[] colums = {"Stok Kodu","Stok Adý","Stok Tipi","Birimi","Barkodu","KDV Tipi","Açýklama","Oluþturma Tarihi"};
	Object[] rows = new Object[8];

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
	public Stok_Karti_Liste() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Stok Kart Listesi");
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1164, 418);
		contentPane.add(scrollPane);
		
		table = new JTable() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model.setColumnIdentifiers(colums);
		table.setBounds(159, 172, 207, 116);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.setBounds(1074, 11, 100, 23);
		
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				table.setModel(model);
				try {
					baglanti.main();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				baglanti.queryString = "SELECT * FROM localdb.stok_karti;";
				try {
					baglanti.rs =baglanti.st.executeQuery(baglanti.queryString);
					while (baglanti.rs.next())
				      {
						rows[0] = baglanti.rs.getString("STOK_KODU");
						rows[1] = baglanti.rs.getString("STOK_ADI");
						rows[2] = baglanti.rs.getString("STOK_TIPI");
						rows[3] = baglanti.rs.getString("BIRIMI");
						rows[4] = baglanti.rs.getString("BARKODU");
						rows[5] = baglanti.rs.getString("KDV_TIPI");
						rows[6] = baglanti.rs.getString("ACIKLAMA");
						rows[7] = baglanti.rs.getString("OLUSTURMA_TARIHI");
						model.addRow(rows);
				      }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnListele);
		
	}
	
}
