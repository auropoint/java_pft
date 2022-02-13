package ru.stqa.pft.passport.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ru.stqa.pft.passport.pages.LoginPage;
import ru.stqa.pft.passport.pages.MainPage;

public class CommonSteps {

  public void openMainPage(){
    Selenide.open("https://qa.passport.aitusauda.kz/");
  }

  public void enterToLoginPage(){
    mainPage.enterToLogin.shouldBe(Condition.visible);
    mainPage.enterToLogin.click();
  }

  public void loginWithUsernameAndPassword(String name, String password){
    loginPage.loginInput.shouldBe(Condition.visible);
    loginPage.loginInput.setValue(name);
    loginPage.passwordInput.setValue(password);
    loginPage.enterButton.click();
  }



  MainPage mainPage = new MainPage();
  LoginPage loginPage = new LoginPage();

}
