package Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrameConfig extends JFrame{

    private JButton jbnStart = new JButton("开始游戏");
    private JButton jbnCancel = new JButton("重置设定");

    private JButton jbnPlayer01 = new JButton("1P确认角色");
    private JLabel jbnPlayerNameLabel01 = new JLabel("名字:");
    private JTextField jbnPlayerNameField01 = new JTextField(12);
    private JButton jbnPlayerName01 = new JButton("1P确认名字");

    private JButton jbnPlayer02 = new JButton("2P确认角色");
    private JLabel jbnPlayerNameLabel02 = new JLabel("名字:");
    private JTextField jbnPlayerNameField02 = new JTextField(12);
    private JButton jbnPlayerName02 = new JButton("2P确认名字");


    private JButton jbnPlayer03 = new JButton("3P确认角色");
    private JLabel jbnPlayerNameLabel03 = new JLabel("名字:");
    private JTextField jbnPlayerNameField03 = new JTextField(12);
    private JButton jbnPlayerName03 = new JButton("3P确认名字");

    private JButton jbnPlayer04 = new JButton("4P确认角色");
    private JLabel jbnPlayerNameLabel04 = new JLabel("名字:");
    private JTextField jbnPlayerNameField04 = new JTextField(12);
    private JButton jbnPlayerName04 = new JButton("4P确认名字");

    private JButton jbnPlayer05 = new JButton("5P确认角色");
    private JLabel jbnPlayerNameLabel05 = new JLabel("名字:");
    private JTextField jbnPlayerNameField05 = new JTextField(12);
    private JButton jbnPlayerName05 = new JButton("5P确认名字");

    private JButton jbnPlayer06 = new JButton("6P确认角色");
    private JLabel jbnPlayerNameLabel06 = new JLabel("名字:");
    private JTextField jbnPlayerNameField06 = new JTextField(12);
    private JButton jbnPlayerName06 = new JButton("6P确认名字");

    private JButton jbnPlayer07 = new JButton("7P确认角色");
    private JLabel jbnPlayerNameLabel07 = new JLabel("名字:");
    private JTextField jbnPlayerNameField07 = new JTextField(12);
    private JButton jbnPlayerName07 = new JButton("7P确认名字");

    private JButton jbnPlayer08 = new JButton("8P确认角色");
    private JLabel jbnPlayerNameLabel08 = new JLabel("名字:");
    private JTextField jbnPlayerNameField08 = new JTextField(12);
    private JButton jbnPlayerName08 = new JButton("8P确认名字");

//    /**
//     * 选项卡
//     * */
//    private JTabbedPane tabs;

    /**
     * 可选图片
     * */
    private ImageIcon[] img = Photo.PLAYER_CHOOSE;
    /**
     * 人物1
     **/
    private JLabel jlPlayer01Choose = null;
    private final JLabel jlPlayer01Selected = new JLabel(
            Photo.PLAYER_01_SELECTED);
    private JButton leftButton01;
    private JButton rightButton01;

    /**
     * 人物2
     **/
    private JLabel jlPlayer02Choose = null;
    private final JLabel jlPlayer02Selected = new JLabel(
            Photo.PLAYER_02_SELECTED);
    private JButton leftButton02;
    private JButton rightButton02;

    /**
     * 人物3
     **/
    private JLabel jlPlayer03Choose = null;
    private final JLabel jlPlayer03Selected = new JLabel(
            Photo.PLAYER_01_SELECTED);
    private JButton leftButton03;
    private JButton rightButton03;

    /**
     * 人物4
     **/
    private JLabel jlPlayer04Choose = null;
    private final JLabel jlPlayer04Selected = new JLabel(
            Photo.PLAYER_01_SELECTED);
    private JButton leftButton04;
    private JButton rightButton04;

    /**
     * 人物5
     **/
    private JLabel jlPlayer05Choose = null;
    private final JLabel jlPlayer05Selected = new JLabel(
            Photo.PLAYER_01_SELECTED);
    private JButton leftButton05;
    private JButton rightButton05;

    /**
     * 人物6
     **/
    private JLabel jlPlayer06Choose = null;
    private final JLabel jlPlayer06Selected = new JLabel(
            Photo.PLAYER_02_SELECTED);
    private JButton leftButton06;
    private JButton rightButton06;

    /**
     * 人物7
     **/
    private JLabel jlPlayer07Choose = null;
    private final JLabel jlPlayer07Selected = new JLabel(
            Photo.PLAYER_02_SELECTED);
    private JButton leftButton07;
    private JButton rightButton07;


    /**
     * 人物8
     **/
    private JLabel jlPlayer08Choose = null;
    private final JLabel jlPlayer08Selected = new JLabel(
            Photo.PLAYER_02_SELECTED);
    private JButton leftButton08;
    private JButton rightButton08;

    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p可选人物
     */
    private int[] chooses = { 0, 0, 0, 0, 0, 0, 0, 0};
    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p 已选人物
     */
    private int[] selected = { -1, -2, -3, -4, -5, -6, -7, -8};
    /**
     * 1P 2P 3p 4p 5p 6p 7p 8p已填名字
     */
    private String[] selectedName = { "", "", "", "", "", "", "", ""};

    /**
     *
     * 图标按钮
     *
     * */
    public JButton createButton(int x, int y, ImageIcon[] img, char keyLinstenr) {
        JButton add = new JButton("", img[0]);
        add.setPressedIcon(img[3]);
        add.setRolloverIcon(img[2]);
        add.setMnemonic(keyLinstenr);
        add.setBounds(x, y, img[0].getIconWidth(), img[0].getIconHeight());
        return add;
    }



    /**
     * 增加1P面板
     */
    private void addPlayer01Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer01Choose = new JLabel(img[chooses[0]]);
        jlPlayer01Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer01Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer01Selected.setVisible(false);
        // 创建左按钮
        leftButton01 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        // 添加监听事件
        leftButton01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[0] <= 0) {
                    chooses[0] = img.length;
                }
                jlPlayer01Choose.setIcon(img[--chooses[0]]);
            }
        });

        jp.add(leftButton01);
        // 创建右按钮
        rightButton01 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[0] >= img.length - 1) {
                    chooses[0] = -1;
                }
                jlPlayer01Choose.setIcon(img[++chooses[0]]);
            }
        });
        jp.add(rightButton01);
        // 增加确定框
        jbnPlayer01.setBounds(12 + x, 128 + y, 120, 30);
        // 增加事件监听
        jbnPlayer01.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton01.setEnabled(false);
                    rightButton01.setEnabled(false);
                    jbnPlayer01.setEnabled(false);
                    // 增加选择图片
                    jlPlayer01Selected.setVisible(true);
                    selected[0] = chooses[0];
                }
            }
        });
        jp.add(jbnPlayer01);
        jp.add(jlPlayer01Selected);
        jp.add(jlPlayer01Choose);
        // 增加名字框
        jbnPlayerNameLabel01.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField01.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName01.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField01.getText().equals("")) {
                    selectedName[0] = jbnPlayerNameField01.getText();
                    jbnPlayerNameField01.setEditable(false);
                    jbnPlayerName01.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel01);
        jp.add(jbnPlayerNameField01);
        jp.add(jbnPlayerName01);
    }

    /**
     * 增加2P面板
     */
    private void addPlayer02Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer02Choose = new JLabel(img[chooses[1]]);
        jlPlayer02Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer02Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer02Selected.setVisible(false);
        // 创建左按钮
        leftButton02 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        // 添加监听事件
        leftButton02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[1] <= 0) {
                    chooses[1] = img.length;
                }
                jlPlayer02Choose.setIcon(img[--chooses[1]]);
            }
        });

        jp.add(leftButton02);
        // 创建右按钮
        rightButton02 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[1] >= img.length - 1) {
                    chooses[1] = -1;
                }
                jlPlayer02Choose.setIcon(img[++chooses[1]]);
            }
        });

        jp.add(rightButton02);
        // 增加确定框
        jbnPlayer02.setBounds(12 + x, 128 + y, 120, 30);
        // 增加事件监听
        jbnPlayer02.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (selected[0] != chooses[1]) {
                    // 设置不能点击
                    leftButton02.setEnabled(false);
                    rightButton02.setEnabled(false);
                    jbnPlayer02.setEnabled(false);
                    // 增加选择图片
                    jlPlayer02Selected.setVisible(true);
                    selected[1] = chooses[1];
                }
            }
        });
        jp.add(jbnPlayer02);
        jp.add(jlPlayer02Selected);
        jp.add(jlPlayer02Choose);
        // 增加名字框
        jbnPlayerNameLabel02.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField02.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName02.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField02.getText().equals("")) {
                    selectedName[1] = jbnPlayerNameField02.getText();
                    jbnPlayerNameField02.setEditable(false);
                    jbnPlayerName02.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel02);
        jp.add(jbnPlayerNameField02);
        jp.add(jbnPlayerName02);
    }

    /**
     * 增加3P面板
     */
    private void addPlayer03Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer03Choose = new JLabel(img[chooses[2]]);
        jlPlayer03Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer03Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer03Selected.setVisible(false);
        // 创建左按钮
        leftButton03 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        // 添加监听事件
        leftButton03.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[2] <= 0) {
                    chooses[2] = img.length;
                }
                jlPlayer03Choose.setIcon(img[--chooses[2]]);
            }
        });

        jp.add(leftButton03);
        // 创建右按钮
        rightButton03 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[2] >= img.length - 1) {
                    chooses[2] = -1;
                }
                jlPlayer03Choose.setIcon(img[++chooses[2]]);
            }
        });
        jp.add(rightButton03);
        // 增加确定框
        jbnPlayer03.setBounds(12 + x, 128 + y, 120, 30);
        // 增加事件监听
        jbnPlayer03.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton03.setEnabled(false);
                    rightButton03.setEnabled(false);
                    jbnPlayer03.setEnabled(false);
                    // 增加选择图片
                    jlPlayer03Selected.setVisible(true);
                    selected[2] = chooses[2];
                }
            }
        });
        jp.add(jbnPlayer03);
        jp.add(jlPlayer03Selected);
        jp.add(jlPlayer03Choose);
        // 增加名字框
        jbnPlayerNameLabel03.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField03.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName03.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField03.getText().equals("")) {
                    selectedName[2] = jbnPlayerNameField03.getText();
                    jbnPlayerNameField03.setEditable(false);
                    jbnPlayerName03.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel03);
        jp.add(jbnPlayerNameField03);
        jp.add(jbnPlayerName03);
    }

    /**
     * 增加4P面板
     */
    private void addPlayer04Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer04Choose = new JLabel(img[chooses[3]]);
        jlPlayer04Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer04Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer04Selected.setVisible(false);
        // 创建左按钮
        leftButton04 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        // 添加监听事件
        leftButton04.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[3] <= 0) {
                    chooses[3] = img.length;
                }
                jlPlayer04Choose.setIcon(img[--chooses[3]]);
            }
        });

        jp.add(leftButton04);
        // 创建右按钮
        rightButton04 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[3] >= img.length - 1) {
                    chooses[3] = -1;
                }
                jlPlayer04Choose.setIcon(img[++chooses[3]]);
            }
        });
        jp.add(rightButton04);
        // 增加确定框
        jbnPlayer04.setBounds(12 + x, 128 + y, 120, 30);
        // 增加事件监听
        jbnPlayer04.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton04.setEnabled(false);
                    rightButton04.setEnabled(false);
                    jbnPlayer04.setEnabled(false);
                    // 增加选择图片
                    jlPlayer04Selected.setVisible(true);
                    selected[3] = chooses[3];
                }
            }
        });
        jp.add(jbnPlayer04);
        jp.add(jlPlayer04Selected);
        jp.add(jlPlayer04Choose);
        // 增加名字框
        jbnPlayerNameLabel04.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField04.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName04.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField04.getText().equals("")) {
                    selectedName[3] = jbnPlayerNameField04.getText();
                    jbnPlayerNameField04.setEditable(false);
                    jbnPlayerName04.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel04);
        jp.add(jbnPlayerNameField04);
        jp.add(jbnPlayerName04);
    }

    /**
     * 增加5P面板
     */
    private void addPlayer05Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer05Choose = new JLabel(img[chooses[4]]);
        jlPlayer05Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer05Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer05Selected.setVisible(false);
        // 创建左按钮
        leftButton05 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a');
        // 添加监听事件
        leftButton05.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[4] <= 0) {
                    chooses[4] = img.length;
                }
                jlPlayer05Choose.setIcon(img[--chooses[4]]);
            }
        });

        jp.add(leftButton05);
        // 创建右按钮
        rightButton05 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[4] >= img.length - 1) {
                    chooses[4] = -1;
                }
                jlPlayer05Choose.setIcon(img[++chooses[4]]);
            }
        });
        jp.add(rightButton05);
        // 增加确定框
        jbnPlayer05.setBounds(12 + x, 128 + y, 120, 30);
        // 增加事件监听
        jbnPlayer05.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton05.setEnabled(false);
                    rightButton05.setEnabled(false);
                    jbnPlayer05.setEnabled(false);
                    // 增加选择图片
                    jlPlayer05Selected.setVisible(true);
                    selected[4] = chooses[4];
                }
            }
        });
        jp.add(jbnPlayer05);
        jp.add(jlPlayer05Selected);
        jp.add(jlPlayer05Choose);
        // 增加名字框
        jbnPlayerNameLabel05.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField05.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName05.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField05.getText().equals("")) {
                    selectedName[0] = jbnPlayerNameField05.getText();
                    jbnPlayerNameField05.setEditable(false);
                    jbnPlayerName05.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel05);
        jp.add(jbnPlayerNameField05);
        jp.add(jbnPlayerName05);
    }

    /**
     * 增加6P面板
     */
    private void addPlayer06Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer06Choose = new JLabel(img[chooses[5]]);  // chooses 5 其实也就是 0
        jlPlayer06Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer06Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer06Selected.setVisible(false);  // 同一个地方 设置为不可见  等选择后就设置为可见
        // 创建左按钮
        leftButton06 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a'); // 这个a 没看懂
        // 添加监听事件
        leftButton06.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[5] <= 0) { // 这个时候 chooses 里面的 数字 是 0
                    chooses[5] = img.length; // 把 这个 chooses 里的 数字 0 改成 图片的长度 6
                }
                jlPlayer06Choose.setIcon(img[--chooses[5]]); // 就把你的图片设置为  这个长度 的 6的这张图片
            }
        });

        jp.add(leftButton06);
        // 创建右按钮
        rightButton06 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[5] >= img.length - 1) {
                    chooses[5] = -1;
                }
                jlPlayer06Choose.setIcon(img[++chooses[5]]);
            }
        });
        jp.add(rightButton06);
        // 增加确定框
        jbnPlayer06.setBounds(12 + x, 128 + y, 120, 30); //确认按钮
        // 增加事件监听
        jbnPlayer06.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton06.setEnabled(false);
                    rightButton06.setEnabled(false);
                    jbnPlayer06.setEnabled(false);
                    // 增加选择图片
                    jlPlayer06Selected.setVisible(true);
                    selected[5] = chooses[5];
                }
            }
        });
        jp.add(jbnPlayer06);
        jp.add(jlPlayer06Selected);
        jp.add(jlPlayer06Choose);
        // 增加名字框
        jbnPlayerNameLabel06.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField06.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName06.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField06.getText().equals("")) {
                    selectedName[5] = jbnPlayerNameField06.getText();
                    jbnPlayerNameField06.setEditable(false);
                    jbnPlayerName06.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel06);
        jp.add(jbnPlayerNameField06);
        jp.add(jbnPlayerName06);
    }

    /**
     * 增加7P面板
     */
    private void addPlayer07Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer07Choose = new JLabel(img[chooses[5]]);  // chooses 5 其实也就是 0
        jlPlayer07Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer07Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer07Selected.setVisible(false);  // 同一个地方 设置为不可见  等选择后就设置为可见
        // 创建左按钮
        leftButton07 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a'); // 这个a 没看懂
        // 添加监听事件
        leftButton07.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[5] <= 0) { // 这个时候 chooses 里面的 数字 是 0
                    chooses[5] = img.length; // 把 这个 chooses 里的 数字 0 改成 图片的长度 6
                }
                jlPlayer07Choose.setIcon(img[--chooses[5]]); // 就把你的图片设置为  这个长度 的 6的这张图片
            }
        });

        jp.add(leftButton07);
        // 创建右按钮
        rightButton07 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[5] >= img.length - 1) {
                    chooses[5] = -1;
                }
                jlPlayer07Choose.setIcon(img[++chooses[5]]);
            }
        });
        jp.add(rightButton07);
        // 增加确定框
        jbnPlayer07.setBounds(12 + x, 128 + y, 120, 30); //确认按钮
        // 增加事件监听
        jbnPlayer07.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton07.setEnabled(false);
                    rightButton07.setEnabled(false);
                    jbnPlayer07.setEnabled(false);
                    // 增加选择图片
                    jlPlayer07Selected.setVisible(true);
                    selected[5] = chooses[5];
                }
            }
        });
        jp.add(jbnPlayer07);
        jp.add(jlPlayer07Selected);
        jp.add(jlPlayer07Choose);
        // 增加名字框
        jbnPlayerNameLabel07.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField07.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName07.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField07.getText().equals("")) {
                    selectedName[5] = jbnPlayerNameField07.getText();
                    jbnPlayerNameField07.setEditable(false);
                    jbnPlayerName07.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel07);
        jp.add(jbnPlayerNameField07);
        jp.add(jbnPlayerName07);
    }

    /**
     * 增加8P面板
     */
    private void addPlayer08Config(int x, int y, JPanel jp) {
        // 创建 人物图像label
        jlPlayer08Choose = new JLabel(img[chooses[5]]);  // chooses 5 其实也就是 0
        jlPlayer08Choose.setBounds(x + 8, y, 128, 128);
        // 创建人物图像已选择label
        jlPlayer08Selected.setBounds(x + 8, y, 128, 128);
        jlPlayer08Selected.setVisible(false);  // 同一个地方 设置为不可见  等选择后就设置为可见
        // 创建左按钮
        leftButton08 = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, 'a'); // 这个a 没看懂
        // 添加监听事件
        leftButton08.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置为循环
                if (chooses[5] <= 0) { // 这个时候 chooses 里面的 数字 是 0
                    chooses[5] = img.length; // 把 这个 chooses 里的 数字 0 改成 图片的长度 6
                }
                jlPlayer08Choose.setIcon(img[--chooses[5]]); // 就把你的图片设置为  这个长度 的 6的这张图片
            }
        });

        jp.add(leftButton08);
        // 创建右按钮
        rightButton08 = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
                'd');
        // 添加监听事件
        rightButton08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 设置循环
                if (chooses[5] >= img.length - 1) {
                    chooses[5] = -1;
                }
                jlPlayer08Choose.setIcon(img[++chooses[5]]);
            }
        });
        jp.add(rightButton08);
        // 增加确定框
        jbnPlayer08.setBounds(12 + x, 128 + y, 120, 30); //确认按钮
        // 增加事件监听
        jbnPlayer08.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if ((chooses[0] != selected[1])) {
                    // 设置不能点击
                    leftButton08.setEnabled(false);
                    rightButton08.setEnabled(false);
                    jbnPlayer08.setEnabled(false);
                    // 增加选择图片
                    jlPlayer08Selected.setVisible(true);
                    selected[5] = chooses[5];
                }
            }
        });
        jp.add(jbnPlayer08);
        jp.add(jlPlayer08Selected);
        jp.add(jlPlayer08Choose);
        // 增加名字框
        jbnPlayerNameLabel08.setBounds(x + 12, y + 128 + 36, 50, 30);
        jbnPlayerNameField08.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);
        jbnPlayerName08.setBounds(x + 12, y + 128 + 36 + 36, 120, 30);
        // 按钮添加监听
        jbnPlayerName08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jbnPlayerNameField08.getText().equals("")) {
                    selectedName[5] = jbnPlayerNameField08.getText();
                    jbnPlayerNameField08.setEditable(false);
                    jbnPlayerName08.setEnabled(false);

                }

            }
        });
        jp.add(jbnPlayerNameLabel08);
        jp.add(jbnPlayerNameField08);
        jp.add(jbnPlayerName08);
    }



    private void addCancelButton(JPanel panel) {
        jbnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                reLoad();
            }

            /**
             * 重新加载 人物选择选项卡
             */
            private void reLoad() {
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
        });
//        jbnCancel.setBounds(656 + 7, 635, 120, 30);
        jbnCancel.setBounds(570 + 7, 480, 120, 30);
        panel.add(jbnCancel);
    }


    /**
     * 人物选择面板
     * */
    private JPanel createPlayerSelectPanel() {
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(235,236,237));
        // 增加1P面板
        addPlayer01Config(12, 0, jp);
        // 增加2P面板
        addPlayer02Config(212, 0, jp);
        // 增加3P面板
        addPlayer03Config(412, 0, jp);
        // 增加4P面板
        addPlayer04Config(612, 0, jp);
        // 增加5P面板
        addPlayer05Config(12, 235, jp);
        // 增加6P面板
        addPlayer06Config(212, 235, jp);
        // 增加7P面板
        addPlayer07Config(412, 235, jp);
        // 增加8P面板
        addPlayer08Config(612, 235, jp);
//         增加重置按钮
        addCancelButton(jp);
        return jp;
    }

    /**
     * 添加按钮面板
     */
    private JPanel createButtonPanel() {
        JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // 开始按钮添加监听器
        jbnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (selected[0] < 0 || selected[1] < 0) {
                    JOptionPane.showMessageDialog(null, "请完成人物设置!");
                } else if (selectedName[0].equals("")
                        || selectedName[1].equals("")) {
                    JOptionPane.showMessageDialog(null, "请完成名字设置!");
                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "是否开始？");
                    if (choose == JOptionPane.OK_OPTION) {
//                        // 开始游戏
//                        startGame();
                    }
                }
            }

//            /**
//             * 开始游戏
//             * */
//            private void startGame() {
//                setVisible(false);
//                jFrameGame.setVisible(true);
//                Control control = jFrameGame.getPanelGame().getControl();
//                // 处理玩家数据配置
//                dealPlayers(control);
//                // 控制器启动
//                control.start();
//            }

//            /**
//             * 处理玩家数据配置
//             */
//            private void dealPlayers(Control control) {
//                List<PlayerModel> tempPlayer = control.getPlayers();
//                // 传入名字
//                tempPlayer.get(0).setName(selectedName[0]);
//                tempPlayer.get(1).setName(selectedName[1]);
//                // 传入使用角色编号
//                tempPlayer.get(0).setPart(selected[0]);
//                tempPlayer.get(1).setPart(selected[1]);
//                // 传入 角色对立角色
//                tempPlayer.get(0).setOtherPlayer(tempPlayer.get(1));
//                tempPlayer.get(1).setOtherPlayer(tempPlayer.get(0));
//            }

        });

        jp.add(jbnStart);
        return jp;
    }


    public void init(){
        JFrame jf = new JFrame("用户数据设定");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        jf.add(createPlayerSelectPanel(),BorderLayout.CENTER);
        jf.add(createButtonPanel(),BorderLayout.SOUTH);



        jf.setResizable(false);
//        jf.setSize(380,370);
        jf.setSize(780,600);
        jf.setVisible(true);


    }

    public static void main(String[] args) {
        new FrameConfig().init();
    }
}
