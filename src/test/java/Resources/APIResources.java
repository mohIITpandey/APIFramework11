package Resources;

public enum APIResources {
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	
	private String resources;
	
	APIResources(String resources){
		this.resources=resources;
	}
	
	
public String getResourse() {
	return resources;
}

}
