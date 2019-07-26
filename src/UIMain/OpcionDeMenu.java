package UIMain;


public abstract class OpcionDeMenu {
	
	private String key;

	public abstract void ejecutar () throws Throwable;
	
        @Override
	public abstract String toString ();

}