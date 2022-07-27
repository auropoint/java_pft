package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.Objects;

public class ApplicationManager {

  WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {

    if (Objects.equals(browser, "FIREFOX")) {
      wd = new FirefoxDriver();
    } else if (Objects.equals(browser, "CHROME")) {
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, "IE")) {
      wd = new InternetExplorerDriver();
    }


    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    wd.get("http://localhost/addressbook/group.php");
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    navigationHelper = new NavigationHelper(wd);
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
  }

  public void stop() {
    wd.quit();
  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
