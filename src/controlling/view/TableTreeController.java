package controlling.view;

import java.util.Arrays;

import javax.xml.bind.JAXBException;

import controlling.MainApp;
import controlling.modelling.Dish;
import controlling.modelling.Ingredient;
import controlling.modelling.Menu;
import controlling.modelling.MenuDataManager;
import controlling.modelling.Dish;
import controlling.modelling.Submenu;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.*;
public class TableTreeController extends AnchorPane{
	@FXML
	private TreeTableView menu_tabelle;
	@FXML
	private TreeTableColumn column1_name;
	@FXML
	private TreeTableColumn column2_tags;
	@FXML
	private TreeTableColumn column3_size;
	@FXML
	private TreeTableColumn column4_price;
	
	private MainApp mainApp;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public TreeTableView createTree(Menu menu)
	{
	
	 
	  final TreeItem dummyRoot = new TreeItem(menu);
      this.menu_tabelle = new TreeTableView(dummyRoot);
      menu_tabelle.setShowRoot(true);
      
      //Instantiate Columns
      
      this.column1_name = new TreeTableColumn("Name");
      this.column1_name.setPrefWidth(150);
      this.column1_name.setCellValueFactory(new Callback() {
          @Override
          public Object call(Object obj)
          {
              final Object dataObj = ((TreeTableColumn.CellDataFeatures) obj).getValue().getValue();
              if (dataObj instanceof Submenu) {
                  return new ReadOnlyStringWrapper(String.valueOf(((Submenu) dataObj).getName()));
              }
              else if (dataObj instanceof Dish) {
                  return new ReadOnlyStringWrapper(String.valueOf(((Dish) dataObj).getName()));
              }
              return null;
          }
      });
       this.column2_tags = new TreeTableColumn("Tags");
      this.column2_tags.setPrefWidth(150);

      this.column2_tags.setCellValueFactory(new Callback() {
          @Override
          public Object call(Object obj)
          {
              final Object dataObj = ((TreeTableColumn.CellDataFeatures) obj).getValue().getValue();
              if (dataObj instanceof Dish) {
                  return new ReadOnlyStringWrapper(String.join(", ",((Dish) dataObj).getTags()));
              }
              return null;
          }
      });
      this.column3_size = new TreeTableColumn("Size");
      this.column3_size.setPrefWidth(100);
      this.column3_size.setCellValueFactory(new Callback() {
          @Override
          public Object call(Object obj)
          {
              final Object dataObj = ((TreeTableColumn.CellDataFeatures) obj).getValue().getValue();
              if (dataObj instanceof Dish) {
                  return new ReadOnlyStringWrapper(((Dish) dataObj).getSize()+((Dish) dataObj).getUnits().toString());
              }
              return null;
          }
      });
		
		this.column4_price = new TreeTableColumn("Price");
      this.column4_price.setPrefWidth(100);
      this.column4_price.setCellValueFactory(new Callback() {
          @Override
          public Object call(Object obj)
          {
              final Object dataObj = ((TreeTableColumn.CellDataFeatures) obj).getValue().getValue();
              if (dataObj instanceof Dish) {
                  return new ReadOnlyStringWrapper(((Dish) dataObj).getPrice()+"EUR");
              }
              return null;
          }
      });
      this.menu_tabelle.getColumns().setAll(column1_name, column2_tags,column3_size,column4_price);
      
      //Adding Data to the Tree
  
     // List<Department> deptList = buildData();
      FXCollections.observableArrayList(menu.getSubmenues()).stream().forEach((submenu) -> {
          final TreeItem submenuTreeItem = new TreeItem(submenu);
          dummyRoot.getChildren().add(submenuTreeItem);
          FXCollections.observableArrayList(submenu.getDishes()).stream().forEach((dish) -> {
              submenuTreeItem.getChildren().add(new TreeItem(dish));
          });
      });
      
      
      return menu_tabelle;
	}


	// Returns Person Id TreeTableColumn

	public TreeTableView getMenu_tabelle() {
		return menu_tabelle;
	}


	public void setMenu_tabelle(TreeTableView menu_tabelle) {
		this.menu_tabelle = menu_tabelle;
	}


	public static TreeTableColumn<Dish, String> getNameColumn()

	{
		TreeTableColumn<Dish, String> nameColumn = new TreeTableColumn<>("e");
		nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		return nameColumn;
	}

	// Returns First Name TreeTableColumn

	public static TreeTableColumn<Dish, Float> getPriceColumn()

	{
		TreeTableColumn<Dish, Float> firstNameCol = new TreeTableColumn<>("s");
		firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("price"));
		return firstNameCol;
	}

	
	private void initialize() {
		 
		// this.menu_tabelle=new TreeTableView(createTree(menu));
		// Initialize the person table with the two columns.
		// firstNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().nameProperty());
		// lastNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().priceProperty().asObject());
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		// personTable.setItems(mainApp.getM());
	}

	public TableTreeController() {
		try {
			Menu m2=MenuDataManager.loadXML_Data_Menu();
			this.menu_tabelle=this.createTree(m2);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	this.menu_tabelle=new TreeTableView(this.createTree(menu));
		// TODO Auto-generated constructor stub
		
	}

}
