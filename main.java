/**
 * Main class to demonstrate HexUtils functionality.
 */
public class Main {

    /**
     * Main method to demonstrate the functionalities of the HexUtils class.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Generate a random hexadecimal string
        String hex = HexUtils.generateHexadecimalString();
        System.out.println("Generated Hex: " + hex);

        // Hash the generated hexadecimal string
        String hash = HexUtils.hashString(hex);
        System.out.println("Hex Hash: " + hash);

        // Create a StringArrayManager and insert the generated string
        HexUtils.StringArrayManager manager = new HexUtils.StringArrayManager(5);
        manager.insert(hex, 7);
        System.out.println("Inserted String: " + manager.getArray()[2]);
    }
}
