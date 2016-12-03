package action;

import factory.AbstractFactory;
import factory.FactoryProducer;
import java.util.ArrayList;
import model.Member;
import model.Page;
import model.Post;

/**
 * This is a class of page's action. 
 * 
 * @author kuo
 */
public class PageAction {
    /**
     * Create a post in my page 
     * 
     * @param page 
     */
    public void createPostTemplate(Page page) {
        // a template method to create a post
        Post post = createPost();
        addTimeLine(page, post);
        addNewsFeed(page, post);
        addFriendNewsFeed(page, post);        
    }

    /**
     * Add a member into friend list of my page
     * 
     * @param member 
     */
    public void addFriendTemplate(Page page, Member member) {
        // a tempate method to add friends
        ArrayList<Member> friendList = page.getFriendList();
        friendList.add(member);
        page.setFriendList(friendList);
        System.out.print("Member: " + member + " is added in friendList.");         
    }
    
    /**
     * Create a post message
     * 
     * @param page
     * @return 
     */
    public Post createPost(Page page) {
        // create a post
        // ***** ToDo *****
        AbstractFactory postFactory = FactoryProducer.getFactory("POST");
        // ***** ToDo *****
        Post post = postFactory.getPost(page.getMemberID(), "New post by " + page.getMemberID().toString(), "vdo_url", "img_url");
        System.out.print("Post: post is created.");
        return post;
    }
    
    /**
     * add a post into the time line of my page
     * 
     * @param page
     * @param post 
     */
    public void addTimeLine(Page page, Post post) {
        // add a post in timeline
        ArrayList<Post> timeLine = page.getTimeLine();
        timeLine.add(post);
        System.out.print("Post: post is added in my timeline.");       
    }

    /**
     * Add a post into the news feed of my page
     * 
     * @param page
     * @param post 
     */
    public void addNewsFeed(Page page, Post post) {
        // add a post in timeline
        ArrayList<Post> newsFeed = page.getNewsFeed();
        newsFeed.add(post);
        page.setNewsFeed(newsFeed);
        System.out.print("Post: post is added in my news feed.");       
    }    
    
    /**
     * Add a post into friend news feed of my page
     * 
     * @param page
     * @param post 
     */
    public void addFriendNewsFeed(Page page, Post post) {
        // add a post in timeline
        ArrayList<Member> friendList = page.getFriendList();
        for(Member friend: friendList){
            Page friendPage = friend.getHomePage();
            addNewsFeed(friendPage, post);
        }
        System.out.print("Post: post is added in friend news feed.");       
    }    
}
