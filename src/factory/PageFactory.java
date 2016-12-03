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
	public PublicPage getPublicPage(String memberID, String memberName, String address, String category) {
		return new PublicPage(memberID, memberName, address, category);
	}
	
	public GroupPage getGroupPage(String memberID, String memberName, String groupName) {
		return new GroupPage(memberID, memberName, groupName);
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

