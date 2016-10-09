package pl.com.pattern.less.EngApp;

import java.sql.SQLException;

public class CommandCleanTab extends Command {
	/*
	 * This is a concrete command - for deleting all rows from table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public boolean runIt(String tableName, boolean b) {
		String createList = "CREATE TABLE IF NOT EXISTS " + tableName
				+ " (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		try {
			sqlConnection.stat.execute("DROP TABLE " + tableName);
			sqlConnection.stat.execute(createList);
			System.out.println("Wyczyszczono tabele: " + tableName);

		} catch (SQLException e) {
			System.err.println("Blad przy czyszczeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean runIt(String a, String b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String runIt(String a, String b, int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean runIt(String a, String b, String c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int runIt(String a) {
		// TODO Auto-generated method stub
		return 0;
	}

}
