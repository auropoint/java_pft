package ru.stqa.pft.addressbook.model;

import ru.stqa.pft.addressbook.appmanager.NavigationHelper;

public class ContactData {

  public int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String group;

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

}