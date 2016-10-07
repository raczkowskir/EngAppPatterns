package pl.com.pattern.less.EngApp;

public abstract class Command {

public abstract void runIt(String a, String b);


public abstract String runIt(String a, String b, int c);

public abstract void runIt(String a, String b, String c);

public abstract int runIt(String a);
}