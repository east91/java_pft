package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().EditSelectedGroups();
    app.getGroupHelper().fillGroupForm(new GroupData("edited test1", "edited test2", "edited test3"));
    app.getGroupHelper().submitUpdateGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}
