package pl.com.pattern.less.EngApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLconnection {
	
	public static final String DRIVER = "org.sqlite.JDBC";
	//modifications for UNDO option (1)
	//public static final String DB_URL2 = "jdbc:sqlite:biblioteka2.db";
	public static final String DB_URL = "jdbc:sqlite:biblioteka.db";

	// modifications for UNDO option (2)
	// private Connection conn2;
	Connection conn;
	Statement stat;

	// the constructor - responsible for getting connection with data
	// and invoke method which creates tables
	
	private static SQLconnection instance;

	public static SQLconnection getInstance() {
		if (instance == null) {
			instance = new SQLconnection();
		}

		return instance;
	}
	
	private SQLconnection() {
		try {
			Class.forName(SQLconnection.DRIVER);
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
	
}
