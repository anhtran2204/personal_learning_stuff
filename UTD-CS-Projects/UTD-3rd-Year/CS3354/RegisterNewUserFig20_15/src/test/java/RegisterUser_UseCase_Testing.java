import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUser_UseCase_Testing {
    //
    @Test
    void register_TC1() {
        //all values valid
        assertEquals( RegisterUser.register("newuser@hmail.com", "xft123%PLM",  "xft123%PLM"), "Registration Successful"  );
    }

    @Test
    void register_TC2() {
        //retyped does not match
        assertEquals( RegisterUser.register("newuser@hmail.com", "xft123%PLM",  "yyyyyyyyy"), "Retyped password does not match the password"  );

    }

    @Test
    void register_TC3() {
        //pwd length is  8 but does not satisfy rules
        assertEquals( RegisterUser.register("newuser@hmail.com", "zzzzzzzz",  "xft123%PLM"), "Password does not satisfy rules for a valid password"  );
    }
    @Test
    void register_TC5() {
        //pwd length is 1
        assertEquals( RegisterUser.register("newuser@hmail.com", "x",  "xft123%PLM"), "Password does not satisfy length requirement"  );
        //public static String register(String argLoginID, String argPwd1, String argPwd2){
    }

    @Test
    void register_TC7() {
        //sending an existing user
        assertEquals( RegisterUser.register("olduser@hmail.com", "xft123%PLM",  "xft123%PLM"), "Login id exists !!!"  );
    }
    @Test
    void register_TC13() {
        //login id has space in it
        assertEquals( RegisterUser.register("new user@hmail.com", "xft123%PLM",  "xft123%PLM"), "Login id has space/control/special character in it"  );
    }


}