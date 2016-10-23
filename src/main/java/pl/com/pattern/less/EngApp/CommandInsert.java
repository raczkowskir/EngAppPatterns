package pl.com.pattern.less.EngApp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandInsert extends Command {
	



	public CommandInsert(String list, String engPlWord, String txtEng, String txtPl, String subString1,
			String subString2, int iterator) {
		super(list, engPlWord, txtEng, txtPl, subString1, subString2, iterator);
		// TODO Auto-generated constructor stub
	}


	/*
	 * This is a concrete command - for inserting a single row into a table
	 * 
	 */
	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt() {
		try {
			PreparedStatement prepStmt = sqlConnection.conn
					.prepareStatement("insert into " + list + " values (NULL, ?, ?);");

			prepStmt.setString(1, txtEng);
			prepStmt.setString(2, txtPl);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad dodawaniu słowka");
			e.printStackTrace();
			return "false";
		}

		return "true";
	}

}
