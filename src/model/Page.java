package model;

import java.util.ArrayList;
import java.util.Date;

import action.PageAction;

public class Page {
	protected Member owner;
	protected String pageUrl;
	protected String pageName;
	protected String description;
	protected Date createAt;
	protected Date modifiedAt;
	
	protected ArrayList<Post> timeLine;
	protected ArrayList<Member> friendList;
	protected ArrayList<Post> newsFeed;
	
	protected PageAction pageAction;
	
	public Member getOwner() {
		return owner;
	}
	public void setOwner(Member owner) {
		this.owner = owner;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public PageAction getPageAction() {
		return pageAction;
	}
	public void showTimeLine() {
		// show timeline of the current page
		for (Post p : this.timeLine) {
			p.displayPost();
		}
	}
	
	public ArrayList<Member> viewFriends() {
		// show members of the current page
		return this.friendList;
	}
	
	public void disPlayNewsFeed() {
		// display news of friends of the current page
		for (Post p : this.newsFeed) {
			p.displayPost();
		}
	}
	
	public void createPost() {
		// create post template
		if (this.pageAction != null) {
			this.pageAction.createPostTemplate(this);
		}
	}
	
	public void addFriend(Member member) {
		// add friends
		this.pageAction.addFriendTemplate(member);
	}
}
