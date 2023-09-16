import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private  Calculator calculator;

    @BeforeEach
    public void  beforeEach() {
        System.out.println("Before each was called");
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each was called");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all was called");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all was called");
    }

    @ParameterizedTest
    @CsvSource({"2,2,4", "2,6,8", "76,59,135", "-89,99,10"})
    void shouldAddTwoNumbers(int firstNumber, int secondNumber, int expectResult){

        // call function
        int result = calculator.sum(firstNumber,secondNumber);

        //check
        assertEquals(expectResult, result);
    }


    @ParameterizedTest
    @CsvSource({"10,2,5", "12,4,3", "76,76,1"})
    void  shouldDivideTwoNumbers(double firstNumber, double secondNumber, double expectResult){

        double result = calculator.divide(firstNumber, secondNumber);

        assertEquals(expectResult, result);

    }

    @Test
    void shouldReturnIllegalArgumentWhenTryingDivideByZero() {

        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1234, 0));
    }
}
