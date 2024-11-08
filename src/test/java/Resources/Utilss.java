package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilss {
	
  static RequestSpecification reqspec;
public RequestSpecification requestSpecification() throws IOException {
	
	
	if(reqspec==null) {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
	reqspec = new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseUrl")).addQueryParam("key","qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
	return reqspec;}
	return reqspec;
}

public String getGlobalProperties(String key) throws IOException {
	Properties p = new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Niran\\eclipse-workspace\\APIFramework\\src\\test\\java\\Resources\\global.properties");
	p.load(fis);
	return p.getProperty(key);
	
}

public String JsonPathConvert(Response res,String key ) {
	String resString = res.asString();
	JsonPath js= new JsonPath(resString);
	 return js.get(key).toString();
}

	
}
