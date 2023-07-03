package login_register;

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
        LoginRegister loginregister = new LoginRegister();
        assertEquals("Comic Sans MS", loginregister.f.getName());
        assertEquals("ID:", loginregister.nameStr.getText());
        assertEquals("Login", loginregister.frame.getTitle());
        assertEquals("Password:", loginregister.passwordStr.getText());
        assertEquals(25, loginregister.userID.getBounds().height);
        assertEquals(25, loginregister.password.getBounds().height);
        assertEquals("Login", loginregister.buttonlogin.getText());
        assertEquals("Register", loginregister.buttonregister.getText());
    }
}
