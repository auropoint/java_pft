package ru.stqa.pft.passport.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

  public SelenideElement
    enterToRegistration = $x("//a[@href='/registration']"),
    enterToLogin = $x("//button[@data-test-id='sign-in-button']");
}
