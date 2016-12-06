package action;

import java.util.ArrayList;
import model.*;

/**
 * This is a class of public page's action extending from PageAction. 
 * 
 * @author kuo
 */
public class PublicPageAction extends PageAction {
    /**
     * Add like from a member into a public page
     *
     * @param page
     * @param member
     */
    public void addLike(PublicPage page, Member member) {
        // a template method to add likes

        ArrayList<Member> likeList = page.getLikelist();
        likeList.add(member);

    }

    @Override
    public void createPostTemplate(Page page, String postText, String video_url, String img_url) {
        // a template method to create a post
        Post post = createPost(page, postText, video_url, img_url);
        addTimeLine(page, post);
        addNewsFeed(page, post);
        addLikeListNewsFeed((PublicPage) page, post);
    }

    /**
     * Add a post into GroupMember news feed of my page
     *
     * @param page
     * @param post
     */
    public void addLikeListNewsFeed(PublicPage page, Post post) {
        // add a post in timeline
        ArrayList<Member> likeList = page.getLikelist();
        for (Member member : likeList) {
            Page memberPage = member.getHomePage();
            addNewsFeed(memberPage, post);
        }
        //System.out.println("Post: post is added in friend news feed.");
    }
}
