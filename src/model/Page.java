package model;

import java.util.ArrayList;
import java.util.Date;

import action.PageAction;
import java.util.UUID;

public class Page {
	protected String memberID;
        protected String pageID;
	protected String pageUrl;
	protected String pageName;
	protected String description;
	protected Date createAt;
	protected Date modifiedAt;
	
	protected ArrayList<Post> timeLine;
	protected ArrayList<Member> friendList;
	protected ArrayList<Post> newsFeed;
	
	protected PageAction pageAction;

	/*
	*  Constructor for page
	* */
	public Page(String memberID, String pageName){
		this.memberID = memberID;
                this.pageID = UUID.randomUUID().toString();
		this.pageUrl = "htttp://mini-facebook/user?=" + this.pageID;
		this.pageName = "Page of " + pageName;
		this.description = "Welcome! This is my public page. Please leave some comments!";
		this.createAt = new Date();
		this.timeLine = new ArrayList<Post>();
		this.friendList = new ArrayList<Member>();
		this.newsFeed = new ArrayList<Post>();
		this.pageAction = new PageAction();
		System.out.println("Page: " + this.pageName + " created!");
	}

	public void setPageAction(PageAction pageAction) {
		this.pageAction = pageAction;
	}


	public String getMemberID() {
		return memberID;
	}


	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getPageName() {
		return this.pageName;
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

	public ArrayList<Post> getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(ArrayList<Post> timeLine) {
		this.timeLine = timeLine;
	}

	public ArrayList<Member> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<Member> friendList) {
		this.friendList = friendList;
	}

	public ArrayList<Post> getNewsFeed() {
		return newsFeed;
	}

	public void setNewsFeed(ArrayList<Post> newsFeed) {
		this.newsFeed = newsFeed;
	}

	public PageAction getPageAction() {
		return pageAction;
	}
	public void showTimeLine() {
		// show timeline of the current page
		for (Post p : this.timeLine) {
			p.showPost();
		}
	}
	
	public ArrayList<Member> viewFriends() {
		// show members of the current page
		return this.friendList;
	}
	
	public void showNewsFeed() {
		// show news of friends of the current page
		for (Post p : this.newsFeed) {
			p.showPost();
		}
	}
	
	public void createPost(String postText, String video_url, String img_url) {
		// create post template
		if (this.pageAction != null) {
			this.pageAction.createPostTemplate(this, postText, video_url, img_url);
		}
	}
	
	public void addFriend(Member member) {
		// add friends
		this.pageAction.addFriendTemplate(this, member);
	}
}
