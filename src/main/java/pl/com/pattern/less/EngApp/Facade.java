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

		Command commandSelect = new CommandSelect(state.list, "engWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		caller.setCommand(commandSelect);

		return caller.order();
	}

	public String check() {

		Command commandSelect = new CommandSelect(state.list, "plWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		;
		caller.setCommand(commandSelect);

		return caller.order();
	}

	public String delete() {

		Command commandDelete = new CommandDelete(state.list, "engWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		;
		caller.setCommand(commandDelete);

		return caller.order();
	}

	public String insert() {

		Command commandInsert = new CommandInsert(state.list, "engWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		;
		caller.setCommand(commandInsert);

		return caller.order();
	}

	// the method for function "add table" for Class E2_b
	public String insertE2_b() {

		Command commandInsert = new CommandInsert(state.list, "engWord", state.subString1, state.subString2,
				state.StrTxtENG, state.StrTxtPL, state.iterator);
		caller.setCommand(commandInsert);

		return caller.order();
	}

	// the method which deletes table and creates again the empty one
	public String cleanTab() {

		Command commandCleanTab = new CommandCleanTab(state.list, "engWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		caller.setCommand(commandCleanTab);

		return caller.order();
	}

	// the method for checking how many rows the table have
	public int countWords() {

		Command commandCountWords = new CommandCountWords(state.list, "engWord", state.StrTxtENG, state.StrTxtPL,
				state.subString1, state.subString2, state.iterator);
		;
		caller.setCommand(commandCountWords);

		int returnAsInt = Integer.valueOf(caller.order());
		return returnAsInt;

	}
}
