package factory;

import model.Member;
import model.Page;
import model.Post;

public abstract class AbstractFactory {
	public abstract Member getMember(String memberName, String memberAddress);
	public abstract Post getPost();
	public abstract Page getPage(String memberID, String memberName);
}