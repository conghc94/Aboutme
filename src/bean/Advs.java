package bean;

public class Advs {
	private int id_advs;
	private String name;
	private String banner;
	private String link;

	public int getId_advs() {
		return id_advs;
	}

	public void setId_advs(int id_advs) {
		this.id_advs = id_advs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Advs(int id_advs, String name, String banner, String link) {
		super();
		this.id_advs = id_advs;
		this.name = name;
		this.banner = banner;
		this.link = link;
	}

	public Advs() {
		super();
		// TODO Auto-generated constructor stub
	}

}
