package UIMain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import BaseDatos.Data;

public abstract class OpcionDeMenu {
	
	private String key;

	public abstract void ejecutar () throws Throwable;
	
        @Override
	public abstract String toString ();

}