package ss.hotel.password;

interface Checker {

    /**
     * Test if a given string is an acceptable password.
     * @param password
     * @return true || false
     */
    //@requires password != null;
    //@ensures \result == true || \result == false;
    boolean acceptable(String password);


    /**
     * Generates a random and acceptable password;
     * @return String \result
     */
    //@ensures acceptable(\result);
    String generatePassword();

}
