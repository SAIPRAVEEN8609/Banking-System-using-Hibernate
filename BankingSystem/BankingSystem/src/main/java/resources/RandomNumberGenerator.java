package resources;

import java.util.Random;

public class RandomNumberGenerator {

   
    public  long generateRandom10DigitNumber() {
        Random random = new Random();
        long lowerBound = 100_000_0000L;  
        long upperBound = 999_999_9999L;  
        return lowerBound + random.nextLong() % (upperBound - lowerBound + 1);
    }
}

