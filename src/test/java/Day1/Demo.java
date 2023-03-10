package Day1;


import static io.restassured.RestAssured.*;
//rest assured provided predefine keywords are below
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Demo {
	
	//@Test
	public void re()
	{
		Response res= get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println("StatusCode :"+ res.getStatusCode());
		

				
		
	}
	
	@Test
	public void re2()
	{
	baseURI="https://reqres.in/api/users";
	given().queryParam("page","2")
		.when().get()
		.then().statusCode(200);
		
		
		

				
		
	}
	
	

}
