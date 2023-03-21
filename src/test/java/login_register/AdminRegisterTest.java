package login_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: AdminRegisterTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 10:25:36
 */
public class AdminRegisterTest {

    @Test
    public void testInit() {
        AdminRegister adminRegister = new AdminRegister();
        assertEquals("Comic Sans MS", adminRegister.f.getName());
        assertEquals(true, adminRegister.f.isBold());
        assertEquals(12, adminRegister.f.getSize());
        assertEquals("Name:", adminRegister.nameStr.getText());
        assertEquals("Register an admin account", adminRegister.frame.getTitle());
        assertEquals("ID:", adminRegister.IDStr.getText());
        assertEquals("Password:", adminRegister.passwordStr.getText());
        assertEquals("Confirm Password:", adminRegister.confrimStr.getText());
        assertEquals(25, adminRegister.userName.getBounds().height);
        assertEquals(25, adminRegister.userID.getBounds().height);
        assertEquals(25, adminRegister.password.getBounds().height);
        assertEquals(25, adminRegister.confrimPassword.getBounds().height);
        assertEquals(25, adminRegister.buttonregister.getBounds().height);
    }
}
