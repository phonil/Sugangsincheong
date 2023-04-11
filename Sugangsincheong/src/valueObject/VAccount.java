package valueObject;

public class VAccount {
	private String id;
	private String password;
	private String name;
	private String birthFront;
	private String birthBack;
	private String mail;

	public VAccount() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthFront() {
		return birthFront;
	}

	public void setBirthFront(String birthFront) {
		this.birthFront = birthFront;
	}

	public String getBirthBack() {
		return birthBack;
	}

	public void setBirthBack(String birthBack) {
		this.birthBack = birthBack;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
