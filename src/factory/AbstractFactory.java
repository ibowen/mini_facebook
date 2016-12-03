package factory;

import model.Member;
import model.Page;
import model.Post;

public abstract class AbstractFactory {
	public abstract Member getMember(String memberName, String memberAddress);
	public abstract Post getPost(String memberID, String postText, String videoUrl, String photoUrl);
	public abstract Page getPage(String memberID, String memberName);
}