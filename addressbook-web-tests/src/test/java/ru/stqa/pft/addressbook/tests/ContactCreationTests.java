package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Groups groups = app.db().groups();

    File photo = new File("src/test/resources/stru.png");

    ContactData newContact = new ContactData()
            .withFirstname("test_name")
            .withLastname("test_surname")
            .withHomePhone("+567 (567) 00-01")
            .withMobilePhone("+567 (567) 00-02")
            .withWorkPhone("+567 (567) 00-03")
            .inGroup(groups.iterator().next())
            .withPhoto(photo);

    app.contact().create(newContact);
    app.goTo().gotoHomePage();
    verifyContactListInUi();
  }

  @Test (enabled = true)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println("**********   " + currentDir.getAbsolutePath() + "   **********");
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }


}