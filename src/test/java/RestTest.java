//import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import pojos.JsonUsers;
import com.fasterxml.jackson.core.base.GeneratorBase;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {

    @Test
    public void getUsers(){
       List<JsonUsers> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", JsonUsers.class);
                //.body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));


    }
}
