package pl.com.pattern.less.EngApp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandSelect extends Command {
	
	private SQLforApp sqlForApp = SQLforApp.getInstance();
	
	/*
	String tableName="0";
	String columnName="0";
	int wordId = 0;
	
	public CommandSelect(String tableName, String columnName, int wordId){
		this.columnName = columnName;
		this.tableName = tableName;
		this.wordId = wordId;
	}
*/
	public String runIt(String tableName, String columnName, int wordId) {
		String outcome = "";
		System.out.println(columnName);
		try {
			// ResultSet result = stat.executeQuery("SELECT * FROM "+tableName+"
			// WHERE id_word='"+wordId+"'");
			ResultSet result = sqlForApp.stat.executeQuery("SELECT * FROM " + tableName);

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
	//	return "cokolwiek";
	}

	@Override
	public void runIt(String a, String b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void runIt(String a, String b, String c) {
		// TODO Auto-generated method stub

	}

	@Override
	public int runIt(String a) {
		// TODO Auto-generated method stub
		return 0;
	}

}
