package login_register;

import playersInformation.FrameConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {

    Admin admin;

    void setAdmin(Admin admin) {
        this.admin=admin;
    }

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sustainopoly";
    private String user = "root";
    private String password = "992536";



    public boolean login(Admin admin) throws SQLException, ClassNotFoundException {

        String sql="select * from admin where id=? and password=MD5(?)";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, admin.getID());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if(rs.next()) {
            ans = 1;
        }
        rs.close();
        ps.close();
        conn.close();
        if(ans == 1) {
            return true;
        }
        else return false;
    }

    /*
     * JudgeAdmin()
     * Determine if the Admin's ID and password are correct,
     * and if so, show that the login was successful
     * If an error occurs, a window pops up showing
     * an account or password error
     */
    int JudgeAdmin() {

        try {
            if(login(this.admin)) {
                System.out.println("Login successful");
                new FrameConfig().init();
                return 1;
            }else {
                return 0;
            }
        }catch(Exception e) {
            //e.printStackTrace();
        }
        return 0;

    }
}
