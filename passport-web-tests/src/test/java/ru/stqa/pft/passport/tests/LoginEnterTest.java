package ru.stqa.pft.passport.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.pft.passport.steps.CommonSteps;
import ru.stqa.pft.passport.testData.PassportTestData;

public class LoginEnterTest {

  @Test
  public void loggingIn() {
    commonSteps.openMainPage();
    commonSteps.enterToLoginPage();
    commonSteps.loginWithUsernameAndPassword(PassportTestData.username, PassportTestData.password);
  }

  CommonSteps commonSteps = new CommonSteps();

}
