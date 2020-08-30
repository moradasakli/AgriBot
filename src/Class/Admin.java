package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Util.DataBaseConnection;

public class Admin {

	static Connection con = DataBaseConnection.getConnection();
	private String userName;
	private String password;

	public Admin() {
	}

	public String getAdminName() {
		return userName;
	}

	public void setAdminName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminPassword(String password) {
		this.password = password;
	}

	public static void createTable(String name) throws Exception {
		PreparedStatement create = con.prepareStatement("CREATE TABLE " + name + "(place int NOT NULL AUTO_INCREMENT, move VARCHAR(50),    PRIMARY KEY (place)" + 
				");");
		create.executeUpdate();
	}

	@SuppressWarnings("static-access")
	public void createUser(User user) throws SQLException {
		try {

			String sql = "insert into user(`id`, `username`, `password`, `col`, `row`) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUserPassword());
			ps.setInt(4, user.getField().getCol());
			ps.setInt(5, user.getField().getRow());
			int x = ps.executeUpdate();
			if (x > 0) {
				createTable(user.getUsername());

				JOptionPane.showMessageDialog(null, "The user was added sucessfully.", "Sucess",
						JOptionPane.CLOSED_OPTION);

			} else {
				JOptionPane.showMessageDialog(null, "Error!! the user was not Added .", "Failed",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e1) {
			System.out.println(e1);
		}

	}
	public void removeTable(String tablename) throws Exception {
		String sql="DROP TABLE "+tablename;
		PreparedStatement create = con.prepareStatement(sql); 
				System.out.println(sql);
		create.executeUpdate();
	}

	public void removeUser(int userID,String username) throws Exception {
		try{
			
			String sql = "delete from user where id = "+userID;

			Statement stmt = con.createStatement(); 
      
      stmt.executeUpdate(sql);
      removeTable(username);
	
		 } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}