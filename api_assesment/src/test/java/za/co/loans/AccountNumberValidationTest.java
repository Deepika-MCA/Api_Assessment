package za.co.loans;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberValidationTest {

    // Method to validate a 10-digit account number
    public static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches("^\\d{10}$");
    }

    // ✅ Test for valid account number
    @Test
    public void shouldAcceptValidAccountNumber() {
        assertThat(isValidAccountNumber("1234567890")).isTrue();
    }

    // ❌ Test for invalid account numbers
    @Test
    public void shouldRejectInvalidAccountNumbers() {
        assertThat(isValidAccountNumber("8173635abc")).isFalse();    // Letters
        assertThat(isValidAccountNumber("7162%!67890")).isFalse();    // Special char
    }
}
