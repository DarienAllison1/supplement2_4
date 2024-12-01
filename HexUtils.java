import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Utility class for generating and managing hexadecimal strings.
 */
public class HexUtils {

    /**
     * Generates a 32-character random hexadecimal string formatted
     * @return A formatted hexadecimal string.
     */
    public static String generateHexadecimalString() {
        Random random = new Random();
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            hexString.append(Integer.toHexString(random.nextInt(16)));
        }
        return hexString.substring(0, 8) + "-" + 
               hexString.substring(8, 12) + "-" + 
               hexString.substring(12, 16) + "-" + 
               hexString.substring(16, 20) + "-" + 
               hexString.substring(20);
    }

    /**
     * Hashes a given string using SHA-256.
     *
     * @param input The input string to be hashed.
     * @return The hashed string in hexadecimal format.
     */
    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hash) {
                hexHash.append(String.format("%02x", b));
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    /**
     * A class to manage an array of strings with insertion functionality.
     */
    public static class StringArrayManager {
        private final String[] array;

        /**
         * Constructs a new StringArrayManager with a specified size.
         *
         * @param size The size of the array.
         */
        public StringArrayManager(int size) {
            this.array = new String[size];
        }

        /**
         * Inserts a string into the array at the specified index, handling overflow.
         *
         * @param str   The string to insert.
         * @param index The index where the string should be inserted.
         */
        public void insert(String str, int index) {
            int modIndex = index % array.length;
            array[modIndex] = str;
        }

        /**
         * Retrieves the array of strings.
         *
         * @return The array of strings.
         */
        public String[] getArray() {
            return array;
        }
    }
}
