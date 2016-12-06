package model;

import java.util.ArrayList;
import action.PublicPageAction;

public class PublicPage extends Page {
	private String address;
	private String category;
	private ArrayList<Member> likelist;

	public PublicPage(String memberID, String publicPageName, String address, String category) {
		// TODO Auto-generated constructor stub
		super(memberID, publicPageName);
		this.address = address;
		this.category = category;
                super.pageAction = new PublicPageAction();
                super.pageUrl = "htttp://mini-facebook/publicpage?=" + super.pageID;
		this.likelist = new ArrayList<Member>();
	}


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
		return this.likelist;
	}
	
	public void addLike(Member member) {
		// add likers
		PublicPageAction publicPageAction = (PublicPageAction)(this.pageAction);
		publicPageAction.addLike(this, member);
	}
	
}
