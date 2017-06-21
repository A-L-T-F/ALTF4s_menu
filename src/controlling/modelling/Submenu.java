package controlling.modelling;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlType
public class Submenu {
	
	private String name;
	
	private String description;
	
	
	private ObservableList <Dish> dishes;

	public Submenu() {
		this.name = getName();
		this.description = getDescription();
		this.dishes = FXCollections.observableList(new ArrayList<Dish>());
	}

	public Submenu(String name, String description, List<Dish> dishes) {
		super();
		this.name = name;
		this.description = description;
		this.dishes = FXCollections.observableList(dishes);
	}
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElementWrapper (name="Dishes")
	@XmlElement (name="Dish")
	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = FXCollections.observableList(dishes);
	}

}
