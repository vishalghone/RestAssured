package Day1;

import static io.restassured.RestAssured.*;
//rest assured provided predefine keywords are below
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
//given():- content type,set cookies,add auth add param,set headers
//when():- get post put delete
//then():- status code,extract response,extract headers cookies and response body
//restassured is an api/library through which can automate RestApis
public class HttepRequest {
	
	int id;
	
	@Test
	void getUsers()
	{
		
		Response res= given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2");
		  ; Assert.assertEquals(res.getStatusCode(),200);
		  System.out.println("this is my response"+res);
		
	}
	
	@Test(priority=2)
	void PutUsers()
	{
		HashMap data= new HashMap();
		data.put("name","vishal");
		data.put("job","leader");

		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		  
//		 .then()
//		  .statusCode(201)
//	      .log().all();
		
	}
//	
	@Test(priority=3)
	void UpdateUsers()
	{
		HashMap data= new HashMap();
		data.put("name","gulu");
		data.put("job","pean");

		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		  .put("https://reqres.in/api/users/+id")
		
		  
	 .then()
	      .statusCode(200)
	      .log().all();
		
	}
	@Test(priority=4)
	void DeleteUsers()
	{
	

		given()
	
		
		.when()
		  .delete("https://reqres.in/api/users/+id")
		
		  
	 .then()
	      .statusCode(204)
	      .log().all();
		
	}

}
