package pl.com.pattern.less.EngApp;

public abstract class Command {

	/*
	 * this is a parent abstract class for all commands classes it made them to
	 * implement method "runIt"
	 */

	// for delete command
	public abstract boolean runIt(String a, String b);

	// for select command (back/next/check)
	public abstract String runIt(String a, String b, int c);

	// for insert command
	public abstract boolean runIt(String a, String b, String c);

	// for count command
	public abstract int runIt(String a);

	// for clearTable command (second parameter is never used)
	public abstract boolean runIt(String a, boolean b);

}
