package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() throws InterruptedException {
    app.getNavigationHelper().gotoGroupPage();
    Thread.sleep(100);
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().EditSelectedGroups();
    app.getGroupHelper().fillGroupForm(new GroupData("edited test1", "edited test2", "edited test3"));
    app.getGroupHelper().submitUpdateGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
