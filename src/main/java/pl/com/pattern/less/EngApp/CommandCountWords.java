package pl.com.pattern.less.EngApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandCountWords extends Command {
	



	public CommandCountWords(String list, String engPlWord, String txtEng, String txtPl, String subString1,
			String subString2, int iterator) {
		super(list, engPlWord, txtEng, txtPl, subString1, subString2, iterator);
		// TODO Auto-generated constructor stub
	}


	/*
	 * This is a concrete command - for counting how many rows is in the table
	 * 
	 */
	int count = 0;

	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt() {
		try {
			Statement stmt3 = sqlConnection.conn.createStatement();
			ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(*) AS total FROM " + list);
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
		String returnAsString = String.valueOf(count);
		return returnAsString;
	}

}
