package sustainopoly;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;

import static javax.swing.JOptionPane.*;
import static sustainopoly.StartGame.gamePanel;

/**
 * MenuBar
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    private JCheckBoxMenuItem musicMenuItem;
    private JCheckBoxMenuItem voiceAnnounceMenuItem;
    private JMenuItem volumeMenuItem;
    private JMenuItem rateMenuItem;
    private JCheckBoxMenuItem pauseGameMenuItem;
    private PlayMusicUtil playMusicUtil;
    public static VoiceAnnouncementsUtil voiceAnnouncementsUtil;


    public MenuBar() {
        this.add(this.createFileMenu());
        this.add(this.createSettingMenu());
        this.add(this.createHelpMenu());
        // Background Music
        this.musicMenuItem.setState(gamePanel.data.isMusic);
        this.onMusicChange();
    }

    private JMenu createFileMenu() {
        JMenu menu = new Menu("File", this);
        // Set Shortcuts
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

    public JMenu createSettingMenu() {
        JMenu menu = new Menu("Setting", this);
        menu.setMnemonic(KeyEvent.VK_S);
        this.musicMenuItem = new JCheckBoxMenuItem("Background Music ON/OFF");
        this.musicMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
        menu.add(this.musicMenuItem);
        this.voiceAnnounceMenuItem = new JCheckBoxMenuItem("Voice Announcement ON/OFF");
        this.voiceAnnounceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        menu.add(this.voiceAnnounceMenuItem);
        this.volumeMenuItem = new JMenuItem("Voice Announcement Volume");
        this.volumeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        menu.add(this.volumeMenuItem);
        this.rateMenuItem = new JMenuItem("Voice Announcement Rate");
        this.rateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menu.add(rateMenuItem);
        this.pauseGameMenuItem = new JCheckBoxMenuItem("Pause/Continue the Game");
        this.pauseGameMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
//        menu.add(pauseGameMenuItem);
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
                    // Setting
                    this.musicMenuItem.setState(GamePanel.data.isMusic);
                    this.onMusicChange();
                    this.musicMenuItem.setState(GamePanel.data.isVoiceAnnounce);
                    this.onVoiceAnnouceChange();
                    // Repaint the Game
                    gamePanel.repaint();
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
                    IoUtil.save2File(gamePanel.data, chooseFile.getSelectedFile().getPath());
                }
            }
        } else if (event.getSource() == this.exitMenuItem) {
            int confirm = this.showDialog("confirm", "Sure you want to exit?");
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (event.getSource() == this.musicMenuItem) {
            this.onMusicChange();
        } else if (event.getSource() == this.voiceAnnounceMenuItem) {
            this.onVoiceAnnouceChange();
        } else if (event.getSource() == this.volumeMenuItem) {
            String v = JOptionPane.showInputDialog(null, "Please input the volume you want (0 - 100)");
            voiceAnnouncementsUtil.volume = Integer.parseInt(v);
        } else if (event.getSource() == this.rateMenuItem) {
            String r = JOptionPane.showInputDialog(null, "Please input the rate you want (-10 to +10)");
            voiceAnnouncementsUtil.rate = Integer.parseInt(r);
        } else if (event.getSource() == this.pauseGameMenuItem) {

            if (gamePanel.data.isPause == false) {
                gamePanel.data.isPause = true;
                gamePanel.t = gamePanel.period;

            } else {
                gamePanel.data.isPause = false;

                gamePanel.period = gamePanel.t;
            }

        } else if (event.getSource() == this.aboutMenuItem) {
            showDialog("message", "<!DOCTYPE><html lang='en'><head><meta charset='utf-8'><style>.blue{color:blue}</style></head><body><span>Resource: <span class='blue'>https://www.ewb-uk.org/</body></html>");
        }
    }

    private int showDialog(String type, String content) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Comic Sans MS", Font.BOLD, 14)));

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

    private void onMusicChange() {
        // Background Music
        if (this.musicMenuItem.getState()) {
            if (this.playMusicUtil == null) {
                this.playMusicUtil = new PlayMusicUtil(gamePanel.data.backgroundMusicUrl);
            }
            this.playMusicUtil.start();
            gamePanel.data.isMusic = true;
        } else {
            if (this.playMusicUtil != null) {
                this.playMusicUtil.close();
                this.playMusicUtil = null;
            }
            gamePanel.data.isMusic = false;
        }
    }

    private void onVoiceAnnouceChange() {
        //Voice Announcement
        if (this.voiceAnnounceMenuItem.getState()) {
            if (voiceAnnouncementsUtil == null) {
                voiceAnnouncementsUtil = new VoiceAnnouncementsUtil();
            }
            voiceAnnouncementsUtil.start();
            gamePanel.data.isVoiceAnnounce = true;
        } else {
            if (voiceAnnouncementsUtil != null) {
                voiceAnnouncementsUtil.close();
                voiceAnnouncementsUtil = null;
            }
            gamePanel.data.isVoiceAnnounce = false;
        }
    }
}
