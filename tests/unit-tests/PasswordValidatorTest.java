import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.checkPassword("StrongPass123!"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(PasswordValidator.checkPassword("Weak123!"));
    }

    @Test
    public void testNoSpecialChar() {
        assertFalse(PasswordValidator.checkPassword("NoSpecialChar123"));
    }

    @Test
    public void testNoUpperCase() {
        assertFalse(PasswordValidator.checkPassword("nouppercase123!"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(PasswordValidator.checkPassword("NoDigit!"));
    }

    @Test
    public void testValidPasswordWithSpace() {
        assertTrue(PasswordValidator.checkPassword("Password With Space123!"));
    }

    @Test
    public void testValidPasswordWithSpecialChars() {
        assertEquals(PasswordValidator.checkPassword("Pass!word#123"), true);
    }
}
