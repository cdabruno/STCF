package database.user;

public class User {
    private int idUser;
    private String name;
    private String password;

    public User(String name, int idUser, String password) {
        this.idUser = idUser;
        this.name = name;
    }

    public int getIdUser() {
        return this.idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
