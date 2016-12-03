package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import factory.FactoryProducer;
import factory.PageFactory;


public class Member {
	private String memberID;
	private String name;
	private String address;
	private Date createAt;
	private ArrayList<String> hobbies;
	private Page homePage;
	private ArrayList<PublicPage> publicPageList;
	private ArrayList<GroupPage> groupPageList;


	/**
	 * Constructor of the Member class
	 * @param memberName is the name of the member
	 * @param memberAddress records the address of the member
	 */
	public Member(String memberName, String memberAddress) {
		this.memberID =  UUID.randomUUID().toString();
		this.name = memberName;
		this.address = memberAddress;
		this.createAt = new Date();
		this.homePage = FactoryProducer.getFactory("PAGE").getPage(this.memberID, this.name);
		this.publicPageList = new ArrayList<PublicPage>();
		this.groupPageList = new ArrayList<GroupPage>();
	}


	/**
	 * Getter method for member ID
	 * @return String memberId
	 */
	public String getMemberID() {
		return memberID;
	}


	/***
	 * Getter method for member name
	 * @return String memberName
	 */
	public String getName() {
		return name;
	}


	/***
	 * Setter method of member name
	 * @param name is the name of this member
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Getter method for member address
	 * @return a string text of the member address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * Setter method for member address
	 * @param address represent the current address of this member
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * Getter method for create date
	 * @return a string of the create date of the member
	 */
	public String getCreateAt() {
		return this.createAt.toString();
	}


	/**
	 * Getter method of the homepage of the member
	 * @return
	 */
	public Page getHomePage() {
		return homePage;
	}


	/***
	 * getter method that shows the hobbies of the member
	 * @return a list of string text represent the hobbies of the member
	 */
	public ArrayList<String> getHobbies() {
		return hobbies;
	}


	/**
	 * getter method that shows the public pages of the member
	 * @return a list of Public pages
	 */
	public ArrayList<PublicPage> getPublicPageList() {
		return publicPageList;
	}


	/**
	 * getter method that shows the group page of the member
	 * @return a list of group pages
	 */

	public ArrayList<GroupPage> getGroupPageList() {
		return groupPageList;
	}


	/***
	 * Add more hobbies for the user
	 * @param hobby string text name of the hobby of the member
	 */
	public void addHobby(String hobby) {
		this.hobbies.add(hobby);
	}


	/***
	 * Remove a hobby from the hobby list of the user
	 * @param hobby
	 */
	public void delHobby(String hobby) {
		this.hobbies.remove(hobby);
	}


	/**
	 * Add new public page to the member's public page list
	 * @param publicPage
	 */
	public void addPublicPage(PublicPage publicPage) {
		this.publicPageList.add(publicPage);
	}


	/**
	 * Remove a public page from the public page list
	 * @param publicPage
	 */
	public void removePublicPage(PublicPage publicPage) {
		this.publicPageList.remove(publicPage);
	}


	/***
	 * Add new group page to the member's group page list
	 * @param groupPage
	 */
	public void addGroupPage(GroupPage groupPage) {
		this.groupPageList.add(groupPage);
	}


	/**
	 * Remove a group page from the group page list
	 * @param groupPage
	 */
	public void removeGroupPage(GroupPage groupPage) {
		this.groupPageList.remove(groupPage);
	}


	/**
	 * The automagic toString method
	 * @return a string representation of a member and its relevant informatoin
	 */
	public String toString() {
		String memberInformation = 	"Member Information_\n"
									+ "_____________________________________________________\n"
									+ "Member Name: " + this.getName() + "\n"
									+ "Member ID: " + this.getMemberID() + "\n"
									+ "Member Address: " + this.getAddress() + "\n"
									+ "Member Since: " + this.getCreateAt() + "\n"
									+ "Member Hobbies: " + this.getHobbies().toString() + "\n"
									+ "-----------------------------------------------------\n";
		return memberInformation;
	}
}
