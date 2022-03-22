/*package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/api";
    private static  RequestSpecification REQ_SPEC;
    private Cookies cookies;

    private RestWrapper(Cookies cookies){
        this.cookies = cookies;

        REQ_SPEC = new RequestSpecBuilder()
                .addCookie(cookies)
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RestWrapper LoginAs(String login, String password){

    }
}*/
