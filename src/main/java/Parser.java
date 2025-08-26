import java.time.DateTimeException;
import java.time.LocalDate;

public class Parser {
    /**
     * Given an input string extract attribute string
     * @param input The input string
     * @param attribute Attribute to search for
     * @return String immediately after the attribute in the input string
     *         until delimiter of / is reached. If the attribute is not found
     *         an empty string is returned.
     */
    public static String extractAttribute(String input, String attribute) {
        int startIndex = input.indexOf(attribute);
        if (startIndex != -1) {
            // Move past the attribute
            startIndex += attribute.length();

            // Find the next '/' after the attribute
            int endIndex = input.indexOf("/", startIndex);
            if (endIndex == -1) {
                // No delimiter after attribute
                endIndex = input.length();
            }

            // Extract the substring
            return input.substring(startIndex, endIndex).trim();
        } else {
            return "";
        }
    }

    public static LocalDate convertDateAttr(String data, String attribute) throws ChirpException {
        try {
            return LocalDate.parse(data);
        } catch (DateTimeException e) {
            throw new ChirpException.InvalidAttribute(data, attribute, "Not in yyyy-MM-dd format.");
        }
    }
}
