package bean;

public class News {
private int idNews;
private String name;
private String preview_text;
private String detail_text;
private int idCat;
private String picture;
private int isActive;
	private String nameCat;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int idNews, String name, String preview_text,
			String detail_text, int idCat, String picture, int isActive,
			String nameCat) {
		super();
		this.idNews = idNews;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.idCat = idCat;
		this.picture = picture;
		this.isActive = isActive;
		this.nameCat = nameCat;
	}

	public int getIdNews() {
		return idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreview_text() {
		return preview_text;
	}

	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}

	public String getDetail_text() {
		return detail_text;
	}

	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
}
