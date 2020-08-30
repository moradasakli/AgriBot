package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static Connection connection = null; //משתנה לשמור את החיבור
	static //אתחול סטטי של המשתנה
	{
		String url="jdbc:mysql://localhost:3308/agribot?serverTimezone=GMT";//הגדרת מיקום בסיס הנתונים
		String user = "root"; //הגדרת שם המשתמש לבסיס הנתונים
		String pass = ""; //הגדרת סיסמא לבסיס הניהול
		try {
			connection = DriverManager.getConnection(url, user, pass); //יצירת החיבור דרך הדרייבר
		} catch (SQLException e) { //אם היתה תקלה
			e.printStackTrace(); //הצגת חריגה ב- console
		}
	}
	//מתודה לקבלת החיבור לבסיס הנתונים
	public static Connection getConnection() { //equivalent to getInstace
		return connection;
	}
}
