package UIMain;

import java.util.HashMap;
import java.util.Map;
import BaseDatos.Data;

public abstract class OpcionDeMenu {
	
	private String key;
	
	protected OpcionDeMenu() {
	}
	
	protected OpcionDeMenu(String key){
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public abstract void ejecutar ();
	
        @Override
	public abstract String toString ();
	
	public static void seeAllOperations() {
		int i = 1;
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : Data.operations.entrySet()) {
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
}