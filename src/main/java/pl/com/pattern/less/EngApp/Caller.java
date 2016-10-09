package pl.com.pattern.less.EngApp;

public class Caller {

	// public State state = State.getInstance();

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	// for select command
	public String order(String tableName, String columnName, int wordId) {

		return command.runIt(tableName, columnName, wordId);

	}

	// delete
	public boolean order(String tableName, String txtEng) {

		return command.runIt(tableName, txtEng);

	}

	// insert
	public boolean order(String tableName, String engWord, String plWord) {

		return command.runIt(tableName, engWord, plWord);

	}

	// clear table
	public boolean order(String tableName, boolean b) {

		return command.runIt(tableName, b);

	}
	
	// count words
		public int order(String tableName) {

			return command.runIt(tableName);

		}
}