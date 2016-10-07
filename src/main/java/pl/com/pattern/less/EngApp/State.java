package pl.com.pattern.less.EngApp;

public class State {

	// this class is a singleton
	private static State instance;

	private State() {
	}

	public static State getInstance() {
		if (instance == null) {
			instance = new State();
		}

		return instance;
	}

	public int iterator = 0;
	public String list = "";
	public String StrTxtENG = "";
	public String StrTxtPL = "";

}

//dodać brakujące klasy i przenieść baze do klasy SQLconnection !
