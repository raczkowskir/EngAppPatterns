package pl.com.pattern.less.EngApp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandSelect extends Command {

	public CommandSelect(String list, String engPlWord, String txtEng, String txtPl, String subString1,
			String subString2, int iterator) {
		super(list, engPlWord, txtEng, txtPl, subString1, subString2, iterator);
		// TODO Auto-generated constructor stub
	}


	/*
	 * This is a concrete command - for selecting a row from the table it is
	 * used for functions: back, next, check
	 */

	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt() {
		String outcome = "";
		System.out.println(engPlWord);
		try {
			// ResultSet result = stat.executeQuery("SELECT * FROM "+list+"
			// WHERE id_word='"+iterator+"'");
			ResultSet result = sqlConnection.stat.executeQuery("SELECT * FROM " + list);

			// the loop which help set cursor on current row
			// - setting current row by using result.absolute(int rowNuber); is
			// throwing: "java.sql.SQLException: ResultSet is TYPE_FORWARD_ONLY"

			for (int i = 0; i < iterator; i++) {
				result.next();
			}
			String engWord;
			String plWord;

			plWord = result.getString("plWord");
			engWord = result.getString("engWord");

			System.out.println("result of getRow(): " + result.getRow());

			if (engPlWord.equals("engWord")) {
				outcome = engWord;
			} else {
				outcome = plWord;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return outcome;
	}

}
