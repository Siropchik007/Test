//import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestTest {

    @Test
    public void getUsers(){
        given()
                .baseUri("https://ws.footballpool.dataaccess.eu/info.wso?wsdl")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(500);

    }
}
