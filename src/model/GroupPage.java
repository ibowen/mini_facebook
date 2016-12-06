package model;

import java.util.ArrayList;

import action.GroupPageAction;

public class GroupPage extends Page {
	private ArrayList<Member> groupMemberList;
	public GroupPage(String memberID, String groupName) {
		super(memberID, groupName);
                super.pageAction = new GroupPageAction();
                super.pageUrl = "htttp://mini-facebook/grouppage?=" + super.pageID;
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
