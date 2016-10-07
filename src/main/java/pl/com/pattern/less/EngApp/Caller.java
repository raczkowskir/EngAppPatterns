package pl.com.pattern.less.EngApp;

public class Caller {
	
	public State state = State.getInstance();
	private Command command;
	public void setCommand(Command command){
	command = command;
	}
	 
	public void order(){
	command.runIt(state.list,"o",state.iterator);
	}

}
