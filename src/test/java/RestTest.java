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
import utils.UserGenerator;

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
       List<UserPojoFull> users = UsersSteps.getUsers();
        assertThat(users).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");

    }

    //созд. тест на проверку мет.API createUser
    @Test
    public void  createUser(){
        CreateUserRequest rq= UserGenerator.getSimpleUsers();

        UsersSteps userApi = new UsersSteps();
        //передаём в метод createUser объект с описанием юзера, который нужно создать
        CreateUserResponse rs = userApi.createUser(rq);




        assertThat(rs)
                .isNotNull() // проверяем, что ответ не null
                .extracting(CreateUserResponse::getName)//проверяем, что имя в ответе соответствует имени в запросе
                .isEqualTo(rq.getName());
    }
}
