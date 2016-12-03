package action;

import java.util.ArrayList;
import model.Member;
import model.PublicPage;

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
}
