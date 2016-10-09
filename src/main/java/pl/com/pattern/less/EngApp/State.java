package pl.com.pattern.less.EngApp;

public class State {

	/*This class contain state of a few fields from class E2 and E2_b
	 * it is use by all commands classes 
	 *  this class is a singleton
	 */
	private static State instance;

	private State() {
	}

	public static State getInstance() {
		if (instance == null) {
			instance = new State();
		}

		return instance;
	}
	//state for E2
	public int iterator = 1;
	public String list = "list1";
	public String StrTxtENG = "";
	public String StrTxtPL = "";

	//state for E2_b
	public String listE2b = "list1";
	public String subString1 = "";
	public String subString2 = "";
}