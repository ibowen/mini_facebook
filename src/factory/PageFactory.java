package factory;
import model.Member;
import model.Page;
import model.Post;
/**
 * Created by gzk on 12/2/16.
 */
public class PageFactory extends AbstractFactory{
	@Override
	public Post getPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page getPage(String memberID, String memberName) {
		// TODO Auto-generated method stub
		return new Page(memberID, memberName);
	}

	@Override
	public Member getMember(String memberName, String memberAddress) {
		// TODO Auto-generated method stub
		return null;
	}
   
}

