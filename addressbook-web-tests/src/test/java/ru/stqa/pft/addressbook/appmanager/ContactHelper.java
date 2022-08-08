package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class ContactHelper extends HelperBase {

  private Contacts contactCash = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group")))
              .selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void initContactModification() {
    click(By.xpath("//img[contains(@title, 'Edit')]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[contains(@title, 'Edit')]"));
  }

  public void create(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
  }

  public Contacts all() {
    if (contactCash != null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement k : elements) {
      int id = Integer.parseInt(k.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = k.findElement(By.xpath("//td[3]")).getText();
      String lastname = k.findElement(By.xpath("//td[2]")).getText();
      contactCash.add(new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname));
    }
    return new Contacts(contactCash);
  }

//  public ContactData infoFromEditForm(ContactData contact) {
//    initContactModification();
//
//
//  }
}
