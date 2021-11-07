package database.user;

public class User {
	private int idUser;
    private String name;
    private String password;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

    public User(String name, int idUser, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
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
