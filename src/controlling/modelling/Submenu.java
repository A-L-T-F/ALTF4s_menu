package controlling.modelling;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlType
public class Submenu {
	
	private String name;
	
	private String description;
	
	private Date current_date;
	private List <Dish> dishes;

	public Submenu() {
		this.name = getName();
		this.description = getDescription();
		this.current_date = new Date();
		this.dishes = getDishes();
	}

	public Submenu(String name, String description, Date current_date, List<Dish> dishes) {
		super();
		this.name = name;
		this.description = description;
		this.current_date = current_date;
		this.dishes = dishes;
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
	@XmlAttribute
	public String getCurent_date_as_string()
	{
	 return current_date.toString();
	}
	public Date getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}
	@XmlElementWrapper (name="Dishes")
	@XmlElement (name="Dish")
	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

}
