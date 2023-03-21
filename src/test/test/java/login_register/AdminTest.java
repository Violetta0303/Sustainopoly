package login_register;

import login_register.Admin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: AdminTest
 * @Description:
 * @Author:
 * @Date: 2023-03-14 09:35:50
 */
public class AdminTest {
    private Admin admin = new Admin();

    @Test
    public void tesId() {
        admin.setID("1");
        assertEquals("1", admin.getID());
    }

    @Test
    public void testName() {
        admin.setName("root");
        assertEquals("root", admin.getName());
    }

    @Test
    public void testPassword() {
        admin.setPassword("123456");
        assertEquals("123456", admin.getPassword());
    }
}
