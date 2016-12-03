/**
 * Created by gzk on 12/2/16.
 * Application logic tested here in the App
 */

import factory.*;
import model.*;

import java.util.ArrayList;

public class App {
    public static void main(String args[]) {
        AbstractFactory memberFactory = FactoryProducer.getFactory("MEMBER");
        Member qq = memberFactory.getMember("强强", "1 loop way, 85719");
        qq.addHobby("看电影");
        qq.addHobby("游泳");
        qq.addHobby("游戏");
        System.out.println(qq.toString());

        Member qq1 = memberFactory.getMember("强强1", "1 loop way, 85719");
        qq1.addHobby("看电影");
        qq1.addHobby("游泳");
        qq1.addHobby("游戏");
        System.out.println(qq1.toString());

        Member qq2 = memberFactory.getMember("强强2", "1 loop way, 85719");
        qq2.addHobby("看电影");
        qq2.addHobby("游泳");
        qq2.addHobby("游戏");
        System.out.println(qq2.toString());

        Member qq3 = memberFactory.getMember("强强3", "1 loop way, 85719");
        qq3.addHobby("看电影");
        qq3.addHobby("游泳");
        qq3.addHobby("游戏");
        System.out.println(qq3.toString());

        Member qq4 = memberFactory.getMember("强强4", "1 loop way, 85719");
        qq4.addHobby("看电影");
        qq4.addHobby("游泳");
        qq4.addHobby("游戏");
        System.out.println(qq4.toString());


        /**
         * remove hobby
         */
        qq4.delHobby("看电影");
        System.out.println(qq4.toString());

        //add post
        qq4.getHomePage().createPost("this is text post",  "www.test.co", "ddd.image.url");
        qq4.getHomePage().createPost("this is text post2",  "www.test.co", "ddd.image.url");




        //timeline print
        qq4.getHomePage().showTimeLine();
        qq4.getHomePage().showNewsFeed();
        //add friend
        qq.getHomePage().addFriend(qq1);
        qq.getHomePage().addFriend(qq2);
        qq.getHomePage().addFriend(qq3);

        //add public page
        AbstractFactory pf = FactoryProducer.getFactory("PAGE");
        PageFactory pf2 = (PageFactory)pf;
        PublicPage pg = pf2.getPublicPage(qq.getMemberID(), qq.getName(), "address 1", "type1");
        System.out.println(pg);

        //add group page
        GroupPage gp = pf2.getGroupPage(qq.getMemberID(), qq.getName(), "group1");
        System.out.println(gp);

    }
}
