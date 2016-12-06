package action;

import java.util.ArrayList;
import model.GroupPage;
import model.Member;

/**
 * This is a class of group page's action extending from PageAction. 
 * 
 * @author kuo
 */
public class GroupPageAction extends PageAction {
    /**
     * declare group member number limit
     */
    final int memberLimit = 5;
    
    /**
     * Add member into group page 
     * @param page
     * @param member 
     */
    public void addGroupMemberTemplate(GroupPage page, Member member) {
        // a tempate method to add friends
        if(repOK(page)){
            ArrayList<Member> memberList = page.getGroupMemberList();
            memberList.add(member);
            System.out.println("Member: " + member + " is added in friendList.");
            return;
        }
        System.out.println("Member: " + member + " can not be added into group page. Out of number limit!");
    }   

    /**
     * Check representation invariance: group page member number is under the limit 
     * 
     * @param page
     * @return 
     */
    private boolean repOK(GroupPage page) {
        ArrayList<Member> friendList = page.getGroupMemberList();
        return friendList.size() <= memberLimit;
    }
}
