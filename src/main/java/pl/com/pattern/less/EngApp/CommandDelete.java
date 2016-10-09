package pl.com.pattern.less.EngApp;

import java.sql.SQLException;

public class CommandDelete extends Command{
	
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
//usunąć
	
	/*public void runIt(String tableName, String engWord) {
		deleteWord(tableName, engWord);

	}*/

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

}
