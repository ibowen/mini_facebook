package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import action.PageAction;

public class Post {
	
	private String postID;
	private String memberID;
	private String postText;
	private String videoUrl;
	private String photoUrl;
	private Date createAt;
	ArrayList<Post> comments;
	
	public Post(String memberID, String postText,
			String videoUrl, String photoUrl) {
		super();
		this.postID = UUID.randomUUID().toString();
		this.memberID = memberID;
		this.postText = postText;
		this.videoUrl = videoUrl;
		this.photoUrl = photoUrl;
		this.createAt = new Date();
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public ArrayList<Post> getComments() {
		return comments;
	}

	public void showPost() {
		// TODO Auto-generated method stub

		System.out.println("Post: " + this.getPostText());
	}
	
	public void addComment(Post post) {
		this.comments.add(post);
	}

}
