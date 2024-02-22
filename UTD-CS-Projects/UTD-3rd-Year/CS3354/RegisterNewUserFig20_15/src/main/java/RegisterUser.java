public class RegisterUser {

    public static final int MIN_LENGTH_LOGIN_ID = 8;
    public static final int MAX_LENGTH_LOGIN_ID = 20;

    public static final int MIN_LENGTH_PWD = 8;
    public static final int MAX_LENGTH_PWD = 12;

    public static String[] existingIDs = {"abc@abcdef.com", "def@abcdef.org", "ghi@abcdef.gov", "olduser@hmail.com"};
    public static char[] badChars = {' ', ',', '/', '\\'};

    public static boolean checkLoginLength(String argLoginID){
        if(MIN_LENGTH_LOGIN_ID <= argLoginID.length()  &&  argLoginID.length() <= MAX_LENGTH_LOGIN_ID){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkLoginExisting(String argLoginID){
        for(String id : existingIDs) {
            if(argLoginID.equals(id)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkLoginForBadCharacters(String argLoginID){
        //returns true if bad characters / control characters are PRESENT the incoming String
        //otherwise returns false
        for(char c : badChars){
            if(argLoginID.indexOf(c) >= 0){
                return true;
            }
        }
        //made sure that bad characters in the given array are absent in the incoming String
        //now to make sure no control characters are in the incoming String
        for(char c : argLoginID.toCharArray()){
            if( Character.isISOControl(c)){
                return true;
            }
        }
        //made sure that control characters in the given array are absent in loginID
        //we can now return false to mean that none of the unwanted characters are present in incoming string
        return false;
    }

//    public static boolean loginPass(String loginID){
//
//        return checkLength(loginID) && !checkExisting(loginID) && !hasExceptionalCharacters(loginID);
//    }

    public static boolean checkPwdLength(String argPwd){
        if(MIN_LENGTH_PWD <= argPwd.length()  &&  argPwd.length() <= MAX_LENGTH_PWD){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkPwdForValidCharacters(String argPwd) {
        //returns false in the following cases :
        //      if incoming String has one or more space or control characters
        //      if incoming String does not have at least of the following : one letter or number or  special character
        //return true otherwise
        boolean foundLetter = false;
        boolean foundNumber = false;
        boolean foundSpecialChar = false;
        for (char c : argPwd.toCharArray()) {
            if (Character.isISOControl(c) || Character.isSpaceChar(c)) {
                return false;
            } else if (Character.isLetter(c)) {
                foundLetter = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else {
                foundSpecialChar = true;
            }
        }
        //checked all characters in the incoming string
        return( foundLetter && foundNumber && foundSpecialChar );
    }

//    public static boolean validPwd(String pwd){
//        return checkLength_Pwd(pwd) && hasValidCharacters(pwd);
//    }

    public static boolean checkPwd1Pwd2(String argPwd1, String argPwd2){
        if( argPwd1.equals(argPwd2) ){
            return true;
        }else{
            return false;
        }
    }

    public static String register(String argLoginID, String argPwd1, String argPwd2){
        if( !checkLoginLength( argLoginID ) ) {
            return "Login id does not satisfy length requirement";
        }
        if( checkLoginExisting( argLoginID ) ) {
            return "Login id exists !!!";
        }
        if( checkLoginForBadCharacters( argLoginID ) ){
            return "Login id has space/control/special character in it";
        }
        System.out.println(argPwd1 + " length is :" + argPwd1.length());
        if( !checkPwdLength( argPwd1 ) ){

            return "Password does not satisfy length requirement";
        }
        if( !checkPwdForValidCharacters( argPwd1 ) ){
            return "Password does not satisfy rules for a valid password";
        }
        if( !checkPwd1Pwd2( argPwd1, argPwd2 ) ){
            return "Retyped password does not match the password";
        }
        //as all criteria has been satisfied, now we can safely say that
        // the registration of the incoming combo is successful.
        return "Registration Successful";
    }
}
