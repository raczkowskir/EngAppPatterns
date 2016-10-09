package pl.com.pattern.less.EngApp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandInsert extends Command {
	/*
	 * This is a concrete command - for inserting a single row into a table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public boolean runIt(String tableName, String engWord, String plWord) {
		try {
			PreparedStatement prepStmt = sqlConnection.conn
					.prepareStatement("insert into " + tableName + " values (NULL, ?, ?);");

			prepStmt.setString(1, engWord);
			prepStmt.setString(2, plWord);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad dodawaniu słowka");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean runIt(String a, String b) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String runIt(String a, String b, int c) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int runIt(String a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean runIt(String a, boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

}
