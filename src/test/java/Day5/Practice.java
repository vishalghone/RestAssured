package Day5;

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

public class Practice {
	@Test(priority=1)
	public void get()
	{
		
		baseURI="https://reqres.in/api/users";
		 given()
		.contentType(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority=2)
	public void put()
	{
		JSONObject js=new JSONObject();
		js.put("name","gulam");
		js.put("job","devops");
		
		baseURI="https://reqres.in/api/users";
		 given()
		.contentType(ContentType.JSON)
		.body(js.toJSONString())
		.when()
		.post()
		.then()
		.statusCode(201)
		//.body("data.email","george.bluth@reqres.in")
		.headers("Connection","keep-alive")
		.log().all();
		
	}

}
