package utils;


//предполагая, что мы во многих местах будем создавать юзера с одинаковыми параметрами и получать его данные
//вынесем его создание в отдельный генератор

import pojos.CreateUserRequest;
import pojos.CreateUserResponse;

//в таком генераторе можно создать много ризличных типов юзеров или других сущностей и переиспользовать их в разных тестах
public class UserGenerator {

    public static CreateUserRequest getSimpleUsers(){
        return CreateUserRequest.builder()
                .name("simple")
                .job("automation")
                .build();
    }
}
