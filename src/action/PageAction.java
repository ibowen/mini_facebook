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
    public void deletePostTemplate(Page page, Post post){
        // a template method to delete a post
        removeTimeLine(page, post);
        removeNewsFeed(page, post);
        removeFriendNewsFeed(page, post);        
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
        //System.out.println("Member: " + page.getFriendList().get(last).getName() + " is added in friendList.");
    }
    
    /**
     * Delete a member into friend list of my page
     * 
     * @param page
     * @param memberID 
     */
    public void deleteFriendTemplate(Page page, Member member){
        // a template method to delete a post
        ArrayList<Member> friendList = page.getFriendList();
        for(Member pageMember: friendList){
            if(member.equals(pageMember)){
                friendList.remove(pageMember);
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
        //System.out.println("Post: Member - " + page.getMemberID() + " 's post is created.");
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
        //System.out.println("Post: post is added in my timeline.");
    }

    /**
     * Remove a post from time line
     * 
     * @param page
     * @param post 
     */
    public void removeTimeLine(Page page, Post post){
        ArrayList<Post> timeLine = page.getTimeLine();
        for(Post timeLinePost: timeLine){
            if(post.equals(timeLinePost)){
                timeLine.remove(timeLinePost);
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
        //System.out.println("Post: post is added in my news feed.");
    }    
    
    /**
     * Remove a post from time line
     * 
     * @param page
     * @param post
     */
    public void removeNewsFeed(Page page, Post post){
        ArrayList<Post> newsFeed = page.getNewsFeed();
        for(Post nfPost: newsFeed){
            if(post.equals(nfPost)){
                newsFeed.remove(nfPost);
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
        //System.out.println("Post: post is added in friend news feed.");
    }  
    
    /**
     * Remove a post into friend news feed of my page
     * 
     * @param page
     * @param post 
     */
    public void removeFriendNewsFeed(Page page, Post post) {
        // add a post in timeline
        ArrayList<Member> friendList = page.getFriendList();
        for(Member friend: friendList){
            Page friendPage = friend.getHomePage();
            removeNewsFeed(friendPage, post);
        }
        //System.out.println("Post: post is added in friend news feed.");
    }      
}
