package login_register;

import login_register.Register;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: RegisterTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 19:03:48
 */
public class RegisterTest {

    Register register = new Register();

    @Test
    public void testName() {
        register.setName("root");
        assertEquals("root", register.name);
    }

    @Test
    public void testID() {
        register.setID("1");
        assertEquals("1", register.ID);
    }

    @Test
    public void testPassword() {
        register.setPassword("123456");
        assertEquals("123456", register.password);
    }

    @Test
    public void testConfirmpasswd() {
        register.setconfirmpasswd("123456");
        assertEquals("123456", register.confirmpassword);
    }

    @Test
    public void testJudgeRegister() throws SQLException, ClassNotFoundException {
        register.setID("");
        register.setName("");
        register.setPassword("");
        register.setconfirmpasswd("");
        assertEquals(false, register.JudgeRegister());
        register.setID("1");
        assertEquals(false, register.JudgeRegister());
        register.setName("root");
        assertEquals(false, register.JudgeRegister());
        register.setPassword("123456");
        assertEquals(false, register.JudgeRegister());
        register.setconfirmpasswd("123456");
        assertEquals(true, register.JudgeRegister());
    }
}
