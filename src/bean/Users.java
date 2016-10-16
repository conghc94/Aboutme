package bean;

public class Users {
	private int idUsers;
	private String username;
	private String password;
	private String fullname;

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Users(int idUsers, String username, String password, String fullname) {
		super();
		this.idUsers = idUsers;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	public Users() {
		super();

	}

}
