package com.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String company;
  private final String mobile;
  private final String email;
  private String group;


  public ContactData(String firstname, String lastname, String company, String mobile, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public String getCompany() {
    return company;
  }

  public String getMobile() { return mobile; }

  public String getEmail() { return email; }

  public String getGroup() {
    return group;
  }
}
