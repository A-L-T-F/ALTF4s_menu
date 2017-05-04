package controlling.view;

import java.util.Arrays;

import controlling.modelling.Dish;
import controlling.modelling.Ingredient;
import javafx.collections.FXCollections;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class TableTreeController {

	@SuppressWarnings("unchecked")

	public static TreeItem<Dish> getModel()

	    {

	        // Create all 

	        // First level
		
	        Dish dish1 = new Dish("Machiatto",(float) 2.50,200,
	        	FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
	        	FXCollections.observableList( Arrays.asList("Getränke")));

	        // Second level

	        Dish dish2 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish3 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish4 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish5 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));

	        // Third level
	        Dish dish6 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	
	        Dish dish7 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	
	        Dish dish8 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	
	        Dish dish9 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish10 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));

	        // Fourth level
	
	        Dish dish11 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish12 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));
	        Dish dish13 = new Dish("Machiatto",(float) 2.50,200,
	        		FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
		        	FXCollections.observableList( Arrays.asList("Getränke")));

	        // Build nodes

	        TreeItem<Dish> dish6Node = new TreeItem<>(dish6);

	        dish6Node.getChildren().addAll(new TreeItem<>(dish11), new TreeItem<>(dish12));

	        TreeItem<Dish> dish7Node = new TreeItem<>(dish7);

	        dish7Node.getChildren().addAll(new TreeItem<>(dish13));

	        TreeItem<Dish> dish2Node = new TreeItem<>(dish2);

	        dish2Node.getChildren().addAll(dish6Node, new TreeItem<>(dish8),dish7Node);
	
	        TreeItem<Dish> dish3Node = new TreeItem<>(dish3);
	
	        dish3Node.getChildren().addAll(new TreeItem<>(dish9), new TreeItem<>(dish10));

	        TreeItem<Dish> dish4Node = new TreeItem<>(dish4);
	
	        TreeItem<Dish> dish5Node = new TreeItem<>(dish5);
	
	        // Create the root node and add children
	
	        TreeItem<Dish> rootNode = new TreeItem<>(dish1);
	
	        rootNode.getChildren().addAll(dish2Node, dish3Node, dish4Node, dish5Node);
	
	 
	
	        return rootNode;
	
	    }
	 
	// Returns Person Id TreeTableColumn

	     public static TreeTableColumn<Dish, String> getNameColumn()

	     {
	         TreeTableColumn<Dish, String> nameColumn = new TreeTableColumn<>("SpeiseName");
	         nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
	         return nameColumn;
	     }

	     // Returns First Name TreeTableColumn

	     public static TreeTableColumn<Dish, Float> getPriceColumn()

	     {
	         TreeTableColumn<Dish, Float> firstNameCol = new TreeTableColumn<>("Preis");
	         firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("price"));
	         return firstNameCol;
	     }
	public TableTreeController() {
		// TODO Auto-generated constructor stub
	}

}
