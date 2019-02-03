package com.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  //gotoContactPage();
  @Test
  public void testContactDeletion() {
    selectContact();
    deleteSelectedContacts();
  }
}
