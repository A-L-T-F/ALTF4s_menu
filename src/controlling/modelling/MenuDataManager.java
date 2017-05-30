package controlling.modelling;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;






public class MenuDataManager 
{
	private static String path_xml=System.getProperty("user.dir")+"\\src\\controlling\\modelling\\";
	
	
	public List <Ingredient> loadXML_Data_Ingredients() throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(ListWrapper_Ingredients.class);
		 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 List<Ingredient> temp= ((ListWrapper_Ingredients)jaxbUnmarshaller.unmarshal(new File(path_xml+"Ingredients.xml"))).getListWrapper();
		return temp;
		
	}
	
	public  void saveXML_Data_Ingredients (List<Ingredient> list) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(ListWrapper_Ingredients.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	   // MenuDataManager.ListWrapper_Ingredients
	    ListWrapper_Ingredients y=new ListWrapper_Ingredients();
	    y.setListWrapper(list);
	    jaxbMarshaller.marshal( y, new File(path_xml+"Ingredients.xml"));
	}
	
	 public static Submenu loadXML_Data_Submenu () throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Submenu.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Submenu d = (Submenu) jaxbUnmarshaller.unmarshal( new File(path_xml+"Submenu.xml") );
		    return d;
	 }
	 
	 public static Dish loadXML_Data_Dish () throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Dish.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Dish d = (Dish) jaxbUnmarshaller.unmarshal( new File(path_xml+"Dish.xml") );
		    return d;
	 }
	 
	 public static void saveXML_Data_Submenu (Submenu d) throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Submenu.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(d, new File(path_xml));
	 }
	 
	 public static void saveXML_Data_Menu (Menu d) throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();	 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(d, new File(path_xml+"Menu.xml"));
	 }
	 
	 public static Menu loadXML_Data_Menu () throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Menu d = (Menu) jaxbUnmarshaller.unmarshal( new File(path_xml+"Menu.xml") );  
		    return d;
	 }
	@XmlRootElement
	     static class  ListWrapper_Ingredients
		{
		@XmlElement
			private  List <Ingredient> ingredient;
			List <Ingredient> getListWrapper()
			{
				return this.ingredient;
			}
			void setListWrapper(List<Ingredient>thelist)
			{
			this.ingredient=thelist;
			}
		}
}
