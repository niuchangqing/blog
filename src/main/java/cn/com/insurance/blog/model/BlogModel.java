package cn.com.insurance.blog.model;

public class BlogModel {
	/**
	 * 文章id
	 */
	private Long id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 内容体
	 */
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
