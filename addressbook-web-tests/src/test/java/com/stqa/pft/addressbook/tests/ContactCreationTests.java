package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
   // int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test1"));
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
//    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
