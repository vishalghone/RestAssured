package Day5;

import static io.restassured.RestAssured.*;
//rest assured provided predefine keywords are below
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ParsingXmlResponse {
	
	@Test
	void getUsers()
	{
		
		Response res= given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2");
		  
//		 .then()
//		  .statusCode(200)
//		  .body("page",equalTo(2))
//		  .log().all();
		  
		  Assert.assertEquals(res.getStatusCode(),200);
		  System.out.println("this is my response"+res);
		
	}


}
