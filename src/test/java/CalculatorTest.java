import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
    SELİN AKKAŞ
    B2011202006
    SOFTWARE VALIDATION AND VERIFICATION
    HOMEWORK
    https://github.com/selinakkas/SWE202-TDDHomework
 */
class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({
            "10,5,2",
            "10,2.5,4",
            "12.5,2.5,5",
            "10,4,2.5",
            "12.5,5,2.5"
    })
    void dataDrivenDivisonTest(double a, double b, double expected){
        assertEquals(expected, Calculator.divide(a, b),
                "The result of the division is incorrect");
    }

    @ParameterizedTest
    @CsvSource({"12.5, 0.0"})
    void dataDrivenDivisonExceptionTest(double a, double b){

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(a, b),
                "Divide by zero exception expected."
        );
    }
}