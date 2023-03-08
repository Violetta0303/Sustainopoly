package sustainopoly;

//import sun.java2d.cmm.Profile;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import static javax.swing.JOptionPane.*;

/**
 * MenuBar
 *
 * @author Zoctan
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;

    public MenuBar() {
        this.add(this.createFileMenu());
        this.add(this.createHelpMenu());
    }

    private JMenu createFileMenu() {
        JMenu menu = new Menu("File", this);
        // 设置快速访问符
        menu.setMnemonic(KeyEvent.VK_F);
        this.openMenuItem = new JMenuItem("Load", KeyEvent.VK_L);
        this.openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        menu.add(this.openMenuItem);
        menu.addSeparator();
        this.saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        this.saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menu.add(this.saveMenuItem);
        menu.addSeparator();
        this.exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        this.exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        menu.add(this.exitMenuItem);
        return menu;
    }

    private JMenu createHelpMenu() {
        JMenu menu = new Menu("Help", this);
        menu.setMnemonic(KeyEvent.VK_H);
        this.aboutMenuItem = new JMenuItem("About", KeyEvent.VK_A);
        menu.add(this.aboutMenuItem);
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.openMenuItem) {
            JFileChooser chooseFile = new JFileChooser();
            int returnVal = chooseFile.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = chooseFile.getSelectedFile();
                int confirm = this.showDialog("confirm", "Select the File: " + chooseFile.getName(f));
                if (confirm == 0) {
                    // Load Data
                    GamePanel.data = (GameData) IoUtil.readFromFile(chooseFile.getSelectedFile().getPath());
                    // Repaint the Game

                }
            }
        } else if (event.getSource() == this.saveMenuItem) {
            JFileChooser chooseFile = new JFileChooser();
            int returnVal = chooseFile.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = chooseFile.getSelectedFile();
                int confirm = this.showDialog("confirm", "Save to the file: " + chooseFile.getName(f));
                if (confirm == 0) {
                    // Save Data
                    IoUtil.save2File(GamePanel.data, chooseFile.getSelectedFile().getPath());
                }
            }
        } else if (event.getSource() == this.exitMenuItem) {
            int confirm = this.showDialog("confirm", "Sure you want to exit?");
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (event.getSource() == this.aboutMenuItem) {
            showDialog("message", "<!DOCTYPE><html lang='en'><head><meta charset='utf-8'><style>.blue{color:blue}</style></head><body><span>Resource: <span class='blue'>https://www.ewb-uk.org/</body></html>");
        }
    }

    private int showDialog(String type, String content) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Comic Sans MS", Font.BOLD, 12)));

        switch (type) {
            case "confirm":
                return JOptionPane.showConfirmDialog(this.getParent(), content, "Sustainopoly", JOptionPane.YES_NO_OPTION, QUESTION_MESSAGE);
            case "message":
                JLabel label = new JLabel();
                JEditorPane editorPane = new JEditorPane("text/html", content);
                editorPane.setEditable(false);
                editorPane.setBackground(label.getBackground());
                showMessageDialog(this.getParent(), editorPane, "Sustainopoly", PLAIN_MESSAGE);
                break;
            default:
                break;
        }
        return 0;
    }
}