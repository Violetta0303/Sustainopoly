package playersInformation;

import com.formdev.flatlaf.FlatLightLaf;
import sustainopoly.StartGame;
import videoplayer.VideoPlayerMain;
import videoplayer.VideoPlayerWindow;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import static videoplayer.VideoPlayerMain.videoPlayerFrame;

public class FrameConfig extends JFrame {
    JFrame jf = new JFrame("Player Information");

    Font f = new Font("Comic Sans MS", Font.BOLD, 10);
    private JButton jbnStart = new JButton("Start Game");
    private JButton jbnCancel = new JButton("Reset settings");

    private JButton jbnPlayer01 = new JButton("Confirm P1's Avatar");
    private JLabel jbnPlayerNameLabel01 = new JLabel("Name:");
    private JTextField jbnPlayerNameField01 = new JTextField(12);
    private JButton jbnPlayerName01 = new JButton("Confirm P1's Name");

    private JButton jbnPlayer02 = new JButton("Confirm P2's Avatar");
    private JLabel jbnPlayerNameLabel02 = new JLabel("Name:");
    private JTextField jbnPlayerNameField02 = new JTextField(12);
    private JButton jbnPlayerName02 = new JButton("Confirm P2's Name");


    private JButton jbnPlayer03 = new JButton("Confirm P3's Avatar");
    private JLabel jbnPlayerNameLabel03 = new JLabel("Name:");
    private JTextField jbnPlayerNameField03 = new JTextField(12);
    private JButton jbnPlayerName03 = new JButton("Confirm P3's Name");

    private JButton jbnPlayer04 = new JButton("Confirm P4's Avatar");
    private JLabel jbnPlayerNameLabel04 = new JLabel("Name:");
    private JTextField jbnPlayerNameField04 = new JTextField(12);
    private JButton jbnPlayerName04 = new JButton("Confirm P4's Name");

    private JButton jbnPlayer05 = new JButton("Confirm P5's Avatar");
    private JLabel jbnPlayerNameLabel05 = new JLabel("Name:");
    private JTextField jbnPlayerNameField05 = new JTextField(12);
    private JButton jbnPlayerName05 = new JButton("Confirm P5's Name");

    private JButton jbnPlayer06 = new JButton("Confirm P6's Avatar");
    private JLabel jbnPlayerNameLabel06 = new JLabel("Name:");
    private JTextField jbnPlayerNameField06 = new JTextField(12);
    private JButton jbnPlayerName06 = new JButton("Confirm P6's Name");

    private JButton jbnPlayer07 = new JButton("Confirm P7's Avatar");
    private JLabel jbnPlayerNameLabel07 = new JLabel("Name:");
    private JTextField jbnPlayerNameField07 = new JTextField(12);
    private JButton jbnPlayerName07 = new JButton("Confirm P7's Name");

    private JButton jbnPlayer08 = new JButton("Confirm P8's Avatar");
    private JLabel jbnPlayerNameLabel08 = new JLabel("Name:");
    private JTextField jbnPlayerNameField08 = new JTextField(12);
    private JButton jbnPlayerName08 = new JButton("Confirm P8's Name");


    /**
     * Avatar
     */
    public static ImageIcon[] img = Photo.PLAYER_CHOOSE;
    /**
     * P1
     **/
    private JLabel jlPlayer01Choose = null;
    private final JLabel jlPlayer01Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton01;
    private JButton rightButton01;

    /**
     * P2
     **/
    private JLabel jlPlayer02Choose = null;
    private final JLabel jlPlayer02Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton02;
    private JButton rightButton02;

    /**
     * P3
     **/
    private JLabel jlPlayer03Choose = null;
    private final JLabel jlPlayer03Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton03;
    private JButton rightButton03;

    /**
     * P4
     **/
    private JLabel jlPlayer04Choose = null;
    private final JLabel jlPlayer04Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton04;
    private JButton rightButton04;

    /**
     * P5
     **/
    private JLabel jlPlayer05Choose = null;
    private final JLabel jlPlayer05Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton05;
    private JButton rightButton05;

    /**
     * P6
     **/
    private JLabel jlPlayer06Choose = null;
    private final JLabel jlPlayer06Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton06;
    private JButton rightButton06;

    /**
     * P7
     **/
    private JLabel jlPlayer07Choose = null;
    private final JLabel jlPlayer07Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton07;
    private JButton rightButton07;


    /**
     * P8
     **/
    private JLabel jlPlayer08Choose = null;
    private final JLabel jlPlayer08Selected = new JLabel(
            Photo.PLAYER_SELECTED);
    private JButton leftButton08;
    private JButton rightButton08;

    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p
     */
    private int[] chooses = {0, 0, 0, 0, 0, 0, 0, 0};
    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p
     */
    public static int[] selected = {-1, -2, -3, -4, -5, -6, -7, -8};
    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p
     */
    public static String[] selectedName = {"", "", "", "", "", "", "", ""};

    /**
     *
     */
    public JButton createButton(int x, int y, ImageIcon[] img, char keyLinstenr) {
        JButton add = new JButton("", img[0]);
        add.setPressedIcon(img[3]);
        add.setRolloverIcon(img[2]);
        add.setMnemonic(keyLinstenr);
        add.setBounds(x, y, img[0].getIconWidth(), img[0].getIconHeight());
        return add;
    }


    /**
     * P1
     */
    private void addPlayer01Config(int x, int y, JPanel jp) {
        //
        jlPlayer01Choose = new JLabel(img[chooses[0]]);
        jlPlayer01Choose.setBounds(x + 8, y, 128, 128);
        //
        jlPlayer01Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer01Selected.setVisible(false);
        //
        leftButton01 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        //
        leftButton01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[0] <= 0) {
                    chooses[0] = img.length;
                }
                jlPlayer01Choose.setIcon(img[--chooses[0]]);
            }
        });

        jp.add(leftButton01);
        //
        rightButton01 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        //
        rightButton01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //
                if (chooses[0] >= img.length - 1) {
                    chooses[0] = -1;
                }
                jlPlayer01Choose.setIcon(img[++chooses[0]]);
            }
        });
        jp.add(rightButton01);
        //
        jbnPlayer01.setBounds(x, 128 + y, 145, 30);
        //
        jbnPlayer01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[0] != selected[i]){
                        g++;
                    }
                }

                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }

                if (g == 8) {
                    //
                    leftButton01.setEnabled(false);
                    rightButton01.setEnabled(false);
                    jbnPlayer01.setEnabled(false);
                    //
                    jlPlayer01Selected.setVisible(true);
                    selected[0] = chooses[0];
                }
            }
        });
        jp.add(jbnPlayer01);
        jp.add(jlPlayer01Selected);
        jp.add(jlPlayer01Choose);
        //
        jbnPlayerNameLabel01.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField01.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName01.setBounds(x, y + 128 + 36 + 36, 145, 30);
        //
        jbnPlayerName01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkName = true;

                if (!jbnPlayerNameField01.getText().equals("")) {
                    selectedName[0] = jbnPlayerNameField01.getText();
                   for(int i = 0; i < 8;i++){
                       if(i==0){
                           continue;
                       }
                       if(selectedName[0].equals(selectedName[i])){
                           checkName = false;
                       }
                   }

                    if(checkName == true) {
                        jbnPlayerNameField01.setEditable(false);
                        jbnPlayerName01.setEnabled(false);
                    } else if (checkName == false){
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });

        jp.add(jbnPlayerNameLabel01);
        jp.add(jbnPlayerNameField01);
        jp.add(jbnPlayerName01);

        jbnPlayer01.setFont(f);
        jbnPlayerNameLabel01.setFont(f);
        jbnPlayerNameField01.setFont(f);
        jbnPlayerName01.setFont(f);
    }

    /**
     * P2
     */
    private void addPlayer02Config(int x, int y, JPanel jp) {
        //
        jlPlayer02Choose = new JLabel(img[chooses[1]]);
        jlPlayer02Choose.setBounds(x + 8, y, 128, 128);
        //
        jlPlayer02Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer02Selected.setVisible(false);
        //
        leftButton02 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        //
        leftButton02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[1] <= 0) {
                    chooses[1] = img.length;
                }
                jlPlayer02Choose.setIcon(img[--chooses[1]]);
            }
        });

        jp.add(leftButton02);
        //
        rightButton02 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        //
        rightButton02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ???????
                if (chooses[1] >= img.length - 1) {
                    chooses[1] = -1;
                }
                jlPlayer02Choose.setIcon(img[++chooses[1]]);
            }
        });

        jp.add(rightButton02);
        //
        jbnPlayer02.setBounds(x, 128 + y, 145, 30);
        //
        jbnPlayer02.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[1] != selected[i]){
                        g++;
                    }
                }

                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }

                if (g == 8) {

                    leftButton02.setEnabled(false);
                    rightButton02.setEnabled(false);
                    jbnPlayer02.setEnabled(false);

                    jlPlayer02Selected.setVisible(true);
                    selected[1] = chooses[1];
                }
            }
        });
        jp.add(jbnPlayer02);
        jp.add(jlPlayer02Selected);
        jp.add(jlPlayer02Choose);
        //
        jbnPlayerNameLabel02.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField02.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName02.setBounds(x, y + 128 + 36 + 36, 145, 30);
        //
        jbnPlayerName02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField02.getText().equals("")) {
                    selectedName[1] = jbnPlayerNameField02.getText();
                    boolean checkName = true;

                    for(int i = 0; i < 8;i++){
                        if(i==1){
                            continue;
                        }
                        if(selectedName[1].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField02.setEditable(false);
                        jbnPlayerName02.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
        jp.add(jbnPlayerNameLabel02);
        jp.add(jbnPlayerNameField02);
        jp.add(jbnPlayerName02);

        jbnPlayer02.setFont(f);
        jbnPlayerNameLabel02.setFont(f);
        jbnPlayerNameField02.setFont(f);
        jbnPlayerName02.setFont(f);
    }

    /**
     * P3
     */
    private void addPlayer03Config(int x, int y, JPanel jp) {

        jlPlayer03Choose = new JLabel(img[chooses[2]]);
        jlPlayer03Choose.setBounds(x + 8, y, 128, 128);

        jlPlayer03Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer03Selected.setVisible(false);

        leftButton03 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');

        leftButton03.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[2] <= 0) {
                    chooses[2] = img.length;
                }
                jlPlayer03Choose.setIcon(img[--chooses[2]]);
            }
        });

        jp.add(leftButton03);

        rightButton03 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');

        rightButton03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //
                if (chooses[2] >= img.length - 1) {
                    chooses[2] = -1;
                }
                jlPlayer03Choose.setIcon(img[++chooses[2]]);
            }
        });
        jp.add(rightButton03);

        jbnPlayer03.setBounds(x, 128 + y, 145, 30);

        jbnPlayer03.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[2] != selected[i]){
                        g++;
                    }
                }
                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }

                if (g == 8) {

                    leftButton03.setEnabled(false);
                    rightButton03.setEnabled(false);
                    jbnPlayer03.setEnabled(false);

                    jlPlayer03Selected.setVisible(true);
                    selected[2] = chooses[2];
                }
            }
        });
        jp.add(jbnPlayer03);
        jp.add(jlPlayer03Selected);
        jp.add(jlPlayer03Choose);

        jbnPlayerNameLabel03.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField03.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName03.setBounds(x, y + 128 + 36 + 36, 145, 30);

        jbnPlayerName03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField03.getText().equals("")) {
                    selectedName[2] = jbnPlayerNameField03.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==2){
                            continue;
                        }
                        if(selectedName[2].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField03.setEditable(false);
                        jbnPlayerName03.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
        jp.add(jbnPlayerNameLabel03);
        jp.add(jbnPlayerNameField03);
        jp.add(jbnPlayerName03);

        jbnPlayer03.setFont(f);
        jbnPlayerNameLabel03.setFont(f);
        jbnPlayerNameField03.setFont(f);
        jbnPlayerName03.setFont(f);
    }

    /**
     * P4
     */
    private void addPlayer04Config(int x, int y, JPanel jp) {
        //
        jlPlayer04Choose = new JLabel(img[chooses[3]]);
        jlPlayer04Choose.setBounds(x + 8, y, 128, 128);
        //
        jlPlayer04Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer04Selected.setVisible(false);
        //
        leftButton04 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        //
        leftButton04.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[3] <= 0) {
                    chooses[3] = img.length;
                }
                jlPlayer04Choose.setIcon(img[--chooses[3]]);
            }
        });

        jp.add(leftButton04);

        rightButton04 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');

        rightButton04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (chooses[3] >= img.length - 1) {
                    chooses[3] = -1;
                }
                jlPlayer04Choose.setIcon(img[++chooses[3]]);
            }
        });
        jp.add(rightButton04);

        jbnPlayer04.setBounds(x, 128 + y, 145, 30);

        jbnPlayer04.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[3] != selected[i]){
                        g++;
                    }
                }

                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }
                if (g == 8) {

                    leftButton04.setEnabled(false);
                    rightButton04.setEnabled(false);
                    jbnPlayer04.setEnabled(false);

                    jlPlayer04Selected.setVisible(true);
                    selected[3] = chooses[3];
                }
            }
        });
        jp.add(jbnPlayer04);
        jp.add(jlPlayer04Selected);
        jp.add(jlPlayer04Choose);
        //
        jbnPlayerNameLabel04.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField04.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName04.setBounds(x, y + 128 + 36 + 36, 145, 30);
        //
        jbnPlayerName04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField04.getText().equals("")) {
                    selectedName[3] = jbnPlayerNameField04.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==3){
                            continue;
                        }
                        if(selectedName[3].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField04.setEditable(false);
                        jbnPlayerName04.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        });
        jp.add(jbnPlayerNameLabel04);
        jp.add(jbnPlayerNameField04);
        jp.add(jbnPlayerName04);

        jbnPlayer04.setFont(f);
        jbnPlayerNameLabel04.setFont(f);
        jbnPlayerNameField04.setFont(f);
        jbnPlayerName04.setFont(f);
    }

    /**
     * P5
     */
    private void addPlayer05Config(int x, int y, JPanel jp) {
        //
        jlPlayer05Choose = new JLabel(img[chooses[4]]);
        jlPlayer05Choose.setBounds(x + 8, y, 128, 128);
        //
        jlPlayer05Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer05Selected.setVisible(false);
        //
        leftButton05 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        //
        leftButton05.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[4] <= 0) {
                    chooses[4] = img.length;
                }
                jlPlayer05Choose.setIcon(img[--chooses[4]]);
            }
        });

        jp.add(leftButton05);
        //
        rightButton05 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        //
        rightButton05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //
                if (chooses[4] >= img.length - 1) {
                    chooses[4] = -1;
                }
                jlPlayer05Choose.setIcon(img[++chooses[4]]);
            }
        });
        jp.add(rightButton05);
        //
        jbnPlayer05.setBounds(x, 128 + y, 145, 30);
        //
        jbnPlayer05.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[4] != selected[i]){
                        g++;
                    }
                }
                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }

                   if (g == 8) {
                       //
                       leftButton05.setEnabled(false);
                       rightButton05.setEnabled(false);
                       jbnPlayer05.setEnabled(false);
                       //
                       jlPlayer05Selected.setVisible(true);
                       selected[4] = chooses[4];
                   }


            }
        });
        jp.add(jbnPlayer05);
        jp.add(jlPlayer05Selected);
        jp.add(jlPlayer05Choose);
        //
        jbnPlayerNameLabel05.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField05.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName05.setBounds(x, y + 128 + 36 + 36, 145, 30);
        //
        jbnPlayerName05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField05.getText().equals("")) {
                    selectedName[4] = jbnPlayerNameField05.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==4){
                            continue;
                        }
                        if(selectedName[4].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField05.setEditable(false);
                        jbnPlayerName05.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        });
        jp.add(jbnPlayerNameLabel05);
        jp.add(jbnPlayerNameField05);
        jp.add(jbnPlayerName05);

        jbnPlayer05.setFont(f);
        jbnPlayerNameLabel05.setFont(f);
        jbnPlayerNameField05.setFont(f);
        jbnPlayerName05.setFont(f);
    }

    /**
     * P6
     */
    private void addPlayer06Config(int x, int y, JPanel jp) {

        jlPlayer06Choose = new JLabel(img[chooses[5]]);
        jlPlayer06Choose.setBounds(x + 8, y, 128, 128);

        jlPlayer06Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer06Selected.setVisible(false);

        leftButton06 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');

        leftButton06.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[5] <= 0) {
                    chooses[5] = img.length;
                }
                jlPlayer06Choose.setIcon(img[--chooses[5]]); //
            }
        });

        jp.add(leftButton06);
        //
        rightButton06 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        //
        rightButton06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //
                if (chooses[5] >= img.length - 1) {
                    chooses[5] = -1;
                }
                jlPlayer06Choose.setIcon(img[++chooses[5]]);
            }
        });
        jp.add(rightButton06);
        //
        jbnPlayer06.setBounds(x, 128 + y, 145, 30); //
        //
        jbnPlayer06.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[5] != selected[i]){
                        g++;
                    }
                }
                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }

                if (g == 8) {
                    //
                    leftButton06.setEnabled(false);
                    rightButton06.setEnabled(false);
                    jbnPlayer06.setEnabled(false);
                    //
                    jlPlayer06Selected.setVisible(true);
                    selected[5] = chooses[5];
                }
            }
        });
        jp.add(jbnPlayer06);
        jp.add(jlPlayer06Selected);
        jp.add(jlPlayer06Choose);
        //
        jbnPlayerNameLabel06.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField06.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName06.setBounds(x, y + 128 + 36 + 36, 145, 30);
        //
        jbnPlayerName06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField06.getText().equals("")) {
                    selectedName[5] = jbnPlayerNameField06.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==5){
                            continue;
                        }
                        if(selectedName[5].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField06.setEditable(false);
                        jbnPlayerName06.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        });
        jp.add(jbnPlayerNameLabel06);
        jp.add(jbnPlayerNameField06);
        jp.add(jbnPlayerName06);

        jbnPlayer06.setFont(f);
        jbnPlayerNameLabel06.setFont(f);
        jbnPlayerNameField06.setFont(f);
        jbnPlayerName06.setFont(f);
    }

    /**
     * P7
     */
    private void addPlayer07Config(int x, int y, JPanel jp) {
        //
        jlPlayer07Choose = new JLabel(img[chooses[6]]);  //
        jlPlayer07Choose.setBounds(x + 8, y, 128, 128);
        //
        jlPlayer07Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer07Selected.setVisible(false);  //
        //
        leftButton07 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a'); //
        //
        leftButton07.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                if (chooses[6] <= 0) { //
                    chooses[6] = img.length; //
                }
                jlPlayer07Choose.setIcon(img[--chooses[6]]); //
            }
        });

        jp.add(leftButton07);

        rightButton07 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');

        rightButton07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (chooses[6] >= img.length - 1) {
                    chooses[6] = -1;
                }
                jlPlayer07Choose.setIcon(img[++chooses[6]]);
            }
        });
        jp.add(rightButton07);

        jbnPlayer07.setBounds(x, 128 + y, 145, 30); //?????

        jbnPlayer07.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[6] != selected[i]){
                        g++;
                    }
                }

                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }
                if (g == 8) {

                    leftButton07.setEnabled(false);
                    rightButton07.setEnabled(false);
                    jbnPlayer07.setEnabled(false);

                    jlPlayer07Selected.setVisible(true);
                    selected[6] = chooses[6];
                }
            }
        });
        jp.add(jbnPlayer07);
        jp.add(jlPlayer07Selected);
        jp.add(jlPlayer07Choose);

        jbnPlayerNameLabel07.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField07.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName07.setBounds(x, y + 128 + 36 + 36, 145, 30);

        jbnPlayerName07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField07.getText().equals("")) {
                    selectedName[6] = jbnPlayerNameField07.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==6){
                            continue;
                        }
                        if(selectedName[6].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField07.setEditable(false);
                        jbnPlayerName07.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        });
        jp.add(jbnPlayerNameLabel07);
        jp.add(jbnPlayerNameField07);
        jp.add(jbnPlayerName07);

        jbnPlayer07.setFont(f);
        jbnPlayerNameLabel07.setFont(f);
        jbnPlayerNameField07.setFont(f);
        jbnPlayerName07.setFont(f);
    }

    /**
     * P8
     */
    private void addPlayer08Config(int x, int y, JPanel jp) {

        jlPlayer08Choose = new JLabel(img[chooses[7]]);  //
        jlPlayer08Choose.setBounds(x + 8, y, 128, 128);

        jlPlayer08Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer08Selected.setVisible(false);  //

        leftButton08 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a'); //

        leftButton08.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (chooses[7] <= 0) {
                    chooses[7] = img.length;
                }
                jlPlayer08Choose.setIcon(img[--chooses[7]]);
            }
        });

        jp.add(leftButton08);

        rightButton08 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');

        rightButton08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (chooses[7] >= img.length - 1) {
                    chooses[7] = -1;
                }
                jlPlayer08Choose.setIcon(img[++chooses[7]]);
            }
        });
        jp.add(rightButton08);

        jbnPlayer08.setBounds(x, 128 + y, 145, 30); //

        jbnPlayer08.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int g = 0;
                for(int i = 0; i < 8; i++) {
                    if(chooses[7] != selected[i]){
                        g++;
                    }
                }
                if( g != 8){
                    JOptionPane.showMessageDialog(null,"All Players' avatar should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                }
                if (g == 8) {

                    leftButton08.setEnabled(false);
                    rightButton08.setEnabled(false);
                    jbnPlayer08.setEnabled(false);

                    jlPlayer08Selected.setVisible(true);
                    selected[7] = chooses[7];
                }
            }
        });
        jp.add(jbnPlayer08);
        jp.add(jlPlayer08Selected);
        jp.add(jlPlayer08Choose);

        jbnPlayerNameLabel08.setBounds(x + 6, y + 128 + 36, 50, 30);
        jbnPlayerNameField08.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName08.setBounds(x, y + 128 + 36 + 36, 145, 30);

        jbnPlayerName08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField08.getText().equals("")) {
                    selectedName[7] = jbnPlayerNameField08.getText();
                    boolean checkName = true;
                    for(int i = 0; i < 8;i++){
                        if(i==7){
                            continue;
                        }
                        if(selectedName[7].equals(selectedName[i])){
                            checkName = false;
                        }
                    }

                    if(checkName == true) {
                        jbnPlayerNameField08.setEditable(false);
                        jbnPlayerName08.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(null,"All Players' Name should be different","Attention",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        });
        jp.add(jbnPlayerNameLabel08);
        jp.add(jbnPlayerNameField08);
        jp.add(jbnPlayerName08);

        jbnPlayer08.setFont(f);
        jbnPlayerNameLabel08.setFont(f);
        jbnPlayerNameField08.setFont(f);
        jbnPlayerName08.setFont(f);
    }

    public void reLoad() {
        leftButton01.setEnabled(true);
        rightButton01.setEnabled(true);
        jbnPlayer01.setEnabled(true);
        jlPlayer01Selected.setVisible(false);
        jlPlayer01Choose.setIcon(img[0]);
        jbnPlayerNameField01.setText("");
        jbnPlayerNameField01.setEditable(true);
        jbnPlayerName01.setEnabled(true);
        selected[0] = -1;
        chooses[0] = 0;

        leftButton02.setEnabled(true);
        rightButton02.setEnabled(true);
        jbnPlayer02.setEnabled(true);
        jlPlayer02Selected.setVisible(false);
        jlPlayer02Choose.setIcon(img[0]);
        jbnPlayerNameField02.setText("");
        jbnPlayerNameField02.setEditable(true);
        jbnPlayerName02.setEnabled(true);
        selected[1] = -2;
        chooses[1] = 0;

        leftButton03.setEnabled(true);
        rightButton03.setEnabled(true);
        jbnPlayer03.setEnabled(true);
        jlPlayer03Selected.setVisible(false);
        jlPlayer03Choose.setIcon(img[0]);
        jbnPlayerNameField03.setText("");
        jbnPlayerNameField03.setEditable(true);
        jbnPlayerName03.setEnabled(true);
        selected[2] = -3;
        chooses[2] = 0;

        leftButton04.setEnabled(true);
        rightButton04.setEnabled(true);
        jbnPlayer04.setEnabled(true);
        jlPlayer04Selected.setVisible(false);
        jlPlayer04Choose.setIcon(img[0]);
        jbnPlayerNameField04.setText("");
        jbnPlayerNameField04.setEditable(true);
        jbnPlayerName04.setEnabled(true);
        selected[3] = -4;
        chooses[3] = 0;

        leftButton05.setEnabled(true);
        rightButton05.setEnabled(true);
        jbnPlayer05.setEnabled(true);
        jlPlayer05Selected.setVisible(false);
        jlPlayer05Choose.setIcon(img[0]);
        jbnPlayerNameField05.setText("");
        jbnPlayerNameField05.setEditable(true);
        jbnPlayerName05.setEnabled(true);
        selected[4] = -5;
        chooses[4] = 0;

        leftButton06.setEnabled(true);
        rightButton06.setEnabled(true);
        jbnPlayer06.setEnabled(true);
        jlPlayer06Selected.setVisible(false);
        jlPlayer06Choose.setIcon(img[0]);
        jbnPlayerNameField06.setText("");
        jbnPlayerNameField06.setEditable(true);
        jbnPlayerName06.setEnabled(true);
        selected[5] = -6;
        chooses[5] = 0;

        leftButton07.setEnabled(true);
        rightButton07.setEnabled(true);
        jbnPlayer07.setEnabled(true);
        jlPlayer07Selected.setVisible(false);
        jlPlayer07Choose.setIcon(img[0]);
        jbnPlayerNameField07.setText("");
        jbnPlayerNameField07.setEditable(true);
        jbnPlayerName07.setEnabled(true);
        selected[6] = -7;
        chooses[6] = 0;

        leftButton08.setEnabled(true);
        rightButton08.setEnabled(true);
        jbnPlayer08.setEnabled(true);
        jlPlayer08Selected.setVisible(false);
        jlPlayer08Choose.setIcon(img[0]);
        jbnPlayerNameField08.setText("");
        jbnPlayerNameField08.setEditable(true);
        jbnPlayerName08.setEnabled(true);
        selected[7] = -8;
        chooses[7] = 0;

        repaint();
    }


    private void addCancelButton(JPanel panel) {
        jbnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                reLoad();
            }


        });
//        jbnCancel.setBounds(656 + 7, 635, 120, 30);
        jbnCancel.setBounds(570 + 7, 480, 120, 30);
        panel.add(jbnCancel);

        jbnCancel.setFont(f);
    }

    private JPanel createPlayerSelectPanel() {
        Locale.setDefault(Locale.ENGLISH);

        JPanel jp = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src/main/java/images/BG_PlayerInfor.jpg");
                g.drawImage(img.getImage(),0,0,null);
            }
        };
        jp.setLayout(null);

        // P1
        addPlayer01Config(12, 0, jp);
        // P2
        addPlayer02Config(212, 0, jp);
        // P3
        addPlayer03Config(412, 0, jp);
        // P4
        addPlayer04Config(612, 0, jp);
        // P5
        addPlayer05Config(12, 235, jp);
        // P6
        addPlayer06Config(212, 235, jp);
        // P7
        addPlayer07Config(412, 235, jp);
        // P8
        addPlayer08Config(612, 235, jp);

        addCancelButton(jp);
        return jp;
    }

    private JPanel createButtonPanel() {
        Locale.setDefault(Locale.ENGLISH);

        JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Comic Sans MS", Font.BOLD, 14)));

        jbnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (selected[0] < 0 || selected[1] < 0 ||selected[2]<0||selected[3]<0||selected[4]<0||selected[5]<0||selected[6]<0||selected[7]<0) {
                    JOptionPane.showMessageDialog(null, "Please check your information","Attention",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "Are you ready?","Attention",JOptionPane.INFORMATION_MESSAGE);
                    if (choose == JOptionPane.OK_OPTION) {
                        //Video Player Frame
                        //Play the Backstory Animation
                        try {
                            new VideoPlayerMain().init();
                            videoPlayerFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                    //Game Frame
                                    new StartGame().init();
                                }
                            });
                        } catch (UnsupportedLookAndFeelException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (InstantiationException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }

                        jf.setVisible(false);
                    }
                }
            }
        });

        jp.add(jbnStart);
        jbnStart.setFont(f);
        return jp;
    }

    public void init() {
        Locale.setDefault(Locale.ENGLISH);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize Laf");
        }

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        jf.add(createPlayerSelectPanel(), BorderLayout.CENTER);
        jf.add(createButtonPanel(), BorderLayout.SOUTH);

        //Set Game's LOGO
        jf.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        jf.setResizable(false);
        jf.setSize(780, 600);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
