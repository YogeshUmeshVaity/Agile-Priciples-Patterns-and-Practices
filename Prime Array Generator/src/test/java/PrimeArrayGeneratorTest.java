import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PrimeArrayGeneratorTest {
    @Test
    public void return_null_array_when_input_is_less_than_two() {
        int[] nullArray = PrimeArrayGenerator.generatePrimes(1);
        assertEquals(0, nullArray.length);
    }

    @Test
    public void six_prime_numbers_when_input_15() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(15);
        assertEquals(6, primeNumbers.length);
    }

    @Test
    public void last_number_must_be_13_with_input_15() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(15);
        assertEquals(13, primeNumbers[5]);
    }

    @Test
    public void four_prime_numbers_when_input_7() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(7);
        assertEquals(4, primeNumbers.length);
    }

    @Test
    public void last_number_must_be_7_with_input_7() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(7);
        assertEquals(7, primeNumbers[3]);
    }

    @Test
    public void last_number_must_be_97_with_input_100() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(100);
        assertEquals(97, primeNumbers[24]);
    }

    @Test
    public void twenty_five_prime_numbers_when_input_100() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(100);
        assertEquals(25, primeNumbers.length);
    }

    @Test
    public void one_prime_number_when_input_2() {
        int[] minArray = PrimeArrayGenerator.generatePrimes(2);
        assertEquals(1, minArray.length);
    }

    @Test
    public void last_number_must_be_1_with_input_2() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(2);
        assertEquals(2, primeNumbers[0]);
    }

    @Test
    public void two_prime_number_when_input_3() {
        int[] minArray = PrimeArrayGenerator.generatePrimes(3);
        assertEquals(2, minArray.length);
    }

    @Test
    public void last_number_must_be_3_with_input_3() {
        int[] primeNumbers = PrimeArrayGenerator.generatePrimes(3);
        assertEquals(3, primeNumbers[1]);
    }

}
