package entity;

public class UserClass {

	private int id;
	private String fullname;
	private String email;
	private String password;
	public int getId() {
		return id;
	}

	public UserClass(int id, String fullname, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}

	public UserClass() {
		super();
	}
	@Override
	public String toString() {
		return "UserClass [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
