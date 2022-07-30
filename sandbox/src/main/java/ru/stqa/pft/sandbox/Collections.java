package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";


    String[] langs2 = {"Java", "C#", "Python", "PHP"};
    for (int i = 0; i < langs2.length; i++) {
      System.out.println("Массив " + langs2[i]);
    }

    String[] langs3 = {"Java", "C#", "Python", "PHP"};
    for (String l : langs3) {
      System.out.println("Массив " + l);
    }


    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    System.out.println(languages.size());
    for (String l : languages) {
      System.out.println("Список " + l);
    }


    List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");
//    languages2.add("Java2"); doesn't work
    System.out.println("Список через массив, длина " + languages2.size());

    for (int i = 0; i < languages2.size(); i++) {
      System.out.println("Список через массив " + languages2.get(i));
    }

    for (String l : languages2) {
      System.out.println("Список через массив " + l);
    }





  }
}
