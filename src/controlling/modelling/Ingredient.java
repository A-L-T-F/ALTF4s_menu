package controlling.modelling;

public class Ingredient 
{
	String name; int units; 
	public Ingredient() 
	{
		// TODO Auto-generated constructor stub	
	}
	
	public Ingredient(String name, int units) 
	{
		super();
		this.name = name;
		this.units = units;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUnits() {
		return units;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}

}
