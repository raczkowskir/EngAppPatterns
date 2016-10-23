package pl.com.pattern.less.EngApp;

import java.sql.SQLException;

public class CommandDelete extends Command {
	



	public CommandDelete(String list, String engPlWord, String txtEng, String txtPl, String subString1,
			String subString2, int iterator) {
		super(list, engPlWord, txtEng, txtPl, subString1, subString2, iterator);
		// TODO Auto-generated constructor stub
	}


	/*
	 * This is a concrete command - for deleting a single row from a table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt() {
		String deleteFrom = "DELETE FROM " + list + " WHERE engWord = '" + txtEng + "'";
		try {
			sqlConnection.stat.execute(deleteFrom);
		} catch (SQLException e) {
			System.err.println("Blad przy usuwaniu slowa");
			e.printStackTrace();
			return "false";
		}
		return "true";
	}


}
