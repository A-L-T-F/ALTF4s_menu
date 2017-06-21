package controlling.view;



import javax.xml.bind.JAXBException;

import controlling.MainApp;
import controlling.modelling.*;
import controlling.modelling.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
@SuppressWarnings({"rawtypes", "LossyEncoding"})
public class TableTreeController {
	
	@FXML
	private TableView <Ingredient>ingredients_table;
	@FXML
	private TableColumn <Ingredient,String> table_column1_name;
	@FXML
	private TableColumn <Ingredient,Integer> table_column2_amount;
	@FXML
	private TableColumn <Ingredient,String> table_column3_comment;
	
	@FXML
	 private TreeTableView menu_table;
	
	@FXML
	 private TreeTableColumn column1_name;
	@FXML
	 private TreeTableColumn column2_tags;
	@FXML
	 private TreeTableColumn column3_size;
	@FXML
	 private TreeTableColumn column4_price;
	@FXML
	 private Label caption_north;
	
	public Label getCaption_north() {
		return caption_north;
	}


	public void setCaption_north(Label caption_north) {
		this.caption_north = caption_north;
	}

	private MainApp mainApp;


	public TreeTableView getMenu_tabelle() {
		return menu_table;
	}


	public void setMenu_tabelle(TreeTableView menu_tabelle) {
		this.menu_table = menu_tabelle;
	}


	

	
	@FXML
	private void initialize() 
	{

	}
		

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		createTableTree();
		createTable();
			
	}

	@SuppressWarnings("unchecked")
	private void createTable () 
	{
		try {
		this.table_column1_name .setText("Name");
		
		this.table_column2_amount.setText("Menge");
		this.table_column3_comment .setText("Information");
		this.ingredients_table.getColumns().setAll(this.table_column1_name,this.table_column2_amount,this.table_column3_comment);
		
			ObservableList <Ingredient> ingredients_data= FXCollections.observableList(new MenuDataManager().loadXML_Data_Ingredients());
			this.ingredients_table.setItems(ingredients_data);
			this.table_column1_name.setCellValueFactory(celldata->celldata.getValue().nameProperty());
		this.table_column2_amount.setCellValueFactory(celldata-> celldata.getValue().unitsProperty().asObject());
	//	this.ingredients_table.autosize();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public TableTreeController() {
	}

	@SuppressWarnings("unchecked")
	private void createTableTree()
	{
		
		try {
			Menu menu=MenuDataManager.loadXML_Data_Menu();
			 TreeItem dummyRoot = new TreeItem(menu);
		      this.menu_table.setRoot(dummyRoot);
		      this.menu_table.setShowRoot(true);
		      this.menu_table.autosize();

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
		      this.column3_size = new TreeTableColumn("Grösse");
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
		          }
		      );

				this.column4_price = new TreeTableColumn("Preis");
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
		      this.menu_table.getColumns().setAll(this.column1_name, this.column2_tags,this.column3_size,this.column4_price);

		      //Adding Data to the Tree


		      FXCollections.observableArrayList(menu.getSubmenues()).stream().forEach((submenu) -> {
		           TreeItem submenuTreeItem = new TreeItem(submenu);
		          dummyRoot.getChildren().add(submenuTreeItem);
		          FXCollections.observableArrayList(submenu.getDishes()).stream().forEach((dish) -> {
		              submenuTreeItem.getChildren().add(new TreeItem(dish));
		          });
		      });


		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
