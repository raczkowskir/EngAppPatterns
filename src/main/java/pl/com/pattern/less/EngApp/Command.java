package pl.com.pattern.less.EngApp;

public abstract class Command {
	/*	
	 * this is a parent abstract class for all commands classes 
*/
	String list;
	String engPlWord;
	String txtEng;
	String txtPl;
	String subString1;
	String subString2;

	int iterator;

	public Command (String list, String engPlWord, String txtEng, String txtPl, String subString1,
	String subString2, int iterator){
		
		this.list = list;
		this.engPlWord = engPlWord;
		this.txtEng = txtEng;
		this.txtPl = txtPl;
		this.subString1 = subString1;
		this.subString2 = subString2;
		this.iterator = iterator;
	}

/*	
	 * this is a parent abstract class for all commands classes 
*/
	
	public abstract String runIt();
	
}
