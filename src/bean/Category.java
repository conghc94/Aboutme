package bean;

public class Category {
	private int idCat;
	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructors stub
	}

	public Category(int idCat, String name) {
		super();
		this.idCat = idCat;
		this.name = name;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
