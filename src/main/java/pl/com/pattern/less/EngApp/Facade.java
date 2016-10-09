package pl.com.pattern.less.EngApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Facade {

	private static Facade instance;

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();
		}

		return instance;
	}
	
	private Facade() {
	}
	
	Caller caller  = new Caller();
	State state = State.getInstance();

	public String nextAndBack(){

		Command  commandSelect = new CommandSelect();
		caller.setCommand(commandSelect);
				
		return caller.order(state.list,"engWord",state.iterator);
	}
	
	public String check(){

		Command  commandSelect = new CommandSelect();
		caller.setCommand(commandSelect);
				
		return caller.order(state.list,"plWord",state.iterator);
	}
	public boolean delete(){

		Command  commandDelete = new CommandDelete();
		caller.setCommand(commandDelete);
				
		return caller.order(state.list, state.StrTxtENG);
	}
	
	public boolean insert(){

		Command  commandInsert = new CommandInsert();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.StrTxtENG, state.StrTxtPL);
	}
	// the method for function "add table" for Class E2_b
	public boolean insertE2_b(){

		Command  commandInsert = new CommandInsert();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.subString1, state.subString2);
	}
	
	// the method which deletes table and creates again the empty one
	public boolean cleanTab(){

		Command  commandCleanTab = new CommandCleanTab();
		caller.setCommand(commandCleanTab);

		return caller.order(state.list, true);
	}
	
	// the method for checking how many rows the table have
	public int countWords(){

		Command  commandCountWords = new CommandCountWords();
		caller.setCommand(commandCountWords);

		return caller.order(state.list);
	}
}
