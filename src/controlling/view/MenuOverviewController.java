package controlling.view;
import controlling.modelling.*;
import java.time.LocalDate;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;


public class MenuOverviewController 


{
	public static TreeItem<Dish> getModel()

	    {

	        // Create all persons

	        // First level
			
	        Dish dish1 = new Dish("Machiatto",2.50,200,new new Ingredient("wasser",200));

	        // Second level

	        Person person2 = new Person("FirstName2", "LastName2", LocalDate.of(1956, 12, 17));

	        Person person3 = new Person("FirstName3", "LastName3", LocalDate.of(1961, 3, 1));

	        Person person4 = new Person("FirstName4", "LastName4", LocalDate.of(1968, 1, 12));

	        Person person5 = new Person("FirstName5", "LastName5", LocalDate.of(1978, 4, 14));

	        // Third level
	        Person person6 = new Person("FirstName6", "LastName6", LocalDate.of(1980, 5, 10));
	
	        Person person7 = new Person("FirstName7", "LastName7", LocalDate.of(1981, 3, 20));
	
	        Person person8 = new Person("FirstName8", "LastName8", LocalDate.of(1982, 6, 3));
	
	        Person person9 = new Person("FirstName9", "LastName9", LocalDate.of(1990, 8, 27));
	        Person person10 = new Person("FirstName10", "LastName10", LocalDate.of(1994, 5, 15));

	        // Fourth level
	
	        Person person11 = new Person("FirstName11", "LastName11", LocalDate.of(2010, 6, 3));
    		Person person12 = new Person("FirstName12", "LastName12", LocalDate.of(2012, 10, 11));

	        Person person13 = new Person("FirstName13", "LastName13", LocalDate.of(2012, 10, 11));

	        // Build nodes

	        TreeItem<Person> person6Node = new TreeItem<>(person6);

	        person6Node.getChildren().addAll(new TreeItem<>(person11), new TreeItem<>(person12));

	        TreeItem<Person> person7Node = new TreeItem<>(person7);

	        person7Node.getChildren().addAll(new TreeItem<>(person13));

	        TreeItem<Person> person2Node = new TreeItem<>(person2);

	        person2Node.getChildren().addAll(person6Node, new TreeItem<>(person8),person7Node);
	
	        TreeItem<Person> person3Node = new TreeItem<>(person3);
	
	        person3Node.getChildren().addAll(new TreeItem<>(person9), new TreeItem<>(person10));

	        TreeItem<Person> person4Node = new TreeItem<>(person4);
	
	        TreeItem<Person> person5Node = new TreeItem<>(person5);
	
	        // Create the root node and add children
	
	        TreeItem<Person> rootNode = new TreeItem<>(person1);
	
	        rootNode.getChildren().addAll(person2Node, person3Node, person4Node, person5Node);
	
	 
	
	        return rootNode;
	
	    }

	public MenuOverviewController() {
		// TODO Auto-generated constructor stub
	}

}
