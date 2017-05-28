/*
 * Copyright 2017 Makoto Consulting Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.makotojava.learn.junit5.math.solution;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.makotojava.learn.junit5.math.YetAnotherUtility;

/**
 * Tests the PrimeTime prime number utility class.
 * 
 * Demonstrates most of the methods and variants of the Jupiter
 * {@link org.junit.jupiter.api.Assertions Assertions} class.
 * 
 * @author J Steven Perry
 *
 */
@DisplayName("Testing PrimeTime...")
@RunWith(JUnitPlatform.class)
@Tag("solution")
public class YetAnotherUtilityTest {

  /**
   * Generates a custom message using ReflectionToStringBuilder.
   * 
   * @param expectedResults
   *          The expected results
   * @param actualResults
   *          The actual results
   * @return String - the message
   */
  private String generateCustomMessage(Object expectedResults, Object actualResults) {
    return "Expected " + ReflectionToStringBuilder.toString(expectedResults) + " but instead got: "
        + ReflectionToStringBuilder.toString(actualResults);
  }

  /**
   * Utility method. Converts an array of primitives into a List
   * of the corresponding boxed type.
   * 
   * @param actualResults
   *          The array of primitives
   * 
   * @return List - the resulting List of the primitives' corresponding boxed type
   */
  private List<Long> primitiveArrayAsList(long[] actualResults) {
    // Convert this long[] to a List<Long>, which is Iterable
    List<Long> actualResultsIterable = new ArrayList<>();
    for (long actualResult : actualResults) {
      actualResultsIterable.add(actualResult);
    }
    return actualResultsIterable;
  }

  /**
   * @Nested class.
   *         Uses Assertions.assertArrayEquals():
   *         <ul>
   *         <li>assertArrayEquals(expected, actual)</li>
   *         <li>assertArrayEquals(expected, actual, String)</li>
   *         <li>assertArrayEquals(expected, actual, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertArrayEquals...")
  public class AssertArrayEquals {

    @Test
    @DisplayName("computeFactors of 733 should return long[] = { 1, 733 }")
    void computeFactorsOfPrime() {
      long compoundInteger = 733;
      long[] expectedResults = { 1, 733 };
      long[] actualResults = YetAnotherUtility.computeFactors(compoundInteger);
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertArrayEquals(expectedResults, actualResults, () -> generateCustomMessage(expectedResults, actualResults));
    }

    @Test
    @DisplayName("computeFactors of 1023 should return long[] = { 1, 3, 11, 31, 33, 93, 341, 1023 }")
    void computeFactorsOfNonPrime() {
      long compoundInteger = 1023;
      long[] expectedResults = { 1, 3, 11, 31, 33, 93, 341, 1023 };
      long[] actualResults = YetAnotherUtility.computeFactors(compoundInteger);
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertArrayEquals(expectedResults, actualResults, () -> generateCustomMessage(expectedResults, actualResults));
    }

    @Test
    @DisplayName("isPrime for 1, 13, 21, 39, 53, 71 should return boolean[] = { false, true, false, false, true, true }")
    void isPrime() {
      boolean[] expectedResults = { false, true, false, false, true, true };
      boolean[] actualResults = new boolean[6];
      actualResults[0] = YetAnotherUtility.isPrime(1);
      actualResults[1] = YetAnotherUtility.isPrime(13);
      actualResults[2] = YetAnotherUtility.isPrime(21);
      actualResults[3] = YetAnotherUtility.isPrime(39);
      actualResults[4] = YetAnotherUtility.isPrime(53);
      actualResults[5] = YetAnotherUtility.isPrime(71);
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertArrayEquals(expectedResults, actualResults, () -> generateCustomMessage(expectedResults, actualResults));
    }

    @Test
    @DisplayName("computePrimes for 10 primes returns 2, 3, 5, 7, 11, 13, 17, 19, 23, 29")
    void computePrimes() {
      long[] expectedResults = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
      long[] actualResults = YetAnotherUtility.computePrimes(10);
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertArrayEquals(expectedResults, actualResults, () -> generateCustomMessage(expectedResults, actualResults));
    }

  }

  /**
   * @Nested class.
   *         Uses Assertions.assertEquals()
   *         <ul>
   *         <li>assertEquals(expected, actual)</li>
   *         <li>assertEquals(expected, actual, String)</li>
   *         <li>assertEquals(expected, actual, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertEquals...")
  public class AssertEquals {

    @Test
    @DisplayName("computeFactors of 733 should return long[] = { 1, 733 }")
    void computeFactorsOfPrime() {
      long compoundInteger = 733;
      long[] expectedResults = { 1, 733 };
      long[] actualResults = YetAnotherUtility.computeFactors(compoundInteger);
      assertEquals(expectedResults.length, actualResults.length);
      for (int aa = 0; aa < expectedResults.length; aa++) {
        //
        // Supplier<String> message - creates String lazily (only if assertion fails)
        {
          int index = aa;
          assertEquals(expectedResults[index], actualResults[index],
              () -> generateCustomMessage(expectedResults[index], actualResults[index]));
        }
      }
    }

    @Test
    @DisplayName("computeFactors of 1023 should return long[] = { 1, 3, 11, 31, 33, 93, 341, 1023 }")
    void computeFactorsOfNonPrime() {
      long compoundInteger = 1023;
      long[] expectedResults = { 1, 3, 11, 31, 33, 93, 341, 1023 };
      long[] actualResults = YetAnotherUtility.computeFactors(compoundInteger);
      assertEquals(expectedResults.length, actualResults.length,
          generateCustomMessage(expectedResults.length, actualResults.length));
      for (int aa = 0; aa < expectedResults.length; aa++) {
        //
        // Supplier<String> message - creates String lazily (only if assertion fails)
        {
          int index = aa;
          assertEquals(expectedResults[index], actualResults[index],
              () -> generateCustomMessage(expectedResults[index], actualResults[index]));
        }
      }
    }

    @Test
    @DisplayName("isPrime for 1, 13, 21, 39, 53, 71 should be false, true, false, false, true, true")
    void isPrime() {
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      // The string can be a literal like below.
      assertEquals(false, YetAnotherUtility.isPrime(1), () -> "The number 1 is *not* prime.");
      assertEquals(true, YetAnotherUtility.isPrime(13), () -> "The number 13 *is* prime.");
      assertEquals(false, YetAnotherUtility.isPrime(21), () -> "The number 21 is *not* prime.");
      assertEquals(false, YetAnotherUtility.isPrime(39), () -> "The number 39 is *not* prime.");
      assertEquals(true, YetAnotherUtility.isPrime(53), () -> "The number 53 *is* prime.");
      assertEquals(true, YetAnotherUtility.isPrime(71), () -> "The number 71 *is* prime.");

    }

    @Test
    @DisplayName("computePrimes for 10 primes returns 2, 3, 5, 7, 11, 13, 17, 19, 23, 29")
    void computePrimes() {
      long[] expectedResults = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
      long[] actualResults = YetAnotherUtility.computePrimes(10);
      for (int aa = 0; aa < expectedResults.length; aa++) {
        //
        // Supplier<String> message - creates String lazily (only if assertion fails)
        {
          int index = aa;
          assertEquals(expectedResults[index], actualResults[index],
              () -> generateCustomMessage(expectedResults[index], actualResults[index]));
        }
      }
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertFalse():
   *         <ul>
   *         <li>assertFalse(boolean)</li>
   *         <li>assertFalse(boolean, String)</li>
   *         <li>assertFalse(BooleanSupplier)</li>
   *         <li>assertFalse(boolean, Supplier&lt;String&gt;)</li>
   *         <li>assertFalse(BooleanSupplier, String)</li>
   *         <li>assertFalse(BooleanSupplier, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertFalse...")
  public class AssertFalse {

    @Test
    @DisplayName("isPrime for 21 should return false")
    public void isPrime() {
      long candidateInteger = 21;

      // assertFalse(BooleanSupplier, Supplier<String>)
      assertFalse(() -> YetAnotherUtility.isPrime(candidateInteger),
          () -> candidateInteger + " was expected *not* to be prime.");
    }

  }

  /**
   * @Nested class.
   *         Uses Assertions.assertIterableEquals():
   *         <ul>
   *         <li>assertIterableEquals(Iterable&lt;?&gt;, Iterable&lt;?&gt;)</li>
   *         <li>assertIterableEquals(Iterable&lt;?&gt;, Iterable&lt;?&gt;, String)</li>
   *         <li>assertIterableEquals(Iterable&lt;?&gt;, Iterable&lt;?&gt;, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertIterableEquals...")
  public class AssertIterableEquals {

    @Test
    @DisplayName("computeFactors of 733 should return long[] = { 1, 733 }")
    void computeFactorsOfPrime() {
      long compoundInteger = 733;
      List<Long> expectedResultsIterable = Arrays.asList(new Long[] { 1L, 733L });

      List<Long> actualResultsIterable = primitiveArrayAsList(YetAnotherUtility.computeFactors(compoundInteger));
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertIterableEquals(expectedResultsIterable, actualResultsIterable,
          () -> generateCustomMessage(expectedResultsIterable, actualResultsIterable));
    }

    @Test
    @DisplayName("computeFactors of 1023 should return long[] = { 1, 3, 11, 31, 33, 93, 341, 1023 }")
    void computeFactorsOfNonPrime() {
      long compoundInteger = 1023;
      List<Long> expectedResultsIterable = Arrays.asList(new Long[] { 1L, 3L, 11L, 31L, 33L, 93L, 341L, 1023L });

      List<Long> actualResultsIterable = primitiveArrayAsList(YetAnotherUtility.computeFactors(compoundInteger));
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertIterableEquals(expectedResultsIterable, actualResultsIterable,
          () -> generateCustomMessage(expectedResultsIterable, actualResultsIterable));
    }

    @Test
    @DisplayName("isPrime for 1, 13, 21, 39, 53, 71 should be = false, true, false, false, true, true ")
    void isPrime() {
      List<Boolean> expectedResultsIterable = Arrays.asList(new Boolean[] { false, true, false, false, true, true });
      List<Boolean> actualResultsIterable = new ArrayList<>();
      actualResultsIterable.add(YetAnotherUtility.isPrime(1));
      actualResultsIterable.add(YetAnotherUtility.isPrime(13));
      actualResultsIterable.add(YetAnotherUtility.isPrime(21));
      actualResultsIterable.add(YetAnotherUtility.isPrime(39));
      actualResultsIterable.add(YetAnotherUtility.isPrime(53));
      actualResultsIterable.add(YetAnotherUtility.isPrime(71));

      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertIterableEquals(expectedResultsIterable, actualResultsIterable,
          () -> generateCustomMessage(expectedResultsIterable, actualResultsIterable));
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertLinesMatch():
   *         <ul>
   *         <li>assertLinesMatch(List&lt;String&gt;, List&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertLinesMatch")
  public class AssertLinesMatch {

    @Test
    @DisplayName("tokenize returns the correct tokens from the test string...")
    public void testTokenize() {
      String string = "This is a string of words,delimited by spaces, and, well, commas. Oh, and periods too.";
      String delimiters = " ,.";

      List<String> expectedTokens = Arrays.asList(new String[] {
          "This", "is", "a", "string", "of", "words", "delimited",
          "by", "spaces", "and", "well", "commas", "Oh",
          "and", "periods", "too"
      });

      List<String> actualTokens = YetAnotherUtility.tokenize(string, delimiters);

      assertLinesMatch(expectedTokens, actualTokens);
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertNotEquals():
   *         <ul>
   *         <li>assertNotEquals(Object)</li>
   *         <li>assertNotEquals(Object, String)</li>
   *         <li>assertNotEquals(Object, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertNotEquals...")
  public class AssertNotEquals {

    @Test
    @DisplayName("isPrime for 1, 13, 21, 39, 53, 71 should be = false, true, false, false, true, true ")
    void isPrime() {

      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertNotEquals(true, YetAnotherUtility.isPrime(1), () -> "The number 1 is *not* prime.");
      assertNotEquals(false, YetAnotherUtility.isPrime(13), () -> "The number 13 *is* prime.");
      assertNotEquals(true, YetAnotherUtility.isPrime(21), () -> "The number 21 is *not* prime.");
      assertNotEquals(true, YetAnotherUtility.isPrime(39), () -> "The number 39 is *not* prime.");
      assertNotEquals(false, YetAnotherUtility.isPrime(53), () -> "The number 53 *is* prime.");
      assertNotEquals(false, YetAnotherUtility.isPrime(71), () -> "The number 71 *is* prime.");
    }
  }

  /**
   * @Nested class
   *         Uses Assertions.assertNotNull():
   *         <ul>
   *         <li>assertNotNull(Object)</li>
   *         <li>assertNotNull(Object, String)</li>
   *         <li>assertNotNull(Object, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertNotNull...")
  public class AssertNotNull {

    @Test
    @DisplayName("computeFactors of 733 should return a non-null array of factors")
    void computeFactors() {
      long candidateInteger = 733;
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertNotNull(YetAnotherUtility.computeFactors(candidateInteger),
          () -> candidateInteger + " was expected to return a non-null array of factors");
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertNotSame():
   *         <ul>
   *         <li>assertNotSame(Object)</li>
   *         <li>assertNotSame(Object, String)</li>
   *         <li>assertNotSame(Object, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertNotSame")
  public class AssertNotSame {

    @Test
    @DisplayName("tokenize returns the correct tokens from the test string...")
    public void testTokenize() {
      String string = "This is a string of words,delimited by spaces, and, well, commas. Oh, and periods too.";
      String delimiters = " ,.";

      List<String> expectedTokens = Arrays.asList(new String[] {
          "This", "is", "a", "string", "of", "words", "delimited",
          "by", "spaces", "and", "well", "commas", "Oh",
          "and", "periods", "too"
      });

      List<String> actualTokens = YetAnotherUtility.tokenize(string, delimiters);
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertNotSame(expectedTokens, actualTokens, () -> "Expected lists to be different objects");

      // As are the strings that are returned as well
      for (int aa = 0; aa < expectedTokens.size(); aa++) {
        //
        // Supplier<String> message - creates String lazily (only if assertion fails)
        assertNotSame(expectedTokens.get(aa), actualTokens.get(aa), "Expected objects to be different");
      }

    }

    @Test
    @DisplayName("Different references to the same string are the same object...")
    public void testAssertNotSame() {
      String expectedString = "this is a string of words".toUpperCase();
      String actualString = "this is a string of words".toUpperCase();
      //
      // The strings are .equals(), but different objects
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertNotSame(expectedString, actualString, () -> "Expected strings to be the same objects");

    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertNull():
   *         <ul>
   *         <li>assertNull(Object)</li>
   *         <li>assertNull(Object, String)</li>
   *         <li>assertNull(Object, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertNull...")
  public class AssertNull {

    @Test
    @DisplayName("computeFactors of 0 should return null")
    void computeFactors() {
      long candidateInteger = 0;
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertNull(YetAnotherUtility.computeFactors(candidateInteger),
          () -> candidateInteger + " was expected to return null");
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertThrows():
   *         <ul>
   *         <li>assertThrows(Class&lt;T extends Throwable&gt;, Executable)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertTimeout...")
  public class AssertThrows {

    @Test
    @DisplayName("isPrime with negative number throws IllegalArgumentException")
    void isPrime() {
      //
      // If PrimeTime.isPrime() called with a negative number: IllegalArgumentException
      assertThrows(IllegalArgumentException.class, () -> YetAnotherUtility.isPrime(-100L));
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertTimeout():
   *         <ul>
   *         <li>assertTimeout(Duration, Executable)</li>
   *         <li>assertTimeout(Duration, Executable, String)</li>
   *         <li>assertTimeout(Duration, Executable, Supplier&lt;String&gt;)</li>
   *         <li>assertTimeout(Duration, ThrowingSupplier&lt;T&gt;)</li>
   *         <li>assertTimeout(Duration, ThrowingSupplier&lt;T&gt;, String)</li>
   *         <li>assertTimeout(Duration, ThrowingSupplier&lt;T&gt;, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertTimeout - exexutes in same Thread as Test...")
  public class AssertTimeout {

    @Test
    @DisplayName("computeFactors with 32767 * 10000 completes before 5000 ms")
    void computeFactors() {
      long compoundInteger = 32767L * 10000L;
      // Set Duration to 5000ms
      Duration timeout = Duration.ofMillis(5000);
      assertTimeout(timeout, () -> YetAnotherUtility.computeFactors(compoundInteger),
          () -> "Expected factorization of " + compoundInteger + " to complete before timeout of " + timeout.toMillis()
              + "ms");
    }

    @Test
    @DisplayName("isPrime with 2000 primes completes before 5000ms")
    void isPrime() {
      int numberOfPrimesToCompute = 2000;
      // Set timeout to 5000 ms
      Duration timeout = Duration.ofMillis(5000);
      assertTimeout(timeout, () -> YetAnotherUtility.computePrimes(numberOfPrimesToCompute),
          () -> "Expected to compute " + numberOfPrimesToCompute + " before timeout of " + timeout.toMillis() + "ms");
    }
  }

  /**
   * @Nested class
   *         Uses Assertions.assertTimeoutPreemptively():
   *         <ul>
   *         <li>assertTimeoutPreemptively(Duration, Executable)</li>
   *         <li>assertTimeoutPreemptively(Duration, Executable, String)</li>
   *         <li>assertTimeoutPreemptively(Duration, Executable, Supplier&lt;String&gt;)</li>
   *         <li>assertTimeoutPreemptively(Duration, ThrowingSupplier&lt;T&gt;)</li>
   *         <li>assertTimeoutPreemptively(Duration, ThrowingSupplier&lt;T&gt;, String)</li>
   *         <li>assertTimeoutPreemptively(Duration, ThrowingSupplier&lt;T&gt;, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertTimeout - exexutes on different Thread from Test...")
  public class AssertTimeoutPreemptively {

    @Test
    @DisplayName("computeFactors with 32767 * 10000 completes before 5000 ms")
    void computeFactors() {
      long compoundInteger = 32767L * 10000L;
      // Set Duration to 5000ms
      Duration timeout = Duration.ofMillis(5000);
      //
      assertTimeoutPreemptively(timeout, () -> YetAnotherUtility.computeFactors(compoundInteger),
          () -> "Expected factorization of " + compoundInteger + " to complete before timeout of " + timeout.toMillis()
              + "ms");
    }

    @Test
    @DisplayName("isPrime with 2000 primes completes before 5000ms")
    void isPrime() {
      int numberOfPrimesToCompute = 2000;
      // Set timeout to 5000 ms
      Duration timeout = Duration.ofMillis(5000);
      //
      assertTimeoutPreemptively(timeout, () -> YetAnotherUtility.computePrimes(numberOfPrimesToCompute),
          () -> "Expected to compute " + numberOfPrimesToCompute + " before timeout of " + timeout.toMillis() + "ms");
    }
  }

  /**
   * @Nested class
   *         Uses Assertions.assertTrue():
   *         <ul>
   *         <li>assertTrue(boolean)</li>
   *         <li>assertTrue(boolean, String)</li>
   *         <li>assertTrue(BooleanSupplier)</li>
   *         <li>assertTrue(boolean, Supplier&lt;String&gt;)</li>
   *         <li>assertTrue(BooleanSupplier, String)</li>
   *         <li>assertTrue(BooleanSupplier, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertTrue with assertAll...")
  public class AssertTrue {

    @Test
    @DisplayName("isPrime for 23 should return true")
    public void isPrime() {
      long candidateInteger = 23;

      assertAll("Oh, look, it's a gaggle of Assertions",
          // AssertTrue(BooleanSupplier, String)
          () -> assertTrue(() -> YetAnotherUtility.isPrime(candidateInteger),
              candidateInteger + " was expected to be prime."),

          // AssertTrue(BooleanSupplier, Supplier<String>)
          () -> assertTrue(() -> YetAnotherUtility.isPrime(candidateInteger),
              () -> candidateInteger + " was expected to be prime."));
    }

  }

  /**
   * @Nested class
   *         Uses Assertions.assertSame():
   *         <ul>
   *         <li>assertSame(Object)</li>
   *         <li>assertSame(Object, String)</li>
   *         <li>assertSame(Object, Supplier&lt;String&gt;)</li>
   *         </ul>
   * @author J Steven Perry
   *
   */
  @Nested
  @DisplayName("When using assertSame")
  public class AssertSame {

    @Test
    @DisplayName("Different references to the same string are the same object...")
    public void testAssertSame() {
      String expectedString = "This is a string of words,delimited by spaces, and, well, commas. Oh, and periods too.";
      String actualString = expectedString;
      //
      // The list that is returned is different
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertSame(expectedString, actualString, () -> "Expected strings to be the same objects");

    }

    @Test
    @DisplayName("Different references to the same string are the same object...")
    public void testAssertSameWithStringLiterals() {
      String expectedString = "This is a string of words";
      String actualString = "This is a string of words";
      //
      // The strings are .equals(), but different objects (or are they? no, no they're not)
      //
      // Supplier<String> message - creates String lazily (only if assertion fails)
      assertSame(expectedString, actualString, () -> "Expected strings to be the same objects");

    }

  }

}
