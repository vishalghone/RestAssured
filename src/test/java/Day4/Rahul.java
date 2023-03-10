package Day4;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Rahul {

	@Test
	public void gett() throws JsonProcessingException
	{
		Employee e=new Employee();
		e.setName("vishal");
		e.setJob("hr");
		Employee e2=new Employee();
		e2.setName("vishal2");
		e2.setJob("hr2");
		
		List<Employee>o=new ArrayList<Employee>();
		o.add(e);
		o.add(e2);
		
		ObjectMapper obj=new ObjectMapper();
		String jsonData=obj.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		System.out.println(jsonData);
		
//		baseURI="https://reqres.in/api/users";
		//get requestspecifiation 
		RequestSpecification requ=given();
		requ.baseUri("https://reqres.in/api/users");
        requ.contentType(ContentType.JSON);
        requ.body(jsonData);
		Response res=requ.post();
		res.prettyPrint();
		ResponseBody resbo=res.getBody();
		JsonPath view =resbo.jsonPath();
        String name = view.getString("name");
		System.out.println(name);
		

		
//		
//		int code=res.getStatusCode();
//		System.out.println(code);
//		ResponseBody body=res.getBody();
//		System.out.println(body.asString());
//		Assert.assertEquals(code, 200);
//		Headers list=res.getHeaders();
//		
//		for(Header header:list)
//		{
//			System.out.println(header.getName()+header.getValue());
//		}
		
		
	}
}
