import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//переключение на др.тип циклов, в котором инициал-ся общий контекст для тестов данного класса
//нужно быть осторожней, если есть static пер.класса (?)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    @ValueSource(ints = {1, 5, 8, 4})
    public void ParamsTest(int age){
        String dog = "Jack ";
        String breed  = "Chihuahua ";
        System.out.println("Имя: "+ dog);
        System.out.println("Порода: "+ breed);
        System.out.println("Возраст: "+ age);
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
