package login_register;

import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;

public class LoginRegister extends JFrame{

    Font f;

    JFrame frame;

    JLabel nameStr;

    JLabel passwordStr;

    JTextField userID;

    JPasswordField password;

    JButton buttonlogin;

    JButton buttonregister;

    ImageIcon image;

    LoginRegister() {
        init();
    }
    //Initialise the login interface
    public void init() {
        f = new Font("Comic Sans MS", Font.BOLD, 12);

        frame = new JFrame("Login");
        frame.setLayout(null);

        nameStr = new JLabel("ID:");
        nameStr.setBounds(250, 200, 100, 25);
        nameStr.setFont(f);
        frame.add(nameStr);

        passwordStr = new JLabel("Password:");
        passwordStr.setBounds(250, 250, 100, 25);
        passwordStr.setFont(f);
        frame.add(passwordStr);

        userID = new JTextField();
        userID.setBounds(320, 200, 150, 25);
        frame.add(userID);

        password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        frame.add(password);

        buttonlogin = new JButton("Login");
        buttonlogin.setBounds(300, 300, 90, 25);
        buttonlogin.setFont(f);
        frame.add(buttonlogin);

        buttonregister = new JButton("Register");
        buttonregister.setBounds(400, 300, 90, 25);
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

        //Add a listener to the Login button
        buttonlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());

                //Create an Admin user and bring up
                //the username password and in the input box
                Admin admin = new Admin();
                admin.setID(ID);
                admin.setPassword(passwd);

                //Login
                Login login = new Login();
                login.setAdmin(admin);

                if(login.JudgeAdmin()==0) {
                    //A pop-up window with an incorrect account number or password
                    JOptionPane.showMessageDialog(null, "Wrong account or password", "Wrong account or password", JOptionPane.WARNING_MESSAGE);
                    //Clear the message in the password box
                    password.setText("");
                    //Clear the information in the account box
                    userID.setText("");

                    //System.out.println("Login unsuccessful!");
                } else {
                    //Pop-up window for successful login
                    JOptionPane.showMessageDialog(null, "Login successful", "Login successful", JOptionPane.NO_OPTION);
                    //Click on OK and you will be redirected to the main window
                    frame.setVisible(false);
                }

            }
        });

        //Add a listener to the Register button
        buttonregister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Register page
                frame.setVisible(false);
                AdminRegister ar = new AdminRegister();
            }
        });
    }

    public static void main(String []args) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize Laf" );
        }

        //Login Window
        LoginRegister login_register = new LoginRegister();
    }
}