package pl.com.pattern.less.EngApp;

public class Caller {
	
	public State state = State.getInstance();
	
	private Command command;
	
	
	public void setCommand(Command command){
	this.command = command;
	}
	public String order(String tableName, String columnName, int wordId){

	return command.runIt(tableName, columnName, wordId);

	}
}
