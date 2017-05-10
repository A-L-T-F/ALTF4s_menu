package controlling.modelling;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Dish {
	private final StringProperty name;
	private final FloatProperty price;
	private final IntegerProperty size;
	private ObservableList <Ingredient> ingredients;
	private ObservableList <String> tags;
	public Dish(String name, float price, int size, ObservableList<Ingredient> ingredients,ObservableList <String> tags) {
		super();
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleFloatProperty(price);
		this.size = new SimpleIntegerProperty(size);
		this.ingredients = ingredients;
		this.tags=tags;
	}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", size=" + size + ", ingredients=" + ingredients + "]";
	}
	public StringProperty nameProperty ()
	{
		return name;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);;
	}
	public FloatProperty priceProperty ()
	{
	 return price;
	}
	public float getPrice() {
		return price.get();
	}
	public void setPrice(float price) {
		this.price.set(price);;
	}
	public IntegerProperty sizeProperty()
	{
		return size;
	}
	public int getSize() {
		return size.get();
	}
	public void setSize(int size) {
		this.size.set(size);;
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
