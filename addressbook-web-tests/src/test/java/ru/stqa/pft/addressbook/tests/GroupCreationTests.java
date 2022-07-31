package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test8", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    //Нахождение максимального айди группы


    // 1) путём перебора циклом
//    int max = 0;
//    for (GroupData g : after) {
//      if (g.getId() > max) {
//        max = g.getId();
//      }
//    }


    //путём возможностей Java 8, используя старые средства (анонимный класс)
//    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
//      @Override
//      public int compare(GroupData o1, GroupData o2) {
//        return Integer.compare(o1.getId(), o2.getId());
//      }
//    };
//
//    int max = after.stream().max(byId).get().getId();


    //путём возможностей Java 8, используя лямбда-выражения (анонимные функции)

//    Comparator<? super GroupData> byId =
//            (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

    int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();




    group.setId(max);
    before.add(group);

    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}