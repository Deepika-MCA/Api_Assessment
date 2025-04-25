package za.co.loans;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankValidationTest {

    // Allowed banks
    private static final List<String> ALLOWED_BANKS = Arrays.asList(
            "Scrum Bank",
            "Iconic Bank",
            "Minions Bank",
            "Molewa Bank"
    );

    // Validation result class
    public static class BankValidationResult {
        public boolean isValid;
        public String warning;

        public BankValidationResult(boolean isValid, String warning) {
            this.isValid = isValid;
            this.warning = warning;
        }
    }

    // Validate the bank and return result with optional warning
    public static BankValidationResult validateBank(String bankName) {
        if (bankName == null || !ALLOWED_BANKS.contains(bankName.trim())) {
            return new BankValidationResult(false, null);
        }

        if (bankName.equals("Molewa Bank")) {
            return new BankValidationResult(true, "refer to compliance");
        }

        return new BankValidationResult(true, null);
    }

    // ✅ Test for valid banks
    @Test
    public void shouldReturnValidForAllowedBanks() {
        assertThat(validateBank("Scrum Bank").isValid).isTrue();
        assertThat(validateBank("Iconic Bank").isValid).isTrue();
        assertThat(validateBank("Minions Bank").isValid).isTrue();
    }

    // ⚠️ Test for Molewa Bank with warning
    @Test
    public void shouldReturnWarningForMolewaBank() {
        BankValidationResult result = validateBank("Molewa Bank");
        assertThat(result.isValid).isTrue();
        assertThat(result.warning).isEqualTo("refer to compliance");
    }

    // ❌ Test for invalid banks
    @Test
    public void shouldRejectInvalidBankNames() {
        assertThat(validateBank("Random Bank").isValid).isFalse();
        assertThat(validateBank(null).isValid).isFalse();
        assertThat(validateBank("").isValid).isFalse();
    }
}
