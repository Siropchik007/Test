package pojos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import lombok.Data;
import utils.DateDeserializer;

import java.time.LocalDateTime;
//создаём класс, который будет соответствовать JSON ответа
@Data
public class CreateUserResponse {
    private String name;
    private String job;
    private int id;
    //преобразовываем по паттерну дату, которая содрежится в переменной, в тип String
    // 'T' - если хотим добавить букву, то должны поставить одинарные ковычки
    // Z - добавляем тайм зону
    //порядок временных единиц можно менять. Символы, которые их разделяют тоже
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    //наследуем кастомный десериализатор
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
}
