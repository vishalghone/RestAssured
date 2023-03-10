package Day1;

import static io.restassured.RestAssured.*;
//rest assured provided predefine keywords are below
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postt {
	
	@Test
	public void postmethod()
	{
		JSONObject data= new JSONObject();
		data.put("name","vishal");
		data.put("job","leader");
		baseURI="https://reqres.in/api/users";
		given()
		.body(data.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.statusCode(201).log().all();
		
		
		
	}
	@Test
	public void putmethod()
	{
		JSONObject data= new JSONObject();
		data.put("name","gulam");
		data.put("job","peaon");
		baseURI="https://reqres.in/api/users/716";
		given()
		.body(data.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.put()bfj
		.then()
		.statusCode(200).log().all();
		
	}
	
	@Test
	public void Deletemethod()
	{
//		JSONObject data= new JSONObject();
//		data.put("name","gulam");
//		data.put("job","peaon");
		baseURI="https://reqres.in/api/users/716";
		given()
//		.body(data.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.delete()
		.then()
		.log().all().statusCode(204);
		
		
		
	}

}
