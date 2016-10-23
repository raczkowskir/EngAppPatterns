package pl.com.pattern.less.EngApp;

public class Caller {

	/*
	 * this class is a part of Command design pattern it is used for calling
	 * commands
	 */

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public String order() {
		return command.runIt();
	}
}