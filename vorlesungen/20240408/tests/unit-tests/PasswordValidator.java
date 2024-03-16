import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean checkPassword(String password) {
        // Regel: Länge mindestens 10 Zeichen
        if (password.length() < 10) {
            return false;
        }

        // Regel: Es muss mindestens ein Sonderzeichen enthalten sein
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }

        // Regel: Es müssen mindestens jeweils ein Groß- und Kleinbuchstabe enthalten sein
        if (!containsUpperCase(password) || !containsLowerCase(password)) {
            return false;
        }

        // Regel: Es muss mindestens eine Zahl enthalten sein
        if (!containsDigit(password)) {
            return false;
        }

        // Alle Regeln wurden erfüllt
        return true;
    }

    private static boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Beispielaufrufe
        System.out.println(checkPassword("StrongPass123!"));   // true
        System.out.println(checkPassword("weak"));             // false (Länge zu kurz)
        System.out.println(checkPassword("NoSpecialChar"));    // false (kein Sonderzeichen)
        System.out.println(checkPassword("onlylowercase"));    // false (kein Großbuchstabe)
        System.out.println(checkPassword("MissingNumber!"));   // false (keine Zahl)
    }
}
