package FeatureStepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import Resources.APIResources;
import Resources.Utilss;
import Resources.testData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClasses.AddPlace;
import pojoClasses.Location;

public class StepDefinition extends Utilss {
	
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	static String placeid;
	
	testData data=new testData();

	@Given("Add Place Payload with {string} {string}  {string}")
	public void add_place_payload_with(String name, String language, String Address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 res = given().spec(requestSpecification()).body(data.AddPayload(name,language,Address));
		
		
	}
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resources, String httpMethod) {
    // Write code here that turns the phrase above into concrete actions
		 APIResources APIResourcess = APIResources.valueOf(resources); 
		
		 if(httpMethod.equalsIgnoreCase("POST"))
		    response = res.when().post(APIResourcess.getResourse());
		 else if(httpMethod.equalsIgnoreCase("GET"))
		    response = res.when().get(APIResourcess.getResourse());

					}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
        Assert.assertEquals(response.statusCode(),200);
        
	}
	
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String Expectedvalue) {

     Assert.assertEquals(JsonPathConvert(response, key), Expectedvalue);  
	}
	
	
	@Then("verify the place_id created maps to {string} by using {string}")
	public void verify_the_place_id_created_maps_to_by_using(String ExpName, String httpmethodRes) throws IOException {
	   
	    placeid=JsonPathConvert(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id",placeid);
		user_calls_with_http_request(httpmethodRes, "GET");
		  String ActName = JsonPathConvert(response,"name");
		  Assert.assertEquals(ActName, ExpName);
		
	}
	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException {
	  res= given().spec(requestSpecification()).body(data.DeletePayload(placeid));
	}




}
