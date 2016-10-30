package model;

import java.util.ArrayList;
import java.util.Date;

public class Post {
	
	private String postID;
	private Member owner;
	private String postText;
	private String videoUrl;
	private String photoUrl;
	private Date createAt;
	ArrayList<Post> comments;
	
	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
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

	public void displayPost() {
		// TODO Auto-generated method stub
		System.out.println("displayPost");
	}
	
	public void addComment(Post post) {
		this.comments.add(post);
	}

}
