package controlling.modelling;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;




@XmlRootElement(name = "menu")
public class MenuDataManager 
{
		private static String path_xml=System.getProperty("user.dir")+"\\src\\controlling\\modelling\\Submenu.xml";
		// TODO Auto-generated constructor stub
	/*	private List<Dish> dishes;

	    @XmlElement(name = "dish")
	    public List<Dish> getDishes() {
	        return dishes;
	    }

	    public void setPersons(List<Dish> dishes) {
	        this.dishes = dishes;
	    }*/
	 public static Submenu loadXML_Data () throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Submenu.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Submenu d = (Submenu) jaxbUnmarshaller.unmarshal( new File(path_xml) );
		     
		   // for(Integer empId : empMap.getEmployeeMap().keySet())
		    {
		      //  System.out.println(empMap.getEmployeeMap().get(empId).getFirstName());
		      //  System.out.println(empMap.getEmployeeMap().get(empId).getLastName());
		    }
		    return d;
	 }
	 public static Dish loadXML_Data_Dish () throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Dish.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Dish d = (Dish) jaxbUnmarshaller.unmarshal( new File(System.getProperty("user.dir")+"\\src\\controlling\\modelling\\Dish.xml") );
		     
		   // for(Integer empId : empMap.getEmployeeMap().keySet())
		    {
		      //  System.out.println(empMap.getEmployeeMap().get(empId).getFirstName());
		      //  System.out.println(empMap.getEmployeeMap().get(empId).getLastName());
		    }
		    return d;
	 }
	 
	 public static void saveXML_Data (Submenu d) throws JAXBException
	 {
		 JAXBContext jaxbContext = JAXBContext.newInstance(Submenu.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
		    //jaxbMarshaller.marshal(d, System.out);
		    jaxbMarshaller.marshal(d, new File(path_xml));
	 }
	

}
