package controlling.view;
import controlling.MainApp;
import controlling.modelling.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;


public class MenuOverviewController 


{
		// TODO Auto-generated constructor stub
		@FXML
	    private TableView<Dish> personTable;
	    @FXML
	    private TableColumn<Dish, String> firstNameColumn;
	    @FXML
	    private TableColumn<Dish, Float> lastNameColumn;

	    @FXML
	    private Label firstNameLabel;
	    @FXML
	    private Label lastNameLabel;
	    @FXML
	    private Label streetLabel;
	    @FXML
	    private Label postalCodeLabel;
	    @FXML
	    private Label cityLabel;
	    @FXML
	    private Label birthdayLabel;

	    // Reference to the main application.
	    private MainApp mainApp;

	    /**
	     * The constructor.
	     * The constructor is called before the initialize() method.
	     */
	    public MenuOverviewController() 
	    {
	    }
	    
	    	/**
	         * Initializes the controller class. This method is automatically called
	         * after the fxml file has been loaded.
	         */
	        @FXML
	        private void initialize() {
	            // Initialize the person table with the two columns.
	            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
	            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
	    }
	        /**
	         * Is called by the main application to give a reference back to itself.
	         * 
	         * @param mainApp
	         */
	        public void setMainApp(MainApp mainApp) {
	            this.mainApp = mainApp;

	            // Add observable list data to the table
	          //  personTable.setItems(mainApp.getM());
	        }
	

}
