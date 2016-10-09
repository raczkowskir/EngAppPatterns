package pl.com.pattern.less.EngApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandCountWords extends Command {
	int count = 0;
	
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public int runIt(String tableName) {
		try {
			Statement stmt3 = sqlConnection.conn.createStatement();
			ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(*) AS total FROM " + tableName);
			while (rs3.next()) {
				count = rs3.getInt("total");
			}

		} catch (SQLException e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Oto volumen: " + count);

		}
		return count;
	}

	@Override
	public boolean runIt(String a, String b) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean runIt(String a, String b, String c) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public String runIt(String a, String b, int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean runIt(String a, boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
