package ss.hotel.password;

import java.util.Objects;

public class Password {


    /**
     * The standard initial password.
     */
    public static final String INITIAL = "default";

    /**
     * password
     */
    private String password;

    /**
     * checker
     */
    private final Checker checker;

    /**
     * initial password
     */


    /**
     * Constructs a Password with the initial word provided in INITIAL.
     */
    public Password(Checker checker) {
        this.checker = checker;
        this.password = INITIAL;
    }

    /**
     * Create a new checker with BasicChecker.
     */
    public Password() {
        checker = new BasicChecker();
        new Password(checker);
    }


    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     *
     * @param suggestion Word that should be tested
     * @return true If suggestion is acceptable
     */
    public boolean acceptable(String suggestion) {
        return suggestion.matches("\\S+") && suggestion.length() >= 6;
    }

    /**
     *  Tests if a given word is equal to the current password.
     * @param test Word that should be tested
     * @return true If test is equal to the current password
     */
    public boolean testWord(String test) {
        return Objects.equals(test, password);

    }


    /**
     * Changes this password.
     * @param wrongOldPassowrd The current password
     * @param newPassword The new password
     * @return true If oldPass is equal to the current password and newpass is an acceptable password
     */
    public boolean setWord(String wrongOldPassowrd, String newPassword) {

        if (!testWord(wrongOldPassowrd)) {
            return false;
        } else {
            if (acceptable(newPassword)) {
                password = newPassword;
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * Returns initial password
     * @return initPass
     */
    public String getInitPass() {
        return INITIAL;
    }


    /**
     * get what type of checker
     * @return the checker
     */
    public Checker getChecker() {
        return checker;
    }

}
