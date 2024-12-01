import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the HexUtils utility class.
 * This class contains unit tests for the methods and nested classes in the HexUtils class,
 * including Testing the generation of formatted hexadecimal strings, Testing the hashing of strings using SHA-256, Testing the functionality of the StringArrayManager class
 */
class HexUtilsTest {

    /**
     * Tests the {@link HexUtils#generateHexadecimalString()} method.
     * Ensures that the generated string is 36 characters long, matches the required hexadecimal string format
     */
    @Test
    void testGenerateHexadecimalString() {
        String hex = HexUtils.generateHexadecimalString();
        assertEquals(36, hex.length(), "Hex string should be 36 characters long.");
        assertTrue(hex.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}"),
                "Hex string should match the required format.");
    }

    /**
     * Tests the {@link HexUtils#hashString(String)} method.
     * Ensures that the returned hash is not null, the length of the hash is 64 characters (as expected for SHA-256)
     */
    @Test
    void testHashString() {
        String input = "test";
        String hash = HexUtils.hashString(input);
        assertNotNull(hash, "Hash should not be null.");
        assertEquals(64, hash.length(), "SHA-256 hash should be 64 characters long.");
    }

    /**
     * Tests the {@link HexUtils.StringArrayManager#insert(String, int)} method.
     * Ensures that the string is correctly inserted into the array at the index determined by the modulus operator, the inserted string can be retrieved from the correct index
     */
    @Test
    void testStringArrayManagerInsert() {
        HexUtils.StringArrayManager manager = new HexUtils.StringArrayManager(10);
        manager.insert("test", 12); // Insert "test" at index 12 % 10 = 2
        assertEquals("test", manager.getArray()[2], "The string should be inserted at index 2.");
    }
}

