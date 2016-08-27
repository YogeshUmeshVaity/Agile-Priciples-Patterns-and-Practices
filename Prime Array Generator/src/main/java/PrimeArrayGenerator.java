class PrimeArrayGenerator {

    static int[] generatePrimes(final int maxValue) {

        if (maxValue >= 2) {
            int[] inputArray = new int[maxValue + 1];
            // Fill input array with numbers
            for (int i = 0; i < maxValue + 1; i++) {
                inputArray[i] = i;
            }

            int size = maxValue + 1;
            // Boolean array to cross out the numbers
            boolean[] isPrime = new boolean[size];
            for (int i = 0; i < size; i++) {
                isPrime[i] = true;
            }

            // Cross out the first two obvious non-primes
            isPrime[0] = isPrime[1] = false;

            // Cross multiples of each number
            for (int i = 2; i < Math.sqrt(maxValue) + 1; i++) {
                for (int j = 2 * i; j < maxValue + 1; j += i) {
                    isPrime[j] = false;
                }
            }

            // Count prime numbers
            int primeCount = 0;
            for (int i = 0; i < maxValue + 1; i++) {
                if (isPrime[i]) {
                    primeCount++;
                }
            }
            // Get all primes together
            int[] primes = new int[primeCount];
            for (int i = 0, j = 0; i < size; i++) {
                if (isPrime[i]) {
                    primes[j++] = inputArray[i];
                }
            }

            return primes;

        } else {
            return new int[0];
        }
    }
}
