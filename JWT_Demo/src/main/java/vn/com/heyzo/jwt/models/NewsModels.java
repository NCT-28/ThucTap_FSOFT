package vn.com.heyzo.jwt.models;

public class NewsModels {
	public String title;
	public String content;
	public String author;
	public NewsModels() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsModels(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
}
