/**
 * Generates the array that contains prime numbers up to the number specified by user.
 * Uses sieve algorithm by Eratosthenes.
 */
class PrimeArrayGenerator {
    private static int size = 0;
    private static int[] integers;
    private static boolean[] isCrossed;

    static int[] generatePrimes(final int maxValue) {
        if (maxValue < 2) return new int[0];
        initializeSieve(maxValue);
        sieve();
        return getAllPrimes(countPrimes());
    }

    private static void initializeSieve(final int maxValue) {
        size = maxValue + 1;

        integers = fillInputArray(size);
        isCrossed = fillCrossOutArray();
    }

    private static int[] getAllPrimes(final int primeCount) {
        int[] primes = new int[primeCount];
        for (int i = 2, j = 0; i < size; i++) {
            if (notCrossed(i)) {
                primes[j++] = integers[i];
            }
        }
        return primes;
    }

    private static boolean notCrossed(int currentInteger) {
        return isCrossed[currentInteger];
    }

    private static int countPrimes() {
        int primeCount = 0;
        for (int i = 2; i < size; i++) {
            if (isCrossed[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private static void sieve() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i < maxPrimeFactor; i++) {
            // If i is uncrossed, cross its multiples
            if (isCrossed[i]) {
                crossOutMultiplesOf(i);
            }
        }
    }

    /**
     * We cross out all the multiples of p, p is prime. Thus all crossed out multiples have p and
     * q factors. If p > sqrt of the size of the array, then q will never be greater than 1. thus
     * p is the largest prime factor in the array, and is also the iteration limit.
     * @return
     */
    private static int calcMaxPrimeFactor() {
        return (int) Math.sqrt(size) + 1;
    }

    private static void crossOutMultiplesOf(final int i) {
        for (int j = 2 * i; j < size; j += i) {
            isCrossed[j] = false;
        }
    }

    private static boolean[] fillCrossOutArray() {
        boolean[] isPrime = new boolean[size];
        for (int i = 2; i < size; i++) {
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
