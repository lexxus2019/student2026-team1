package registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    // Email валиден, если подходит под маску
    public boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    // Базовая реализация: пароль не короче 6 символов и имеет хотя бы одну заглавную букву
    public boolean validatePassword(String password) {
        return password != null && password.length() >= 6 && password.matches(".*[A-ZА-ЯЁ].*");
    }

    // Проверка: имя пользователя не короче 8 символов
    public boolean validateUsername(String username) {
        return username != null && username.length() >= 8;
    }
  
    public boolean isConfirmPassword(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    // Базовая реализация: проверка совпадения паролей
    public void register(String email, String password, String confirmPassword, String username)
            throws RegistrationException {
        if (!validateUsername(username)) {
            throw new RegistrationException("Имя пользователя слишком короткое");
        }
        if (!validateEmail(email)) {
            throw new RegistrationException("Некорректный email");
        }
        if (!validatePassword(password)) {
            throw new RegistrationException("Пароль слишком короткий");
        }
        if (confirmPassword == null || confirmPassword.isBlank()) {
            throw new RegistrationException("Подтверждение пароля обязательно для заполнения");
        }
        if (!isConfirmPassword(password, confirmPassword)) {
            throw new RegistrationException("Пароли не совпадают");
        }
    }

    public boolean validateLatinUsername(String username) {
        return Pattern.compile("[A-Za-z]{3,}").matcher(username).matches();
    }
}