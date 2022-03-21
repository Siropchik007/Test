package utils;
import  com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//создаём кастомный десериализатор,указываем как строку с датой JSON преобразовать в нужный нам тип даты
//на вход метод получает 2 аргумента:
//1) парсер, из которого можно вытищить текст, который мы пытаемся десериализовать
//2) мета данные десериализатора (текущие настройки даты, кэш, буфер и т.д.)
public class DateDeserializer  extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        //создаём форматер, который содержит паттерн, описывающий формат даты в java time формате
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'z'");
        return LocalDateTime.parse(jsonParser.getText(), formatter);
    }
}
