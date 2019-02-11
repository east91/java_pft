package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().gotoHomePage();
    //Thread.sleep(100);
    //int before = app.getGroupHelper().getGroupCount();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, null, null, "test1"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().gotoHomePage();
    //int after = app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after, before - 1);


  }
}
