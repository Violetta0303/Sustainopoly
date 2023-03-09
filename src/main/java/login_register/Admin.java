package login_register;

public class Admin {
    private String id;            //ID
    private String name;          //Name
    private String password;      //Password

    void setID(String id) {
        this.id=id;
    }

    void setName(String name) {
        this.name=name;
    }

    void setPassword(String password) {
        this.password=password;
    }

    String getID() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    String getPassword() {
        return this.password;
    }
}
