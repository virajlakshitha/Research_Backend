package com.tech.ring.domain;

public class Comments {

	private String comment;
	
	private String comment_name;
	
	private String comment_pic;

	public Comments(String comment, String comment_name, String comment_pic) {
		this.comment = comment;
		this.comment_name = comment_name;
		this.comment_pic = comment_pic;
	}
	public Comments() {
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment_name() {
		return comment_name;
	}

	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}

	public String getComment_pic() {
		return comment_pic;
	}

	public void setComment_pic(String comment_pic) {
		this.comment_pic = comment_pic;
	}
}
