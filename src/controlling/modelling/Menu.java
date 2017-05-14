package controlling.modelling;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
@XmlRootElement
public class Menu extends Submenu{
	
	private ObservableList <Submenu> menu_list;
	private Date current_date;
	public Menu() {
		super();
		this.current_date = new Date();
	}
	public Menu(String name, String description,List <Submenu> menu) {
		super();
		super.setName(name);
		super.setDescription(description);
		this.current_date = new Date();
		this.menu_list=FXCollections.observableList(menu);
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
	
	@XmlElementWrapper (name="submenues")
	@XmlElement (name="submenu")
	public List<Submenu> getSubmenues() {
		return menu_list;
	}

	public void setSubmenues(List<Submenu> menu_list) {
		this.menu_list = FXCollections.observableList(menu_list);
	}

}
