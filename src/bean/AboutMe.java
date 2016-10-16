package bean;

public class AboutMe {
private int idAboutMe;
private String name;
	private String detailText;

	public AboutMe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AboutMe(int idAboutMe, String name, String detailText) {
		super();
		this.idAboutMe = idAboutMe;
		this.name = name;
		this.detailText = detailText;
	}

	public int getIdAboutMe() {
		return idAboutMe;
	}

	public void setIdAboutMe(int idAboutMe) {
		this.idAboutMe = idAboutMe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
}
