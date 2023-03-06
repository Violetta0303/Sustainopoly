package login_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Register {
    String name;
    String ID;
    String password;
    String confirmpassword;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sustainopoly";
    private String user = "root";
    private String sqlpassword = "992536";

    void setName(String name) {
        this.name = name;
    }
    void setID(String ID) {
        this.ID = ID;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


    //Determine whether a registered account complies with the rules
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {

        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty!", "Name is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "ID cannot be empty!", "ID is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Password is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "The passwords entered twice do not match!", "Inconsistent passwords", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Comply with the rules, pop up the registration success window and add the account to the database
        JOptionPane.showMessageDialog(null, "Register successfully");
        addAdmin();
        return true;
    }

    //Add an Admin account to the database
    void addAdmin() throws ClassNotFoundException, SQLException {
        String sql="insert into admin (id, name, password) values (?,?,MD5(?))";
        Class.forName(driver);
        try {
            Connection conn = DriverManager.getConnection(url, user, sqlpassword);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.ID);
            ps.setString(2, this.name);
            ps.setString(3, this.password);
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            System.out.println("Failed to add a user!");
        }

    }
}