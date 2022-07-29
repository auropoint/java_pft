package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrimeFor() {
    Assert.assertTrue(Primes.isPrimeFor(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeForNot() {
    Assert.assertFalse(Primes.isPrimeFor(6));
  }


  @Test
  public void testPrimeForShort() {
    Assert.assertTrue(Primes.isPrimeForShort(5));
  }

  @Test
  public void testPrimeForShortNot() {
    Assert.assertFalse(Primes.isPrimeForShort(6));
  }


  @Test
  public void testPrimeWhile() {
    Assert.assertTrue(Primes.isPrimeWhile(5));
  }

  @Test
  public void testPrimeWhileNot() {
    Assert.assertFalse(Primes.isPrimeWhile(6));
  }


  @Test
  public void testPrimeWhileShort() {
    Assert.assertTrue(Primes.isPrimeWhileShort(5));
  }

  @Test
  public void testPrimeWhileShortNot() {
    Assert.assertFalse(Primes.isPrimeWhileShort(6));
  }





  @Test
  public void testPrimeForSqrt() {
    Assert.assertTrue(Primes.isPrimeForSqrt(Integer.MAX_VALUE));
  }


  @Test (enabled = false)
  public void testPrimeLongtype() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeForLongType(n));
  }




}
