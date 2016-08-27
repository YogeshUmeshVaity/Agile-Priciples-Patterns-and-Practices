/**
 * Generates the array that contains prime numbers up to the number specified by user.
 * Uses sieve algorithm by Eratosthenes.
 */
class PrimeArrayGenerator {
    private static int size = 0;
    private static int[] inputArray;
    private static boolean[] numbersToCrossOut;
    static int[] generatePrimes(final int maxValue) {
        if (maxValue < 2) return new int[0];
        initializeSieve(maxValue);
        sieve();
        return getAllPrimes(countPrimes());
    }

    private static void sieve() {
        crossOutFirstTwoNumbers();
        crossOutMultiples();
    }

    private static void initializeSieve(final int maxValue) {
        size = maxValue + 1;

        inputArray = fillInputArray(size);
        numbersToCrossOut = fillCrossOutArray();
    }

    private static int[] getAllPrimes(final int primeCount) {
        int[] primes = new int[primeCount];
        for (int i = 0, j = 0; i < size; i++) {
            if (numbersToCrossOut[i]) {
                primes[j++] = inputArray[i];
            }
        }
        return primes;
    }

    private static int countPrimes() {
        int primeCount = 0;
        for (int i = 0; i < size; i++) {
            if (numbersToCrossOut[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private static void crossOutMultiples() {
        for (int i = 2; i < Math.sqrt(size) + 1; i++) {
            for (int j = 2 * i; j < size; j += i) {
                numbersToCrossOut[j] = false;
            }
        }
    }

    private static void crossOutFirstTwoNumbers() {
        numbersToCrossOut[0] = numbersToCrossOut[1] = false;
    }

    private static boolean[] fillCrossOutArray() {
        boolean[] isPrime = new boolean[size];
        for (int i = 0; i < size; i++) {
            isPrime[i] = true;
        }
        return isPrime;
    }

    private static int[] fillInputArray(final int size) {
        int[] inputArray = new int[size];
        for (int i = 0; i < size; i++) {
            inputArray[i] = i;
        }
        return inputArray;
    }
}
