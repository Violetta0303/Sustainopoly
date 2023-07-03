package sustainopoly;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Menu
 */
public class Menu extends JMenu {
    private ActionListener listener;

    public Menu(String name, ActionListener listener) {
        super(name);
        this.listener = listener;
    }

    @Override
    public JMenuItem add(JMenuItem item) {
        item.addActionListener(this.listener);
        return super.add(item);
    }
}
