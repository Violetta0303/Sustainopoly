package login_register;

import login_register.Login_Register;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: LoginRegisterTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 18:51:12
 */
public class LoginRegisterTest {

    @Test
    public void testInit() {
        Login_Register login_register = new Login_Register();
        assertEquals("Comic Sans MS", login_register.f.getName());
        assertEquals("ID:", login_register.nameStr.getText());
        assertEquals("Login", login_register.frame.getTitle());
        assertEquals("Password:", login_register.passwordStr.getText());
        assertEquals(25, login_register.userID.getBounds().height);
        assertEquals(25, login_register.password.getBounds().height);
        assertEquals("Login", login_register.buttonlogin.getText());
        assertEquals("Register", login_register.buttonregister.getText());
    }
}
