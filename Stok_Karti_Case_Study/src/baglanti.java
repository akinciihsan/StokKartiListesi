import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class baglanti {
	public static Connection con = null;
	public static Statement st;
	public static ResultSet rs;
	public static String queryString;

	public static void main() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/localDB","root","1234");
		st = (Statement) con.createStatement();
	}

}
