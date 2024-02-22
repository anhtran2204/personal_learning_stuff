import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUser_BlackBox_Testing {
    /*
    valid:
        satisfies all the conditions & not in the system yet
    invalid:
        userids already in the system
        userid length invalid
        userid has special characters
        userid has control characters
        password length invalid
        password does not have special char
        password has control characters
        retyped password does not match
        Boundary conditions:
        login: length: 0, 1, 7, 8,9,19,20,21, 100
        password: 0,1,7,8,9,11,12,13, 100
        retyped password: same as above, matching & non-matching with the password entered

     */
    //writing only testcases that are not covered by the use case based testing

    @Test
    void register_BC_LoginLength_TC1() {
        // loginID length 0
        assertEquals(RegisterUser.register("", "xft123%PLM", "xft123%PLM"), "Login id does not satisfy length requirement");
    }
    @Test
    void register_BC_LoginLength_TC2() {
        // loginID length 1
        assertEquals(RegisterUser.register("a", "xft123%PLM", "xft123%PLM"), "Login id does not satisfy length requirement");
    }
    @Test
    void register_BC_LoginLength_TC3() {
        // loginID length 7
        assertEquals(RegisterUser.register("a@b.com", "xft123%PLM", "xft123%PLM"), "Login id does not satisfy length requirement");
    }
    @Test
    void register_BC_LoginLength_TC4a() {
        // loginID length 8
        assertEquals(RegisterUser.register("a@bc.com", "xft123%PLM", "xft123%PLM"), "Registration Successful");
    }
    void register_BC_LoginLength_TC4b() {
        // loginID length 8 but has space in it
        assertEquals(RegisterUser.register("a@ bc.com", "xft123%PLM", "xft123%PLM"), "Login id has space/control/special character in it");
    }
    void register_BC_LoginLength_TC4c() {
        // loginID length 8 but has \ in it
        assertEquals(RegisterUser.register("a@b\\c.com", "xft123%PLM", "xft123%PLM"), "Login id has space/control/special character in it");
    }
    @Test
    void register_BC_LoginLength_TC5() {
        // loginID length 9
        assertEquals(RegisterUser.register("a1@bc.com", "xft123%PLM", "xft123%PLM"), "Registration Successful");
    }
    @Test
    void register_BC_LoginLength_TC6() {
        // loginID length 19
        assertEquals(RegisterUser.register("a1234567890@bcd.com", "xft123%PLM", "xft123%PLM"), "Registration Successful");
    }
    @Test
    void register_BC_LoginLength_TC7() {
        // loginID length 20
        assertEquals(RegisterUser.register("a1234567890@bcde.com", "xft123%PLM", "xft123%PLM"), "Registration Successful");
    }
    @Test
    void register_BC_LoginLength_TC8() {
        // loginID length 21
        assertEquals(RegisterUser.register("a1234567890@bcdef.com", "xft123%PLM", "xft123%PLM"), "Login id does not satisfy length requirement");
    }
    @Test
    void register_BC_LoginLength_TC9() {
        // loginID length very large like 100
        assertEquals(RegisterUser.register("a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789@bcdef.com", "xft123%PLM", "xft123%PLM"), "Login id does not satisfy length requirement");
    }
    //password length tests : 0,1,7,8,9,11,12,13, 100
    @Test
    void register_BC_PwdLength_TC1() {
        // pwd length 0
        assertEquals(RegisterUser.register("a@bc.com", "", "xft123%PLM"), "Password does not satisfy length requirement");
    }
    @Test
    void register_BC_PwdLength_TC2() {
        // pwd length 1
        assertEquals(RegisterUser.register("a@bc.com", "x", "xft123%PLM"), "Password does not satisfy length requirement");
    }
    @Test
    void register_BC_PwdLength_TC3() {
        // pwd length 7
        assertEquals(RegisterUser.register("a@bc.com", "abcdef1", "xft123%PLM"), "Password does not satisfy length requirement");
    }
    @Test
    void register_BC_PwdLength_TC4a() {
        // pwd length 8 but has CONTROL character of alarm/bell in it
        assertEquals(RegisterUser.register("a@bc.com", "abcdefg\007", "xft123%PLM"), "Password does not satisfy rules for a valid password");
    }
    @Test
    void register_BC_PwdLength_TC4b() {
        // pwd length 8 but has space in it
        assertEquals(RegisterUser.register("a@bc.com", "abc def1", "xft123%PLM"), "Password does not satisfy rules for a valid password");
    }
    @Test
    void register_BC_PwdLength_TC4c() {
        // pwd length 8 but does not have a number
        assertEquals(RegisterUser.register("a@bc.com", "abcdefgh", "xft123%PLM"), "Password does not satisfy rules for a valid password");
    }
    @Test
    void register_BC_PwdLength_TC4d() {
        // pwd length 8 but does not have a letter
        assertEquals(RegisterUser.register("a@bc.com", "12345678", "xft123%PLM"), "Password does not satisfy rules for a valid password");
    }
    @Test
    void register_BC_PwdLength_TC4e() {
        // pwd length 8 but does not have a special character
        assertEquals(RegisterUser.register("a@bc.com", "abcdefg1", "xft123%PLM"), "Password does not satisfy rules for a valid password");
    }
    @Test
    void register_BC_PwdLength_TC5() {
        // pwd length 9
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef12%", "abcdef12%"), "Registration Successful");
    }
    @Test
    void register_BC_PwdLength_TC6() {
        // pwd length 11
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef1234%", "abcdef1234%"), "Registration Successful");
    }
    @Test
    void register_BC_PwdLength_TC7() {
        // pwd length 12
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef12345%", "abcdef12345%"), "Registration Successful");
    }
    @Test
    void register_BC_PwdLength_TC8() {
        // pwd length 13
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef123456%", "xft123%PLM"), "Password does not satisfy length requirement");
    }
    @Test
    void register_BC_PwdLength_TC9() {
        // pwd length very large like 100
        assertEquals(RegisterUser.register("a1@bc.com", "a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789a0123456789", "xft123%PLM"), "Password does not satisfy length requirement");
    }
    @Test
    void register_BC_RetypedPwd_TC1() {
        // pwd length 12
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef1234%", "abcdef1234%"), "Registration Successful");
    }
    @Test
    void register_BC_RetypedPwd_TC2() {
        // pwd length 13
        assertEquals(RegisterUser.register("a1@bc.com", "abcdef1234%", "abcdef1234$"), "Retyped password does not match the password");
    }


}