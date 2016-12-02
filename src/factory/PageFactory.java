package factory;
import model.Member;
import model.Page;
/**
 * Created by gzk on 12/2/16.
 */
public class PageFactory extends AbstractFactory{
    public static Page getPage(String memberID, String memberName){
        return new Page(memberID, memberName);
    }
}

