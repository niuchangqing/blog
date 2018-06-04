package cn.com.insurance.blog.main.po;

import java.util.Date;
public class BottomBar {
	private Long id;

	private String name;

	private String link;

	private Byte size;

	private String wordBeforeSelection;

	private String wordAfterSelection;

	private String backgroundColor;

	private Date startDate;

	private Date endDate;
	// 使用平台 0 全部 ，1 iOS，2 Android
	private String platform;

	private String creator;

	private Date createDate;

	private String modify;

	private Date modifyDate;

	private Byte isDel;

	private String status;// 跟数据库不对应

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Byte getSize() {
		return size;
	}

	public void setSize(Byte size) {
		this.size = size;
	}

	public String getWordBeforeSelection() {
		return wordBeforeSelection;
	}

	public void setWordBeforeSelection(String wordBeforeSelection) {
		this.wordBeforeSelection = wordBeforeSelection;
	}

	public String getWordAfterSelection() {
		return wordAfterSelection;
	}

	public void setWordAfterSelection(String wordAfterSelection) {
		this.wordAfterSelection = wordAfterSelection;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}