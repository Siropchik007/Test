import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

//переключение на др.тип циклов, в котором инициал-ся общий контекст для тестов данного класса
//нужно быть осторожней, если есть static пер.класса (?)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("lesson5_6")
public class  lesson5{

    @Test
    public void test(){
        String dog = "Test Jack";
        System.out.println(dog);
    }

    @Test
    public void test2(){
        String dog = "Test №2 Doggie";
        System.out.println(dog);
    }

    @ParameterizedTest
    @MethodSource
    public void TestAge(Age age, String type){
        String dog = "Jack ";
        String breed  = "Chihuahua ";
        System.out.println("Имя: "+ dog);
        System.out.println("Порода: "+ breed);
        System.out.println("Возраст: " + age +" " + type);
    }

    static Stream<Arguments> TestAge(){
        return Stream.of(
                Arguments.arguments(Age.YOUNG, "щенок"),
                Arguments.arguments(Age.ADULT, "взрослая"),
                Arguments.arguments(Age.OLD, "старая")
        );

    }

    enum Age{
        YOUNG("молодая"),
        ADULT("взрослая"),
        OLD("пожилая");

        private String AgeTranslate;

        Age(String AgeTranslate){
            this.AgeTranslate = AgeTranslate;
        }

        public String GetAgeTranslate(){
            return AgeTranslate;
        }
    }

    @ParameterizedTest
    //@ValueSource(ints = {1, 5, 8, 4})
    //@EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"BIG"})
    //@EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = {".*G"}) выбираем ВСЕ размеры, которые заканчиваеются на G
    @MethodSource
    public void ParamsTest(Size size, String translate){
        String dog = "Jack ";
        String breed  = "Chihuahua ";
        System.out.println("Имя: "+ dog);
        System.out.println("Порода: "+ breed);
        System.out.println("Возраст: ");
        System.out.println("Размер: " + size +" "+ size.GetSizeTranslate() + " " + translate);
    }


    static Stream<Arguments> ParamsTest(){
        return Stream.of(
                Arguments.arguments(Size.SMALL, "маленькая из статика"),
                Arguments.arguments(Size.AVERAGE, "средняя из статика"),
                Arguments.arguments(Size.BIG, "большая из статика")
        );

    }

    enum Size{

        SMALL("маленькая"),
        AVERAGE("средняя"),
        BIG("большая");

        private String SizeTranslate;

        Size(String SizeTranslate){
            this.SizeTranslate = SizeTranslate;
        }

        public String GetSizeTranslate(){
            return SizeTranslate;
        }

    }

    @AfterAll
     public static void AfAlltest(){
        System.out.println("Tests After All");

    }

    @BeforeAll
     public static void BAlltest(){
        System.out.println("Tests Before All");
    }

    //не должны быть статичны
    @BeforeEach
    public void BEachtest(){
        System.out.println("Tests Before Each");
    }

    @AfterEach
    public void AfEachtest(){
        System.out.println("Tests After Each");
        System.out.println(" ");
    }



}
