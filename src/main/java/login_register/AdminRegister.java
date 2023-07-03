package login_register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/*
 * Administrator registration interface
 *
 */
public class AdminRegister extends JFrame{

    Font f;

    JFrame frame;

    JLabel nameStr;

    JLabel IDStr;

    JLabel passwordStr;

    JLabel confrimStr;

    JTextField userName;

    JTextField userID;

    JPasswordField password;

    JPasswordField confrimPassword;

    JButton buttonregister;

    ImageIcon image;

    AdminRegister() {
        init();
    }
    void init() {
        f = new Font("Comic Sans MS", Font.BOLD, 12);

        frame = new JFrame("Register an admin account");
        frame.setLayout(null);

        nameStr = new JLabel("Name:");
        nameStr.setBounds(200, 150, 100, 25);
        nameStr.setFont(f);
        frame.add(nameStr);

        IDStr = new JLabel("ID:");
        IDStr.setBounds(200, 200, 100, 25);
        IDStr.setFont(f);
        frame.add(IDStr);

        passwordStr = new JLabel("Password:");
        passwordStr.setBounds(200, 250, 100, 25);
        passwordStr.setFont(f);
        frame.add(passwordStr);

        confrimStr = new JLabel("Confirm Password:");
        confrimStr.setBounds(200, 300, 150, 30);
        confrimStr.setFont(f);
        frame.add(confrimStr);

        userName = new JTextField();
        userName.setBounds(320, 150, 150, 25);
        frame.add(userName);

        userID = new JTextField();
        userID.setBounds(320, 200, 150, 25);
        frame.add(userID);

        password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        frame.add(password);

        confrimPassword = new JPasswordField();
        confrimPassword.setBounds(320, 300, 150, 25);
        frame.add(confrimPassword);

        buttonregister = new JButton("Register");
        buttonregister.setBounds(350, 350, 90, 25);
        buttonregister.setFont(f);
        frame.add(buttonregister);

        //Set Game's LOGO
        frame.setIconImage(new ImageIcon("src/main/java/images/Logo.png").getImage());

        //Set Background
        image = new ImageIcon("src/main/java/images/BG_Login_Register.jpg");
        JLabel jLabel = new JLabel(image);
        jLabel.setBounds(0,0,800,540);

        this.getLayeredPane().add(jLabel, new Integer(Integer.MIN_VALUE));
        ((JPanel)this.getContentPane()).setOpaque(false);
        frame.add(jLabel);

        frame.setBounds(400, 100, 800, 540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Add a listener to the Register button
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userName.getText();
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
                String confrimpasswd = new String (confrimPassword.getPassword());

                //Create Register Class
                Register register = new Register();
                register.setID(ID);
                register.setName(name);
                register.setPassword(passwd);
                register.setConfirmPassword(confrimpasswd);

                //If successful register, return to the login interface
                try {
                    if(register.judgeRegister()) {

                        frame.setVisible(false);
                        LoginRegister login_register = new LoginRegister();
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        });
    }
}
