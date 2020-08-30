package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection connection = null; //����� ����� �� ������
	static //����� ���� �� ������
	{
		String url="jdbc:mysql://localhost:3308/agribot?serverTimezone=GMT";//����� ����� ���� �������
		String user = "root"; //����� �� ������ ����� �������
		String pass = ""; //����� ����� ����� ������
		try {
			connection = DriverManager.getConnection(url, user, pass); //����� ������ ��� �������
		} catch (SQLException e) { //�� ���� ����
			e.printStackTrace(); //���� ����� �- console
		}
	}
	//����� ����� ������ ����� �������
	public static Connection getConnection() { //equivalent to getInstace
		return connection;
	}
}
