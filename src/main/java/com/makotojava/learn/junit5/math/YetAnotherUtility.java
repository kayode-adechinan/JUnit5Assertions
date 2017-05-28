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
package com.makotojava.learn.junit5.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Simple set of utilities. Just something to demonstrate tests.
 * Nothing more.
 * 
 * @author J Steven Perry
 *
 */
public class YetAnotherUtility {

  /**
   * 
   * Uses the slow but steady Trial Division algorithm for calculating
   * factors.
   * 
   * https://en.wikipedia.org/wiki/Trial_division
   * 
   * @param compoundInteger
   *          The integer number (using the mathematical term "integer" here,
   *          not the Java primitive type) to check.
   *          The compound integer must be greater than zero.
   * 
   * @return long[] - an array of factors. Will be null if the compound integer is
   *         less than or equal to zero.
   */
  public static long[] computeFactors(long compoundInteger) {
    long[] ret = null;
    if (compoundInteger > 0) {
      //
      Set<Long> factors = new TreeSet<>();
      //
      // The number itself is always a factor
      factors.add(compoundInteger);
      factors.add(1L);// And 1, of course
      long upperLimit = compoundInteger / 2;
      long trialDivisor = 2;
      while (trialDivisor <= upperLimit) {
        if (compoundInteger % trialDivisor == 0) {
          factors.add(trialDivisor);
        }
        trialDivisor++;
      }
      //
      // Now make a copy of the Set
      ret = new long[factors.size()];
      int aa = 0;// Oh my, can you figure out what this is used for?
      Iterator<Long> iter = factors.iterator();
      while (iter.hasNext()) {
        ret[aa++] = iter.next();
      }
    }
    //
    return ret;
  }

  /**
   * Determines whether or not the candidate integer number is
   * a prime number.
   * 
   * @param candidateInteger
   *          The integer number (using the mathematical term "integer" here,
   *          not the Java primitive type) to check.
   *          The candidate must be greater than zero.
   * @return boolean - true if the candidate integer is prime, false otherwise.
   * 
   * @throws IllegalArgumentException
   *           If the candidate integer is less than zero.
   */
  public static boolean isPrime(long candidateInteger) {
    if (candidateInteger < 0) {
      throw new IllegalArgumentException(
          "Negative numbers cannot be prime (https://en.wikipedia.org/wiki/Prime_number");
    }

    return computeFactors(candidateInteger).length == 2;
  }

  public static int MIN_NUMBER_OF_PRIMES = 1;
  public static int MAX_NUMBER_OF_PRIMES = 2000;

  /**
   * Computes the specified number of primes.
   * 
   * @param numberOfPrimesToCalculate
   *          The number of primes to calculate.
   * 
   * @return long[] - the primes that were calculated. Will be null if none
   *         were calculated.
   */
  public static long[] computePrimes(int numberOfPrimesToCalculate) {
    long[] ret = null;

    //
    // Only calculate primes if between MIN and MAX
    if (numberOfPrimesToCalculate > MIN_NUMBER_OF_PRIMES && numberOfPrimesToCalculate <= MAX_NUMBER_OF_PRIMES) {
      List<Long> primes = new ArrayList<>();
      int numberOfPrimesSoFar = 0;
      for (long candidatePrime = 1; candidatePrime < Integer.MAX_VALUE; candidatePrime++) {
        if (YetAnotherUtility.isPrime(candidatePrime)) {
          primes.add(candidatePrime);
          numberOfPrimesSoFar++;
        }
        if (numberOfPrimesSoFar >= numberOfPrimesToCalculate) {
          break;
        }
      }
      // Now copy the List to an array of long[]
      ret = new long[primes.size()];
      for (int aa = 0; aa < primes.size(); aa++) {
        ret[aa] = primes.get(aa);
      }
    }

    return ret;
  }

  /**
   * Tokenize the specified string parameter, delimited by
   * the specified delimiters, and return the tokens in a
   * List&lt;String&gt;
   * 
   * @param string
   *          The string to tokenize
   * 
   * @param delimiters
   *          The delimiters that are used to break the string up into tokens.
   * 
   * @return List&lt;String&gt; - the List of Strings, one List element per token. The List will be empty if no tokens
   *         were found.
   */
  public static List<String> tokenize(String string, String delimiters) {
    List<String> ret = new ArrayList<>();

    StringTokenizer strtok = new StringTokenizer(string, delimiters);
    while (strtok.hasMoreTokens()) {
      ret.add(strtok.nextToken());
    }

    return ret;
  }

}
