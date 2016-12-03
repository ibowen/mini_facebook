package factory;

import model.Member;
import model.Page;
import model.Post;

public class MemberFactory extends AbstractFactory {

	@Override
	public Member getMember(String memberName, String memberAddress) {
		// TODO Auto-generated method stub
		return new Member(memberName, memberAddress);
	}

	@Override
	public Page getPage(String memberID, String memberName) {
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
