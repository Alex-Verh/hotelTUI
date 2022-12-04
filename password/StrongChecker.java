package ss.hotel.password;

public class StrongChecker extends BasicChecker implements Checker {
    /**
     * Test if a given string is a strong acceptable password.
     * @param password
     * @return true || false
     */
    @Override
    public boolean acceptable(String password) {
        return super.acceptable(password) && !Character.isLetter(password.charAt(0)) && Character.isDigit(password.charAt(password.length()-1));
    }
}
