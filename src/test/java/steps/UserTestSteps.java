package steps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserRequestBody;
import org.json.simple.JSONObject;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;


public class UserTestSteps {


    @Given("^create new user with firstName \"(.+)\", lastName \"(.+)\", userName \"(.+)\"$")
    public void givenTest(String firstName, String lastName, String username) throws JsonProcessingException {

//        JSONObject requestBody = new JSONObject();
//        requestBody.put("username", username);
//        requestBody.put("firstName", firstName);
//        requestBody.put("lastName", lastName);

        UserRequestBody userRequestBody = new UserRequestBody();
        userRequestBody.setFirstName(firstName);
        userRequestBody.setLastName(lastName);
        userRequestBody.setUsername(username);

        String requestBody = new ObjectMapper().writeValueAsString(userRequestBody);


        RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("accept","application/json")
                .body(requestBody)
                .post("https://petstore.swagger.io/v2/user")
                .then().statusCode(200);

    }
}
