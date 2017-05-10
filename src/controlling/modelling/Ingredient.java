package controlling.modelling;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlType
public class Ingredient 
{
	
	private final StringProperty name;
	
	private final IntegerProperty units; 
	
	public Ingredient ()
	{
		super();
	 this.name=new SimpleStringProperty("");
	 this.units=new SimpleIntegerProperty(0);
	}
	public Ingredient(String name, int units) 
	{
		super();
		this.name = new SimpleStringProperty(name);
		this.units = new SimpleIntegerProperty(units);
	}
	public StringProperty nameProperty ()
	{
		return name;
	}
	public IntegerProperty unitsProperty ()
	{
		return units;
	}
	@XmlAttribute (name="name")
	public String getName() {
		return name.get();
	}
	//@XmlAttribute (name="name")
	public void setName(String name) {
		this.name.set(name);
	}
	@XmlAttribute (name="units")
	public int getUnits() {
		return units.get();
	}
	//@XmlAttribute (name="units")
	public void setUnits(int units) {
		this.units.set(units);;
	}

}
