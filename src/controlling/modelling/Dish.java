package controlling.modelling;


import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
@XmlRootElement (name="Dish")
@XmlType
public class Dish {
	
	private final StringProperty description;
	private final StringProperty name;
	
	private final FloatProperty price;
	
	private final IntegerProperty size;
	
	private ObservableList <Ingredient> ingredients;
	private ObservableList <String> tags;
	public Dish ()
	{
		this.description=new SimpleStringProperty("");
		this.name =  new SimpleStringProperty("");
		this.price =new SimpleFloatProperty(0);
		this.size = new SimpleIntegerProperty(0);
		this.ingredients=FXCollections.observableList(new ArrayList <Ingredient>());
		this.tags=FXCollections.observableList(new ArrayList<String>());
	}
	public Dish(String name, float price, int size,String description, ObservableList<Ingredient> ingredients,ObservableList <String> tags) {
		super();
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleFloatProperty(price);
		this.size = new SimpleIntegerProperty(size);
		this.description=new SimpleStringProperty(description);
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
	@XmlElement (name="name")
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	public FloatProperty priceProperty ()
	{
	 return price;
	}
	@XmlElement (name="price")
	public float getPrice() {
		return price.get();
	}
	public void setPrice(float price) {
		this.price.set(price);
	}
	
	public IntegerProperty sizeProperty()
	{
		return size;
	}
	@XmlElement (name="size")
	public int getSize() {
		return size.get();
	}
	public void setSize(int size) {
		this.size.set(size);
	}
	
	public StringProperty descriptionProperty ()
	{
		return description;
	}
	@XmlElement (name="description")
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	
	@XmlElementWrapper (name="ingredients")
	@XmlElement (name="ingredient")
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = FXCollections.observableList(ingredients);
	}
	@XmlElementWrapper (name="tags")
	@XmlElement (name="tag")
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = FXCollections.observableList(tags);
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
