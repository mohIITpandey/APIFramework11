package FeatureStepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException {
		//Write a code that will give u place id
		//Execute the code when place id is null
		
		if(StepDefinition.placeid==null) {
		StepDefinition def=new StepDefinition();
		def.add_place_payload_with("Abhishek","French", "India");
		def.user_calls_with_http_request("AddPlaceAPI", "POST");
		def.verify_the_place_id_created_maps_to_by_using("Abhishek", "getPlaceAPI");
	}
	}
}
