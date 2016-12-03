package model;

import java.util.ArrayList;

import action.GroupPageAction;

public class GroupPage extends Page {
	private String groupName;
	private ArrayList<Member> groupMemberList;

	public GroupPage(String memberID, String memberName, String groupName) {
		super(memberID, memberName);
		this.groupName = groupName;
	}

	public ArrayList<Member> getGroupMemberList() {
		return groupMemberList;
	}
	
	public void addGroupMember(Member member) {
		// add group member
		GroupPageAction groupPageAction = (GroupPageAction)(this.pageAction);
		groupPageAction.addGroupMemberTemplate(this, member);
	}
}
