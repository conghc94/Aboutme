package bean;

public class Saying {
	private int idSaying;
	private String content;
	private String author;

	public int getIdSaying() {
		return idSaying;
	}

	public void setIdSaying(int idSaying) {
		this.idSaying = idSaying;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Saying(int idSaying, String content, String author) {
		super();
		this.idSaying = idSaying;
		this.content = content;
		this.author = author;
	}

	public Saying() {
		super();
		// TODO Auto-generated constructor stub
	}
}
