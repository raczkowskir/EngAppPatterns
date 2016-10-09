package pl.com.pattern.less.EngApp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandSelect extends Command {
	/*
	 * This is a concrete command - for selecting a row from the table it is
	 * used for functions: back, next, check
	 */

	private SQLconnection sqlConnection = SQLconnection.getInstance();

	public String runIt(String tableName, String columnName, int wordId) {
		String outcome = "";
		System.out.println(columnName);
		try {
			// ResultSet result = stat.executeQuery("SELECT * FROM "+tableName+"
			// WHERE id_word='"+wordId+"'");
			ResultSet result = sqlConnection.stat.executeQuery("SELECT * FROM " + tableName);

			// the loop which help set cursor on current row
			// - setting current row by using result.absolute(int rowNuber); is
			// throwing: "java.sql.SQLException: ResultSet is TYPE_FORWARD_ONLY"

			for (int i = 0; i < wordId; i++) {
				result.next();
			}
			String engWord;
			String plWord;

			plWord = result.getString("plWord");
			engWord = result.getString("engWord");

			System.out.println("result of getRow(): " + result.getRow());

			if (columnName.equals("engWord")) {
				outcome = engWord;
			} else {
				outcome = plWord;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return outcome;
	}

	@Override
	public boolean runIt(String a, String b) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean runIt(String a, String b, String c) {
		// TODO Auto-generated method stub
		return true;
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
