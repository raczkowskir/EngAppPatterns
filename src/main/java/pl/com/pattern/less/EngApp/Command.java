package pl.com.pattern.less.EngApp;

public abstract class Command {

// for insert command
public abstract boolean runIt(String a, String b);

//for select command (add/delete/check)
public abstract String runIt(String a, String b, int c);

//for insert command
public abstract boolean runIt(String a, String b, String c);

public abstract int runIt(String a);

}


