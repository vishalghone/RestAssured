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
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Reqestspecification {
	@Test
	public void gett()
	{
//		baseURI="https://reqres.in/api/users";
		//get requestspecifiation 
		RequestSpecification requ=given();
		requ.baseUri("https://reqres.in/api/users");
		
		Response res=requ.get();
		
		int code=res.getStatusCode();
		System.out.println(code);
		ResponseBody body=res.getBody();
		System.out.println(body.asString());
		Assert.assertEquals(code, 200);
		Headers list=res.getHeaders();
		
		for(Header header:list)
		{
			System.out.println(header.getName()+header.getValue());
		}
		
		
	}
	

}
