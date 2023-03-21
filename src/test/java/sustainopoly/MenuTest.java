package sustainopoly;

import org.junit.jupiter.api.Test;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: MenuTest
 * @Description:
 * @Author:
 * @Date: 2023-03-19 10:55:44
 */
public class MenuTest {

    @Test
    public void testAdd() {
        JMenu menu = new Menu("File", new MenuBar());
        JMenuItem item = new JMenuItem();
        menu.add(item);
        assertNotEquals(null, item.getActionListeners());

    }
}
