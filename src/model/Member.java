package model;

import java.util.ArrayList;
import java.util.Date;

public class Member {
	private String memberID;
	private String name;
	private String address;
	private Date createAt;
	private ArrayList<String> hobbies;
	private Page homePage;
	private ArrayList<PublicPage> publicPageList;
	private ArrayList<GroupPage> groupPageList;
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Page getHomePage() {
		return homePage;
	}
	public void setHomePage(Page homePage) {
		this.homePage = homePage;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public ArrayList<PublicPage> getPublicPageList() {
		return publicPageList;
	}
	public ArrayList<GroupPage> getGroupPageList() {
		return groupPageList;
	}
	
	// add hobby
	public void addHobby(String hobby) {
		this.hobbies.add(hobby);
	}
	public void delHobby(String hobby) {
		this.hobbies.remove(hobby);
	}
	// add public page
	public void addPublicPage(PublicPage publicPage) {
		this.publicPageList.add(publicPage);
	}
	// remove public page
	public void removePublicPage(PublicPage publicPage) {
		this.publicPageList.remove(publicPage);
	}
	// add group page
	public void addGroupPage(GroupPage groupPage) {
		this.groupPageList.add(groupPage);
	}
	// remove group page
	public void removeGroupPage(GroupPage groupPage) {
		this.groupPageList.remove(groupPage);
	}
}
