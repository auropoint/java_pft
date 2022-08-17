package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactModificationTests extends TestBase {

  @Test(enabled = true)
  public void testContactModification() {

    Groups groups = app.db().groups();

    app.goTo().gotoHomePage();

    if (!app.contact().isThereAContact()) {
      File photo = new File("src/test/resources/stru.png");
      app.contact().create(new ContactData()
              .withFirstname("test_name")
              .withLastname("test_surname")
              .inGroup(groups.iterator().next())
              .withPhoto(photo));
      app.goTo().gotoHomePage();
    }

    app.contact().initContactModification();
    File photo = new File("src/test/resources/stru.png");
    app.contact().fillContactForm(new ContactData()
            .withFirstname("test_name")
            .withLastname("test_surname")
            .inGroup(groups.iterator().next())
            .withPhoto(photo), false);
    app.contact().submitContactModification();
    app.goTo().gotoHomePage();
    verifyContactListInUi();
  }
}