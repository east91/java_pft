package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().groupPage();
    Thread.sleep(100);

    if (app.group().List().size() == 0 ) {
      app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().List();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withName("edited test1").withHeader("edited test2").withFooter("edited test3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().List();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
