package action;

import java.util.ArrayList;
import model.*;

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
            //System.out.println("Member: " + member + " is added in friendList.");
            return;
        }
        //System.out.println("Member: " + member + " can not be added into group page. Out of number limit!");
    }

    @Override
    public void createPostTemplate(Page page, String postText, String video_url, String img_url) {
        // a template method to create a post
        Post post = createPost(page, postText, video_url, img_url);
        addTimeLine(page, post);
        addNewsFeed(page, post);
        addGroupMemberNewsFeed((GroupPage)page, post);
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

    /**
     * Add a post into GroupMember news feed of my page
     *
     * @param page
     * @param post
     */
    public void addGroupMemberNewsFeed(GroupPage page, Post post) {
        // add a post in timeline
        ArrayList<Member> memberList = page.getGroupMemberList();
        for(Member member: memberList){
            Page memberPage = member.getHomePage();
            addNewsFeed(memberPage, post);
        }
        //System.out.println("Post: post is added in friend news feed.");
    }

}
