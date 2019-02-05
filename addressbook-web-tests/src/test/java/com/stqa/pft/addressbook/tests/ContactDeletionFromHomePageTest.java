package com.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionFromHomePageTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContactsFromHomePage();
    app.getContactHelper().closeAlertPopUP();
    //Thread.sleep(5000);
  }
}
