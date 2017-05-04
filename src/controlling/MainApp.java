package controlling;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import controlling.modelling.Dish;
import controlling.view.MenuOverviewController;
import controlling.view.TableTreeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RestaurantApp");

        initRootLayout();

        showMenuOverview();
     // Create the RootNode
   
                
        
                // Create the VBox
       // VBox root = new VBox(treeTable);

                // Set the Style-properties of the VBox
    
             /*   root.setStyle("-fx-padding: 10;" +
     
                        "-fx-border-style: solid inside;" +
   
                        "-fx-border-width: 2;" +

                        "-fx-border-insets: 5;" +
   
                        "-fx-border-radius: 5;" +
   
                        "-fx-border-color: blue;");*/
  
                // Create the Scene
 
           //     Scene scene = new Scene(root);
                   // Add the Scene to the Stage
   
           //    primaryStage.setScene(scene);
 
                // Set the Title
    
          //      primaryStage.setTitle("A TreeTableView with Data");
       
                // Display the Stage
      

          //      primaryStage.show();

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
            //paste
            TreeItem<Dish> rootNode = TableTreeController.getModel();
            
            rootNode.setExpanded(true);

            // Create a TreeTableView with model

            TreeTableView<Dish> treeTable = new TreeTableView<>(rootNode);

            treeTable.setPrefWidth(400);

            // Add columns to the TreeTableView

            treeTable.getColumns().add(TableTreeController.getNameColumn());

            treeTable.getColumns().add(TableTreeController.getPriceColumn());
            treeTable.autosize();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showMenuOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/menuOverview.fxml"));
            AnchorPane menuOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(menuOverview);
        } catch (IOException e) {
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

    public static void main(String[] args) {
        launch(args);
    }
}