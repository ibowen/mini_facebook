package factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String objName) {
		if ("POST" == objName) {
			return new PostFactory();
		} else if ("PAGE" == objName) {
			return new PageFactory();
		} else if ("MEMBER" == objName) {
			return new MemberFactory();
		} else {
			return null;
		}
	}
}
