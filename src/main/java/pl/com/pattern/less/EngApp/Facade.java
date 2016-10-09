package pl.com.pattern.less.EngApp;

public class Facade {

	/*
	 * the main class of facade design pattern it provide easy programming
	 * interface for classes E2 and E2_b also it is a client class for Command
	 * Pattern here Commands are parameterized and call Caller method: "runIt"
	 * this class is a singleton
	 */

	// singleton
	private static Facade instance;

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

	private Facade() {
	}

	// Caller for Command pattern
	Caller caller = new Caller();
	// contain state a few fields from classes E2, E2_b which are used as a
	// parameters for commands
	State state = State.getInstance();

	public String nextAndBack() {

		Command commandSelect = new CommandSelect();
		caller.setCommand(commandSelect);

		return caller.order(state.list, "engWord", state.iterator);
	}

	public String check() {

		Command commandSelect = new CommandSelect();
		caller.setCommand(commandSelect);

		return caller.order(state.list, "plWord", state.iterator);
	}

	public boolean delete() {

		Command commandDelete = new CommandDelete();
		caller.setCommand(commandDelete);

		return caller.order(state.list, state.StrTxtENG);
	}

	public boolean insert() {

		Command commandInsert = new CommandInsert();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.StrTxtENG, state.StrTxtPL);
	}

	// the method for function "add table" for Class E2_b
	public boolean insertE2_b() {

		Command commandInsert = new CommandInsert();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.subString1, state.subString2);
	}

	// the method which deletes table and creates again the empty one
	public boolean cleanTab() {

		Command commandCleanTab = new CommandCleanTab();
		caller.setCommand(commandCleanTab);

		return caller.order(state.list, true);
	}

	// the method for checking how many rows the table have
	public int countWords() {

		Command commandCountWords = new CommandCountWords();
		caller.setCommand(commandCountWords);

		return caller.order(state.list);
	}
}
