package base;

import net.bytebuddy.utility.RandomString;

public class DataGenerator {

    public static String generateEmail() {
        return RandomString.make(8) + "@gmail.com";
    }

    public static String generateString(int length) {
        return RandomString.make(length);
    }
}
