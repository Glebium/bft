import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;


@Epic("Exception testing")
public class ExceptionTest {
    @Test
    void exception() {
        try {
            String x = null;
            System.out.println(x);
            Assertions.assertTrue(false);
        } catch (AssertionFailedError e) {
            System.out.println("Обработка ошибки: AssertionFailedError");
        }
    }
}
