package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.CreateUserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;


import java.util.List;

import static io.restassured.RestAssured.given;


public class UsersSteps {
    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api")
            .setBasePath("/users")
            .setContentType(ContentType.JSON)
            .build();



    //1 подход реализации степов: создание статичных методов,
    //которые полностью выполняют бизнес действия и возвращают его результат

    //этот метод возвращает список юзеров в виде объектов соответствующего pojo класса
    public static List<UserPojoFull> getUsers(){
        return  given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }

    //2 подход: сохранение результатов бизнес действия в локальную переменную и
    //создание доп.методов, которые что-то делают с этой переменной (методы обычно не статические)

    //создадим локальную переменную user, в которую метод createUser будет сохранять результат
    //при этом этот эе метод сможет его возвращать как return знач.,
    //а может вывзращать экземпляр данного класса, чтобы строить цепочки как и билдер (про билдер выше)
    private CreateUserResponse user;
    public  CreateUserResponse createUser(CreateUserRequest rq){
        user = given().body(rq).post().as(CreateUserResponse.class);
        return user;
    }

    //мет. возвзращает значения последнего созданного юзера
    public  UserPojoFull getUser(){
        return given().get("/" + user.getId()).as(UserPojoFull.class);
    }

    //такой же, но статичный метод, надо передавать парметром id пользователя, которого мы хотим получить
    /*public  static UserPojoFull getUser(int id){
        return  given().get("/" + id).as(UserPojoFull.class);
    }*/
}
