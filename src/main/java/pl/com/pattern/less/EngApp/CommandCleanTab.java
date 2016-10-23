package pl.com.pattern.less.EngApp;

import java.sql.SQLException;

public class CommandCleanTab extends Command {
	


	public CommandCleanTab(String list, String engPlWord, String txtEng, String txtPl, String subString1,
			String subString2, int iterator) {
		super(list, engPlWord, txtEng, txtPl, subString1, subString2, iterator);
		// TODO Auto-generated constructor stub
	}


	/*
	 * This is a concrete command - for deleting all rows from table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt() {
		String createList = "CREATE TABLE IF NOT EXISTS " + list
				+ " (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		try {
			sqlConnection.stat.execute("DROP TABLE " + list);
			sqlConnection.stat.execute(createList);
			System.out.println("Wyczyszczono tabele: " + list);

		} catch (SQLException e) {
			System.err.println("Blad przy czyszczeniu tabeli");
			e.printStackTrace();
			return "false";
		}
		return "true";
	}

}
