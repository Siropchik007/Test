package pojos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import  lombok.Data;
import lombok.NoArgsConstructor;


//создаём класс, который будет соответствовать JSON,
//который передаётся в теле запроса(данными пользователя, которого мы хотим создать)
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String job;
}
