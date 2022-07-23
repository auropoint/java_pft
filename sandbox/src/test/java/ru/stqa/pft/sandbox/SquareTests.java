package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void TestArea() {
    Square s = new Square(5);

//    assert s.area() == 24;

    //в этом варианте при ошибке будет показано и вычисленное, и ожидаемое значение
    Assert.assertEquals(s.area(), 25);

  }

}
