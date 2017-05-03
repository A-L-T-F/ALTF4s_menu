package controlling.modelling;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Date;

public class Submenu {
	private String name;
	private String description;
	private Date current_date;
	private ObservableList <Dish> dishes;

	public Submenu() {
		// TODO Auto-generated constructor stub
	}

	public Submenu(String name, String description, Date current_date, ObservableList<Dish> dishes) {
		super();
		this.name = name;
		this.description = description;
		this.current_date = current_date;
		this.dishes = dishes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}

	public ObservableList<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(ObservableList<Dish> dishes) {
		this.dishes = dishes;
	}

}
