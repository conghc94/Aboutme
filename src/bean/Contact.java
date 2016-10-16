package bean;

public class Contact {
	private int idContact;
	private String fullname;
	private String email;
	private String address;
	private String phone;
	private String content;

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int idContact, String fullname, String email,
			String address, String phone, String content) {
		super();
		this.idContact = idContact;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
