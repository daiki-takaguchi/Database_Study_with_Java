package db_study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect01 {
	public static void main(String[] args) {
		final String pas = "0neSySteMError";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/world?useSSL=false",
					"root",
					pas
				);

			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from country limit 50");

			while (rs.next()) {
				System.out.println(rs.getString("Name"));
				System.out.println(rs.getInt("Population"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if(con != null) {
				try {
					con.close();
 				} catch(SQLException e) {
 					e.printStackTrace();
 				}
			}
		}
	}
}
