package model;

import java.util.ArrayList;

import action.GroupPageAction;

public class GroupPage extends Page {
	private ArrayList<Member> groupMemberList;

	public ArrayList<Member> getGroupMemberList() {
		return groupMemberList;
	}
	
	public void addGroupMember(Member member) {
		// add group member
		GroupPageAction groupPageAction = (GroupPageAction)(this.pageAction);
		groupPageAction.addGroupMemberTemplate(member);
	}
}
