package ru.stqa.pft.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int numberOfRoots;

  public Equation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;

    if (a != 0) {
      if (d > 0) {
        numberOfRoots = 2;
      } else if (d == 0) {
        numberOfRoots = 1;
      } else {
        numberOfRoots = 0;
      }
    } else if (b != 0) {
      numberOfRoots = 1;
    } else if (c != 0) {
      numberOfRoots = 1;
    } else {
      numberOfRoots = -1;
    }
  }

  public int rootNumber() {
    return numberOfRoots;
  }

}
