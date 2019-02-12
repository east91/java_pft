package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionFromHomePageTest extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test1"));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContactsFromHomePage();
    app.getContactHelper().closeAlertPopUP();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);


  }
}
