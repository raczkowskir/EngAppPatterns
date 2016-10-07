package pl.com.pattern.less.EngApp;

public class State {

	// this class is a singleton
	private static State instance;

	private State() {
	}

	public static synchronized State getInstance() {
		if (instance == null) {
			instance = new State();
		}

		return instance;
	}

	public int iterator = 0;
	public String list = "";
	public String txtEng = "";
	public String txtPl = "";

}
