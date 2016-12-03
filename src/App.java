/**
 * Created by gzk on 12/2/16.
 * Application logic tested here in the App
 */

import factory.*;
import model.*;

public class App {
    public static void main(String args[]) {
        AbstractFactory memberFactory = FactoryProducer.getFactory("MEMBER");
        Member qq = memberFactory.getMember("强强", "1 loop way, 85719");
        qq.addHobby("看电影");
        qq.addHobby("游泳");
        qq.addHobby("游戏");
        System.out.println(qq.toString());
    }
}
