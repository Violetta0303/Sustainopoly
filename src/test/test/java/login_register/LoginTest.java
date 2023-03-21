package login_register;

import login_register.Admin;
import login_register.Login;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: LoginTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 11:24:55
 */
public class LoginTest {

    @Test
    public void testSetAdmin() {
        Admin admin = new Admin();
        admin.setID("1");
        Login login = new Login();
        login.setAdmin(admin);
        assertEquals("1", login.admin.getID());
    }

    @Test
    public void testLogin() throws SQLException, ClassNotFoundException {
        Admin admin = new Admin();
        admin.setID("1");
        admin.setName("root");
        admin.setPassword("123456");
        Login login = new Login();
        assertEquals(false, login.login(admin));
    }

    @Test
    public void testJudgeAdmin() {
        Admin admin = new Admin();
        admin.setID("1");
        admin.setName("root");
        admin.setPassword("123456");
        Login login = new Login();
        assertEquals(0, login.JudgeAdmin());
    }
}
