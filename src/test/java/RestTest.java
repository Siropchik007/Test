//import jdk.jfr.ContentType;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import pojos.CreateUserRequest;
import pojos.JsonUsers;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;
import steps.UsersSteps;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class RestTest {

    //т.к. в тестах присутствуют повторяющиеся действия
    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setBasePath("/users")
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void getUsers(){
       List<UserPojoFull> users = UsersSteps.getUsers();//теперь мы все эти строки заменяем одной строкой (метод из UsersSteps)
               // given()

                /*.baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                эти строки заменяем спецификацией, которую мы написали выше*/

               //.spec(REQ_SPEC)
                //.when().get()
               // .then()
                //.statusCode(200)
                //.extract().jsonPath().getList("data", JsonUsers.class);
                //.body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));


        assertThat(users).extracting(UserPojoFull::getFirstName).contains("simple");

    }

    //созд. тест на проверку мет.API createUser
    @Test
    public void  createUser(){
        CreateUserRequest rq= CreateUserRequest.builder()
                .name("simple")
                .job("automation")
                .build();
        /*CreateUserResponse rq =new CreateUserResponse();
        rq.setName("Petr");
        rq.setJob("programmer");*/

        UsersSteps userApi = new UsersSteps();
        //передаём в метод createUser объект с описанием юзера, который нужно создать
        CreateUserResponse rs = userApi.createUser(rq);


        //CreateUserResponse rs = given()
                /*.baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON) заменяем спецификацией сверху*/
               // .spec(REQ_SPEC)
               // .body(rq) // передаём объект запроса
               // .when().post() //указываем, что это post функция
                //.then().extract().as(CreateUserResponse.class); //указываем, что JSON можно преобразовать объект с помощью класса CreateUserResponse

        assertThat(rs)
                .isNotNull() // проверяем, что ответ не null
                .extracting(CreateUserResponse::getName)//проверяем, что имя в ответе соответствует имени в запросе
                .isEqualTo(rq.getName());
    }
}
