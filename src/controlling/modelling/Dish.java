package controlling.modelling;

import javafx.collections.ObservableList;

public class Dish {
	private String name;
	private float price;
	private int size;
	private ObservableList <Ingredient> ingredients;
	private ObservableList <String> tags;
	public Dish(String name, float price, int size, ObservableList<Ingredient> ingredients,ObservableList <String> tags) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
		this.ingredients = ingredients;
		this.tags=tags;
	}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", size=" + size + ", ingredients=" + ingredients + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ObservableList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ObservableList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public ObservableList<String> getTags() {
		return tags;
	}
	public void setTags(ObservableList<String> tags) {
		this.tags = tags;
	}

	public enum Units
	{
		ml,
		l,
		g,
		cm;
	}
	
	public Units getUnits ()
	{
		if (searchTags("Pizza"))
		{
			return Units.cm;
		}
		if (searchTags("Getränke")&&!searchTags("Flasche"))
		{
			return Units.ml;
		}
		if (searchTags("Flasche"))
		{
			return Units.l;
		}
		return Units.g;
	}
	
	public boolean searchTags (String tag)
	{
	 return this.getTags().contains(tag);
	}

}
