package registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private final UserRegistration reg = new UserRegistration();

    @Test
    void validEmailReturnsTrue() {
        assertTrue(reg.validateEmail("student@example.com"));
    }

    @Test
    void emailWithoutAtReturnsFalse() {
        assertFalse(reg.validateEmail("not-an-email"));
    }

    @Test
    void validPasswordReturnsTrue() {
        assertTrue(reg.validatePassword("Secret123"));
    }

    @Test
    void shortPasswordReturnsFalse() {
        assertFalse(reg.validatePassword("123"));
    }

    @Test
    void nonCapitalPasswordReturnsFalse() {
        assertFalse(reg.validatePassword("secret123"));
    }

    @Test
    void matchingPasswordsRegisterSuccessfully() {
        assertDoesNotThrow(() ->
            reg.register("student@example.com", "Secret123", "Secret123", "student"));
    }

    @Test
    void mismatchedPasswordsThrowException() {
        assertThrows(RegistrationException.class, () ->
            reg.register("student@example.com", "secret123", "different", "student"));
    }  

    @Test
    void validLatinUserNameTrue() {
        assertTrue(reg.validateLatinUsername("Lololoshka"));
    }

    @Test
    void validLatinUserNameFalse1() {
        assertFalse(reg.validateLatinUsername("Lo"));
    }

    @Test
    void validLatinUserNameFalse2() {
        assertFalse(reg.validateLatinUsername("Чебурек"));
    }
}