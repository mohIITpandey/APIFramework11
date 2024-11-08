package Resources;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import pojoClasses.AddPlace;
import pojoClasses.Location;

public class testData {
 
	public AddPlace AddPayload(String name, String language, String Address) {
		
		AddPlace p=new AddPlace();

		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(language);
		p.setPhone_number("(+91)993 993 9939");
		p.setName(name);
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park1");
		myList.add("shoe1");
		p.setTypes(myList);
		Location location=new Location();
		location.setLat(-37.374893);
		location.setLng(33.579989);
		p.setLocation(location);
		return p;
	}
	
	public String DeletePayload(String placeid) {
		return "{\r\n"
				+ "\"place_id\": \""+placeid+"\""
				+ "\r\n}";
	}
}
