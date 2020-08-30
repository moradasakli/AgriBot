package Class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

import Util.DataBaseConnection;
import View.LoginAdminUser;

public class User {
	private int id;
	private static String Username;
	private String password;
	private Field field;
	static Connection con = DataBaseConnection.getConnection();
	
	public User() {}
	
	public User(String userName, Field field) {
		setUsername(userName);
		setField(field);
	}

	public User(int id, String username, String password, Field field) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setField(field);

	}

	public static String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void openManualWork(  )throws Exception {
		int col=0,row=0;
		try {
			String query = "SELECT * FROM user";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String firstName = rs.getString("username");
				int dataBasecol = rs.getInt("col");
				int dataBaserow = rs.getInt("row");
				if (firstName.equals(LoginAdminUser.getOnline())) {
					col = dataBasecol;
					row = dataBaserow;
				}

			}

			st.close();
			System.out.println(LoginAdminUser.getOnline());
			System.out.println(col);
			System.out.println(row);
		} catch (Exception e1) {
			System.err.println("Got an exception! ");
			System.err.println(e1.getMessage());
		}

		
	
			ManualWork t = new ManualWork();
			JFrame jf = new JFrame();
			jf.setTitle("Field");
			jf.setSize(col, row);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.add(t);
	
}
	
}
