package login_register;

import java.sql.*;

import javax.swing.JOptionPane;

public class Register {
    String name;
    String ID;
    String password;
    String confirmPassword;

    Admin admin;

    void setAdmin(Admin admin) {
        this.admin = admin;
    }

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

    void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    boolean judgeRegister() throws SQLException, ClassNotFoundException {

        if (this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty!", "Name is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.ID.equals("")) {
            JOptionPane.showMessageDialog(null, "ID cannot be empty!", "ID is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Password is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!this.password.equals(this.confirmPassword)) {
            JOptionPane.showMessageDialog(null, "The passwords entered twice do not match!", "Inconsistent passwords", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "SELECT * FROM admin WHERE id = ?";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, sqlpassword);
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, this.ID);
        ResultSet rs = ps.executeQuery();
        boolean alreadyExists = rs.next();
        rs.close();
        ps.close();
        conn.close();
        if (alreadyExists) {
            JOptionPane.showMessageDialog(null, "ID already exists", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        JOptionPane.showMessageDialog(null, "Register successfully");
        addAdmin();
        return true;
    }

    void addAdmin() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO admin (id, name, password) VALUES (?, ?, MD5(?))";
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

        } catch (SQLException ex) {
            System.out.println("Failed to add a user!");
        }

    }
}