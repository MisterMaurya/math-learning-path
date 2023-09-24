package path.learning.math.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class ToConnect {

	public static final String URL = "jdbc:mysql://localhost:3306/mathlearningpath";
	public static final String USR = "root";
	public static final String PWD = "Chegg@1996";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(URL, USR, PWD);
			return con;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public Statement getStatement() {
		try {
			return (Statement) getConnection().createStatement();
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			return (PreparedStatement) getConnection().prepareStatement(sql);
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
