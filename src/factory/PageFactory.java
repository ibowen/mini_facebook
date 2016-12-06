package factory;
import model.GroupPage;
import model.Member;
import model.Page;
import model.Post;
import model.PublicPage;
/**
 * Created by gzk on 12/2/16.
 */
public class PageFactory extends AbstractFactory{
	@Override
	public Page getPage(String memberID, String memberName) {
		// TODO Auto-generated method stub
		return new Page(memberID, memberName);
	}
	public PublicPage getPublicPage(Member member, String publicPageName, String address, String category) {
		PublicPage publicPage = new PublicPage(member.getMemberID(), publicPageName, address, category);
                member.getPublicPageList().add(publicPage);
                return publicPage;
	}
	
	public GroupPage getGroupPage(Member member, String groupName) {
		GroupPage groupPage = new GroupPage(member.getMemberID(), groupName);
                member.getGroupPageList().add(groupPage);
                return groupPage;
	}

	@Override
	public Member getMember(String memberName, String memberAddress) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Post getPost(String memberID, String postText, String videoUrl,
			String photoUrl) {
		// TODO Auto-generated method stub
		return null;
	}
   
}

