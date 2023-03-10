package Day4;

import static io.restassured.RestAssured.*;
//rest assured provided predefine keywords are below
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import io.restassured.specification.RequestSpecification;

public class Gulam {
	
	public static HashMap h=new HashMap();
	
	
	@BeforeClass
	public void startclass()
	{
		h.put("name",Employee.getName());
		h.put("name",Employee.getJob());
		baseURI="https://reqres.in/api/users";
		
	}
	
	@Test
	public void testt()
	{
		
	    given()
		.contentType(ContentType.JSON)
		.body(h)
		.when()
		.post()
		.then()
		.statusCode(201)
		.log().all();
		
		
		
	}
	
	
	

}
