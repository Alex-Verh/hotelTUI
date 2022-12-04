package ss.hotel.password;

public class BasicChecker implements Checker {

    /**
     * Test if a given string is an acceptable password.
     * @param password
     * @return true || false
     */
    @Override
    public boolean acceptable(String password) {
        return password.length() > 6 && !password.contains(" ");
    }

    /**
     * Generates a random and acceptable password;
     * @return String \result
     */
    @Override
    public String generatePassword () {
        return "RandomGeneratedPassword";
    }
}
