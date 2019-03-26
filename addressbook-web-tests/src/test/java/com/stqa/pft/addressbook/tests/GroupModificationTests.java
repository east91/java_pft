package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupData;
import com.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().groupPage();
    Thread.sleep(100);

    if (app.group().all().size() == 0 ) {
      app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("edited test1").withHeader("edited test2").withFooter("edited test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
