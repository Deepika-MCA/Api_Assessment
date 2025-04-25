package za.co.loans;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NameValidationTest {

    // Utility method to check if the name is valid
    public static boolean isValidName(String name) {
        // Only letters and spaces allowed
        return name != null && name.matches("^[A-Za-z ]+$");
    }

    @Test
    public void shouldValidateCorrectNames() {
        assertThat(isValidName("Deepika")).isTrue();
        assertThat(isValidName("Deepika Karthikeyan")).isTrue();
    }

    @Test
    public void shouldRejectNamesWithDigitsOrSpecialChars() {
        assertThat(isValidName("D0eepika")).isFalse();        // Contains digit
        assertThat(isValidName("Deepika-karthikeyan")).isFalse();  // Contains hyphen
        assertThat(isValidName("Deepika!")).isFalse();      // Contains special character
        assertThat(isValidName("")).isFalse();            // Empty string
        assertThat(isValidName(null)).isFalse();          // Null
    }
}
