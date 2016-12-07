import model.GroupPage;
import model.Member;
import factory.*;
import model.PublicPage;


/**
 * Created by gzk on 12/5/16.
 */
public class Demo {
    public static void main(String args[]) {

        // Demo step 1 - Create member1, member2 and member3
        AbstractFactory memberFactory = FactoryProducer.getFactory("MEMBER");
        Member member1 = memberFactory.getMember("member1", "member 1 address");
        Member member2 = memberFactory.getMember("member2", "member 1 address");
        Member member3 = memberFactory.getMember("member3", "member 1 address");

        // Demo step 2 - member1 create group1
        PageFactory pageFactory = (PageFactory) FactoryProducer.getFactory("PAGE");
        GroupPage groupPage1 = pageFactory.getGroupPage(member1, "group1");

        // Demo step 3 - member2 create group2
        GroupPage groupPage2 = pageFactory.getGroupPage(member2, "group2");

        // Demo step 4 - member 3 create public page
        PublicPage publiPage1 = pageFactory.getPublicPage(member3, "publicPage2", "publicPage1 address", "Non-Profit");
        PublicPage publiPage2 = pageFactory.getPublicPage(member3, "publicPage2", "publicPage1 address", "Non-Profit");


        // Demo step 5 - member1 add member2 and member3 as friend
        member1.getHomePage().addFriend(member2);
        member2.getHomePage().addFriend(member1);

        member1.getHomePage().addFriend(member3);
        member3.getHomePage().addFriend(member1);


        // Demo step 6 - member1, member2, member3 publish their first post, in their own timeline
        member1.getHomePage().createPost("member1 first post!", "VideoURL: None", "ImageUrlNone");
        member2.getHomePage().createPost("member2 first post!", "VideoURL: None", "ImageUrlNone");
        member3.getHomePage().createPost("member3 first post!", "VideoURL: None", "ImageUrlNone");

        // Demo step 7 - member1 likes public page one
        publiPage1.addLike(member1);

        // Demo step 8 - member 1 joins group2
        groupPage2.addGroupMember(member1);

//        System.out.println("GROUPPAGE2");
//        System.out.println(groupPage2.getGroupMemberList());

        // Demo step 9 - member2 likes publicPage2
        publiPage2.addLike(member2);
//        System.out.println(publiPage2.getLikelist());

        // Demo step 10 - member1 post t group1
//        System.out.println(member1.getGroupPageList());
        groupPage1.createPost("group1 post 1st", "g1p1.video", "g1p1.img");
//        for (Member member : groupPage1.getGroupMemberList()) {
//            System.out.println(" test " + member.getHomePage().getNewsFeed());
//            member.getHomePage().showNewsFeed();
//        }

        // Demo step 11 member2 post to group2
        groupPage2.createPost("group2 post 1st", "g2p2.video", "g2p2.img");
//        for (Member member : groupPage2.getGroupMemberList()) {
//            System.out.println(member.getName());
//            System.out.println(" test " + member.getHomePage().getNewsFeed());
//            member.getHomePage().showNewsFeed();
//        }
        // Demo step 12
        publiPage1.createPost("publicpage 1 post 1st", "p1p1.video", "p1p1.img");
        publiPage2.createPost("publicpage 2 post 1st", "p2p2.video", "p2p2.img");

        // Demo step 13 - member1,2,3 display newsfeed
        System.out.println();
        System.out.println();
        System.out.println(member1.getName());
        System.out.println("--------------------------------");
        System.out.println("Friend List");
        System.out.print(member1.getHomePage().getFriendList());
        System.out.println();
        System.out.println("NewsFeed");
        member1.getHomePage().showNewsFeed();
        System.out.println("--------------------------------");
        System.out.println();


        System.out.println(member2.getName());
        System.out.println("--------------------------------");
        System.out.println("Friend List");
        System.out.println(member2.getHomePage().getFriendList());
        System.out.println("");
        System.out.println("NewsFeed");
        member2.getHomePage().showNewsFeed();
        System.out.println("--------------------------------");
        System.out.println();


        System.out.println(member3.getName());
        System.out.println("--------------------------------");
        System.out.println("Friend List");
        System.out.println(member3.getHomePage().getFriendList());
        System.out.println("");
        System.out.println("NewsFeed");
        member3.getHomePage().showNewsFeed();
        System.out.println("--------------------------------");
        System.out.println();











    }
}
