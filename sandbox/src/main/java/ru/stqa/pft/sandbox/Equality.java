package ru.stqa.pft.sandbox;

public class Equality {
  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = s1;

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));


    String q1 = "chrome";
    String q2 = new String(q1);

    System.out.println(q1 == q2);
    System.out.println(q1.equals(q2));


    String r1 = "ie2.0";
    String r2 = "ie2.0";
    String r3 = "ie" + "2.0";
    String r4 = "ie" + Math.sqrt(4);

    System.out.println(r1 == r2);
    System.out.println(r1 == r3);
    System.out.println(r1 == r4);

    System.out.println(r1);
    System.out.println(r4);

  }
}
