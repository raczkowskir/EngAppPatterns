package pl.com.pattern.less.EngApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLforApp {

	// This class do not contain its own view
	// it is using for database managing

	State state = State.getInstance();
	
	public static final String DRIVER = "org.sqlite.JDBC";
	//modifications for UNDO option (1)
	//public static final String DB_URL2 = "jdbc:sqlite:biblioteka2.db";
	public static final String DB_URL = "jdbc:sqlite:biblioteka.db";

	// modifications for UNDO option (2)
	// private Connection conn2;
	private Connection conn;
	Statement stat;
	private int count;

	// the constructor - responsible for getting connection with data
	// and invoke method which creates tables
	
	private static SQLforApp instance;

	public static SQLforApp getInstance() {
		if (instance == null) {
			instance = new SQLforApp();
		}

		return instance;
	}
	
	private SQLforApp() {
		try {
			Class.forName(SQLforApp.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			// modifications for UNDO option (3)
			//conn2 = DriverManager.getConnection(DB_URL2);
			conn = DriverManager.getConnection(DB_URL);
			// modifications for UNDO option (4)
			//below should to be set before all DO command
			//conn2 = conn;
			//stat = conn.createStatement();
			//below should to be set before all UNDO command
			//conn = conn2;
			//stat = conn.createStatement();
			//UNDO will be work for Add, Delete and Clear table options
			//it will have its own button and prompt: "The amendments were withdrawn."			
			
			stat = conn.createStatement();

		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		createTables();
	}

	// the method which creates tables
	public boolean createTables() {
		String createList1 = "CREATE TABLE IF NOT EXISTS list1 (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		String createList2 = "CREATE TABLE IF NOT EXISTS list2 (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		String createList3 = "CREATE TABLE IF NOT EXISTS list3 (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		String createList4 = "CREATE TABLE IF NOT EXISTS list4 (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		String createList5 = "CREATE TABLE IF NOT EXISTS list5 (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";

		try {
			stat.execute(createList1);
			stat.execute(createList2);
			stat.execute(createList3);
			stat.execute(createList4);
			stat.execute(createList5);

		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// the method which deletes table and creates again the empty one
	public boolean clearTable(String tableName) {
		String createList = "CREATE TABLE IF NOT EXISTS " + tableName
				+ " (id_word INTEGER PRIMARY KEY AUTOINCREMENT, engWord varchar(255), plWord varchar(255))";
		try {
			stat.execute("DROP TABLE " + tableName); 
			stat.execute(createList);
			System.out.println("Wyczyszczono tabele: " + tableName);

		} catch (SQLException e) {
			System.err.println("Blad przy czyszczeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteWord(String tableName, String engWord) {
		String deleteFrom = "DELETE FROM " + tableName + " WHERE engWord = '" + engWord + "'";
		try {
			stat.execute(deleteFrom);
		} catch (SQLException e) {
			System.err.println("Blad przy usuwaniu slowa");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertWord(String tableName, String engWord, String plWord) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into " + tableName + " values (NULL, ?, ?);");

			prepStmt.setString(1, engWord);
			prepStmt.setString(2, plWord);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad dodawaniu słowka");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// the method used for selecting particular fields from database
	// - used by buttons CHECK, NEXT, BACK
	public String selectWord(String tableName, String columnName, int wordId) {
		String outcome = "";
		System.out.println(columnName);
		try {
			// ResultSet result = stat.executeQuery("SELECT * FROM "+tableName+"
			// WHERE id_word='"+wordId+"'");
			ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);

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

	// the method for checking how many rows the table have
	public int countWords(String tableName) {
		try {
			Statement stmt3 = conn.createStatement();
			ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(*) AS total FROM " + tableName);
			while (rs3.next()) {
				count = rs3.getInt("total");
			}

		} catch (SQLException e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Oto volumen: " + count);

		}
		return count;
	}

	public String nextAndBack(){

		Command  commandSelect = new CommandSelect();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandSelect);
				
		return caller.order(state.list,"engWord",state.iterator);
	}
	
	public String check(){

		Command  commandSelect = new CommandSelect();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandSelect);
				
		return caller.order(state.list,"plWord",state.iterator);
	}
	public boolean delete(){

		Command  commandDelete = new CommandDelete();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandDelete);
				
		return caller.order(state.list, state.StrTxtENG);
	}
	
	public boolean insert(){

		Command  commandInsert = new CommandInsert();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.StrTxtENG, state.StrTxtPL);
	}
	
	public boolean insertE2_b(){

		Command  commandInsert = new CommandInsert();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandInsert);

		return caller.order(state.list, state.subString1, state.subString2);
	}
	public boolean clearTab(){

		Command  commandClearTab = new CommandClearTab();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandClearTab);

		return caller.order(state.list, true);
	}
	public int countWords(){

		Command  commandCountWords = new CommandCountWords();
		Caller caller  = new Caller();
		State state = State.getInstance();
		caller.setCommand(commandCountWords);

		return caller.order(state.list);
	}
}
