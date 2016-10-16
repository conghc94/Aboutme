package bean;

public class Project {
	private int id_project;
	private String name;
	private String preview_text;
	private String picture;
	private String link;
	public int getId_project() {
		return id_project;
	}
	public void setId_project(int id_project) {
		this.id_project = id_project;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Project(int id_project, String name, String preview_text, String picture, String link) {
		super();
		this.id_project = id_project;
		this.name = name;
		this.preview_text = preview_text;
		this.picture = picture;
		this.link = link;
	}
	
}
