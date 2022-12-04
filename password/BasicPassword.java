package ss.hotel.password;

public class BasicPassword {

    /**
     * The standard initial password.
     */
    public static final String INITIAL = "InitialPassword";

    private String password;

    /**
     * Constructs a Password with the initial word provided in INITIAL.
     */
    public BasicPassword () {
        password = INITIAL;
    }

    /**
     * Test if a given string is an acceptable password.
     * @param password
     * @return true || false
     */
    public boolean acceptable(String password) {
        return password.length() > 6 && !password.contains(" ");
    }

    /**
     * Tests if a given word is equal to the current password.
     * @param pass
     * @return true || false
     */
    public boolean testWord(String pass) {
        if (pass.equals(password)) {
            return true;
        }
        return false;
    }
    /**
     * Changes this password.
     * @param oldPassword && newPassword
     * @return true || false
     */
    public boolean setWord(String oldPassword, String newPassword) {
        if (testWord(oldPassword) && acceptable(newPassword)) {
            password = newPassword;
            return true;
        }
        return false;
    }
}
