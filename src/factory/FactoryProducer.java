package factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String objName) {
		if ("POST" == objName) {
			return new PostFactory();
		} else if ("PAGE" == objName) {
			return new PostFactory();
		} else if ("MEMBER" == objName) {
			return new MemberFactory();
		}
		return null;
	}
}
