package action;

import factory.AbstractFactory;
import factory.FactoryProducer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public void createPostTemplate(Page page, String postText, String video_url, String img_url) {
        // a template method to create a post
        Post post = createPost(page, postText, video_url, img_url);
        addTimeLine(page, post);
        addNewsFeed(page, post);
        addFriendNewsFeed(page, post);
    }

    /**
     * Delete a post in my page
     * 
     * @param page
     * @param postID 
     */
    public void deletePostTemplate(Page page, String postID){
        // a template method to delete a post
        removeTimeLine(page, postID);
        removeNewsFeed(page, postID);
        removeFriendNewsFeed(page, postID);        
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
        int last = friendList.size() - 1;
        System.out.println("Member: " + page.getFriendList().get(last).getName() + " is added in friendList.");
    }
    
    /**
     * Delete a member into friend list of my page
     * 
     * @param page
     * @param memberID 
     */
    public void deleteFriendTemplate(Page page, Member memberID){
        // a template method to delete a post
        ArrayList<Member> friendList = page.getFriendList();
        for(Member member: friendList){
            if(memberID.equals(member.getMemberID())){
                friendList.remove(member);
                return;
            }
        }        
    }
    
    /**
     * Create a post message
     * 
     * @param page
     * @return 
     */
    public Post createPost(Page page, String postText, String video_url, String img_url) {
        // create a post
        AbstractFactory postFactory = FactoryProducer.getFactory("POST");
        Post post = postFactory.getPost(page.getMemberID(), postText, video_url, img_url);
        System.out.println("Post: Member - " + page.getMemberID() + " 's post is created.");
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
        System.out.println("Post: post is added in my timeline.");       
    }

    /**
     * Remove a post from time line
     * 
     * @param page
     * @param postID 
     */
    public void removeTimeLine(Page page, String postID){
        ArrayList<Post> timeLine = page.getTimeLine();
        for(Post post: timeLine){
            if(postID.equals(post.getPostID())){
                timeLine.remove(post);
                return;
            }
        }
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
        System.out.println("Post: post is added in my news feed.");       
    }    
    
    /**
     * Remove a post from time line
     * 
     * @param page
     * @param postID 
     */
    public void removeNewsFeed(Page page, String postID){
        ArrayList<Post> newsFeed = page.getNewsFeed();
        for(Post post: newsFeed){
            if(postID.equals(post.getPostID())){
                newsFeed.remove(post);
                return;
            }
        }
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
        System.out.println("Post: post is added in friend news feed.");
    }  
    
    /**
     * Remove a post into friend news feed of my page
     * 
     * @param page
     * @param postID 
     */
    public void removeFriendNewsFeed(Page page, String postID) {
        // add a post in timeline
        ArrayList<Member> friendList = page.getFriendList();
        for(Member friend: friendList){
            Page friendPage = friend.getHomePage();
            removeNewsFeed(friendPage, postID);
        }
        System.out.println("Post: post is added in friend news feed.");
    }      
}
