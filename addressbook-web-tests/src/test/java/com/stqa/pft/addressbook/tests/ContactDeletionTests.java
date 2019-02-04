package com.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  //gotoContactPage();
  @Test
  public void testContactDeletion() {
    app.gotoHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().deleteSelectedContacts();
  }
}
