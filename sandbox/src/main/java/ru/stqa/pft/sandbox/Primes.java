package ru.stqa.pft.sandbox;

public class Primes {

  public static boolean isPrimeFor(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeForShort(int n) {
    for (int i = 2; i < n && n % i == 0; i++) {
      return false;
    }
    return true;
  }


  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n) {
      if (n % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }

  public static boolean isPrimeWhileShort(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
      }
    return i == n;
  }




  public static boolean isPrimeForSqrt(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeForLongType(long n) {
    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }



}
