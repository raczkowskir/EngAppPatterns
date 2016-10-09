package pl.com.pattern.less.EngApp;

import java.sql.SQLException;

public class CommandDelete extends Command {
	/*
	 * This is a concrete command - for deleting a single row from a table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public boolean runIt(String tableName, String engWord) {
		String deleteFrom = "DELETE FROM " + tableName + " WHERE engWord = '" + engWord + "'";
		try {
			sqlConnection.stat.execute(deleteFrom);
		} catch (SQLException e) {
			System.err.println("Blad przy usuwaniu slowa");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean runIt(String a, String b, String c) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String runIt(String a, String b, int c) {
		return "";
		// TODO Auto-generated method stub

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
