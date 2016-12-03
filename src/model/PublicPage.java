package model;

import java.util.ArrayList;

import action.PublicPageAction;

public class PublicPage extends Page {
	public PublicPage(String memberID, String memberName, String address, String category) {
		// TODO Auto-generated constructor stub
		super(memberID, memberName);
		this.address = address;
		this.category = category;
	}

	private String address;
	private String category;
	private ArrayList<Member> likelist;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<Member> getLikelist() {
		return likelist;
	}
	
	public void addLike(Member member) {
		// add likers
		PublicPageAction publicPageAction = (PublicPageAction)(this.pageAction);
		publicPageAction.addLike(this, member);
	}
	
}
