package controlling.modelling;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ingredient 
{
	private final StringProperty name; 
	private final IntegerProperty units; 
	
	
	public Ingredient(String name, int units) 
	{
		super();
		this.name = new SimpleStringProperty(name);
		this.units = new SimpleIntegerProperty(units);
	}

	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public int getUnits() {
		return units.get();
	}
	
	public void setUnits(int units) {
		this.units.set(units);;
	}

}
