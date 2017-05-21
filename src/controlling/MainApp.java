package controlling;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.JAXBException;

import controlling.modelling.Dish;
import controlling.modelling.Ingredient;
import controlling.modelling.Menu;
import controlling.modelling.MenuDataManager;
import controlling.modelling.Submenu;
import controlling.view.MenuOverviewController;
import controlling.view.TableTreeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane menuLayout;
    private TableTreeController menu_controller;

    @Override
    public void start(Stage primaryStage) throws JAXBException 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RestaurantApp");

        initRootLayout();

        try {
			showMenuOverview();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     * @throws JAXBException 
     */
    public void showMenuOverview() throws JAXBException {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
           
            loader.setLocation(MainApp.class.getResource("view/menuOverview.fxml"));
           
            this.menuLayout = (AnchorPane) loader.load();
            
            this.menu_controller = loader.getController();
            		
         
           
          // menuLayout.getChildren().addAll(this.menu_controller.getMenu_tabelle());
           
            
        
            rootLayout.setCenter(this.menuLayout);
          this.menu_controller.setMainApp(this);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args)
    {
    	
    	try {
    		System.out.println(System.getProperty("user.dir")+"\\src");
    	Dish dish1 = new Dish("Machiatto",(float) 2.50,200,"Das leckerste kaffe der welt",
	        	FXCollections.observableList( Arrays.asList(new Ingredient("wasser",200),new Ingredient("kaffebohnen",30))),
	        	FXCollections.observableList( Arrays.asList("Getränke")));
    	Submenu sb1= new Submenu("Vegetarisch","ohne fleisch",Arrays.asList(dish1));
    	Menu m= new Menu("Unsere Speisekarte","Beste Speisen der Welt!",Arrays.asList(sb1));
			MenuDataManager.saveXML_Data_Menu(m);
			/*
			Dish dish2=MenuDataManager.loadXML_Data_Dish();
			System.out.println(dish2.getName());
			System.out.println(dish2.getPrice()+"$");
			
			for(String j : dish2.getTags())
			{
			System.out.print(" "+j+",");
			
			}
			for(Ingredient i : dish2.getIngredients())
			{
			System.out.print(" "+i.getName()+" ");
			System.out.print(i.getUnits()+" units,");
			}
			*/
			
			Submenu sub3=MenuDataManager.loadXML_Data();
			Menu m2=MenuDataManager.loadXML_Data_Menu();
			System.out.println(m2.getName());
			System.out.println(m2.getDescription());
			System.out.println(m2.getCurent_date_as_string());
			for (Submenu sub2:m2.getSubmenues())
			{
			System.out.println(sub2.getName());
			System.out.println(sub2.getDescription());
			for (Dish d:sub2.getDishes())
			{
				System.out.println(d.getName());
				System.out.println(d.getDescription());
				System.out.println(d.getPrice()+"$");
				System.out.print(d.getSize()+d.getUnits().toString());
				for(Ingredient i : d.getIngredients())
				{
					System.out.print(" "+i.getName()+" ");
					System.out.print(i.getUnits()+" units,");
				}
				for(String j : d.getTags())
				{
				System.out.print(" "+j+",");
				
				}
			}
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("end");		
        launch(args);
    }
}