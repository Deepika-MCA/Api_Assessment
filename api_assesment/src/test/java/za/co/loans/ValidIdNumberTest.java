package za.co.loans;

import org.joda.time.Years;
import org.junit.Test;
import za.co.loans.service.utils.IdNumberUtils;

import java.time.Year;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidIdNumberTest {

    // Regular expression to validate a 13-digit numeric ID number
    private static final String ID_NUMBER_REGEX = "\\d{13}";

    @Test
    public void getAgeShouldReturnValidAgeFor13DigitId() {
        // Valid 13-digit ID number
        String givenIdNumber = "8801241064180";
        // Expected age based on the year (for this case: 2025 - 1989 = 36 years)
        int expectedAge = Year.now().getValue() - 1988;
        Years actualAge = IdNumberUtils.INSTANCE.getAge(givenIdNumber);

        // Validate that the ID number is exactly 13 digits long
        assertThat(isValidIdNumber(givenIdNumber)).isTrue();

        // Ensure the age is strictly more than 18 years
        assertThat(actualAge.getYears()).isGreaterThan(18);

        // Check that the age calculated matches the expected age
        assertThat(actualAge.getYears()).isEqualTo(expectedAge);
    }

    // Helper method to validate that the ID number is exactly 13 digits long
    private boolean isValidIdNumber(String idNumber) {
        return Pattern.matches(ID_NUMBER_REGEX, idNumber); // Validates if the ID is exactly 13 digits
    }

}
