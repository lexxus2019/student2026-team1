package registration;

public class UserRegistration {

    // Базовая реализация: email валиден, если содержит "@" и "."
     public boolean validateEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    // Базовая реализация: пароль не короче 6 символов
     public boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }

    // Базовая реализация: проверка совпадения паролей
     public void register(String email, String password, String confirmPassword, String username)
            throws RegistrationException {
        if (!validateEmail(email)) {
            throw new RegistrationException("Некорректный email");
        }
        if (!validatePassword(password)) {
            throw new RegistrationException("Пароль слишком короткий");
        }
        if (confirmPassword == null || confirmPassword.isBlank()) {
            throw new RegistrationException("Подтверждение пароля обязательно для заполнения");
        }
        if (!password.equals(confirmPassword)) {
            throw new RegistrationException("Пароли не совпадают");
        }
    }
}